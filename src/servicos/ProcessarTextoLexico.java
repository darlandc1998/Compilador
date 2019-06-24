package servicos;

import enums.TiposVariaveisEnum;
import enums.terminais.CodigoCaracteresEspeciaisTerminaisEnum;
import enums.terminais.CodigoComentarioTerminaisEnum;
import enums.terminais.CodigoPalavrasTerminaisEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import models.Pilha;
import java.util.Stack;
import models.TabelaSemantica;
import utils.UtilString;

public final class ProcessarTextoLexico {

    public static Stack<Pilha> criarPilha(String codigoTexto) throws Exception {

        String caracterAtual;
        String caracterSequente = "";
        String caracterAtualESequente = "";
        String caracterAuxiliar;
        boolean utilizarCaracterSequente;
        String palavra = "";
        Stack<Pilha> pilha = new Stack<>();
        boolean comentario = false;
        int linha = 1;
        Integer nivel = 1;
        Set<TabelaSemantica> tabelaSemantica = new HashSet<>();
        boolean declarando = false;
        boolean procedure = false;

        for (int i = 0; i < codigoTexto.length(); i++) {
            caracterAtual = String.valueOf(codigoTexto.charAt(i));

            if (caracterAtual.equals("\n")) {
                linha++;
            }

            if ((i + 1) < codigoTexto.length()) {
                caracterSequente = String.valueOf(codigoTexto.charAt(i + 1));
                caracterAtualESequente = caracterAtual + caracterSequente;
            }

            if (caracterAtual.equals(CodigoCaracteresEspeciaisTerminaisEnum.MENOS.getPalavra()) && isNumber(caracterSequente)) {
                palavra += caracterAtual;
                continue;
            }

            if (caracterAtualESequente.equals(CodigoComentarioTerminaisEnum.INICIO_COMENTARIO.getPalavra())) {
                comentario = true;
                i++;
                continue;
            } else if (caracterAtualESequente.equals(CodigoComentarioTerminaisEnum.FIM_COMENTARIO.getPalavra())) {
                comentario = false;
                i++;
                continue;
            }

            if (comentario) {
                continue;
            }

            if (palavra.trim().toLowerCase().equals(CodigoPalavrasTerminaisEnum.PROCEDURE.getPalavra())) {
                procedure = true;
            }
                     

            if (palavra.trim().toLowerCase().equals(CodigoPalavrasTerminaisEnum.END.getPalavra())) {
                nivel = 1;
                procedure = false;
            }

            if (CodigoCaracteresEspeciaisTerminaisEnum.getCodigo(caracterAtualESequente) != null) {
                caracterAuxiliar = caracterAtualESequente;
                utilizarCaracterSequente = true;
            } else {
                caracterAuxiliar = caracterAtual;
                utilizarCaracterSequente = false;
            }

            for(String d: getDeclaracoes()){
                
                if(d.equals(palavra)){
                    declarando = true;
                }
            }
            
            if (palavra.trim().toLowerCase().equals(CodigoPalavrasTerminaisEnum.BEGIN.getPalavra())){
                declarando = false;
            }

            if ((caracterAuxiliar.trim().isEmpty()) || (CodigoCaracteresEspeciaisTerminaisEnum.getCodigo(caracterAuxiliar) != null)) {
                if (!palavra.trim().isEmpty()) {
                    if (CodigoPalavrasTerminaisEnum.getCodigo(palavra) != null) {
                        pilha.push(CodigoPalavrasTerminaisEnum.getCodigo(palavra).getPilha(linha));
                    } else {
                        int index = palavra.charAt(0) == '-' ? 1 : 0;

                        if (Character.isDigit(palavra.charAt(index)) && !UtilString.soContemNumeros(palavra)) {
                            throw new Exception("Não permitido iniciar uma palvavra com número e conter letras");
                        }

                        if (isNumber(palavra)) {
                            pilha.push(CodigoPalavrasTerminaisEnum.INTEIRO.getPilha(palavra, linha));
                        } else {
                            pilha.push(CodigoPalavrasTerminaisEnum.IDENTIFICADOR.getPilha(palavra, linha));

                            TabelaSemantica objSemantico = new TabelaSemantica(palavra.toUpperCase(), null, nivel);
                            if (declarando) {
                                if (!tabelaSemantica.contains(objSemantico)) {
                                    if ((!procedure) || (procedure && nivel == 2)){
                                        objSemantico.setTipo(getTipoVariavel(i, codigoTexto));
                                    }
                                    tabelaSemantica.add(objSemantico);
                                } else {
                                    throw new Exception("Variavel "+objSemantico.getNome()+" já declarada na linha "+linha);
                                }
                            } else {
                                if (!tabelaSemantica.contains(objSemantico)) {
                                    throw new Exception("Variavel "+objSemantico.getNome()+" não declarada na linha "+linha);
                                }
                            }

                        }
                        
                        if (procedure){
                            nivel = 2;
                        }
                    }
                    palavra = "";
                }

                if (!caracterAuxiliar.equals(CodigoCaracteresEspeciaisTerminaisEnum.ESPACO.getPalavra())) {
                    CodigoCaracteresEspeciaisTerminaisEnum codigoCaracterEspecialEnum = CodigoCaracteresEspeciaisTerminaisEnum.getCodigo(caracterAuxiliar);
                    if (codigoCaracterEspecialEnum != null) {
                        pilha.push(codigoCaracterEspecialEnum.getPilha(linha));
                        if (utilizarCaracterSequente) {
                            i++;
                        }
                    }
                }

                continue;
            }
            palavra += caracterAtual;
        }
        
        if (comentario) {
            throw new Exception("Comentário em aberto");
        }

        return pilha;
    }

    private static boolean isNumber(String value) {
        return value.matches("-?\\d+(\\.\\d+)?");
    }

    private static List<String> getDeclaracoes() {
        return Arrays.asList(new String[]{"LABEL", "CONST", "VAR", "PROCEDURE", "PROGRAM"});
    }
    
    private static String getTipoVariavel(Integer indexStart, String texto){
        String textoParticionado = texto.substring(indexStart);
        textoParticionado  = textoParticionado.substring(0, textoParticionado.indexOf(";"));
        
        if (textoParticionado.contains(TiposVariaveisEnum.ARRAY.toString())){
            return TiposVariaveisEnum.ARRAY.toString();
        }
        
        if (textoParticionado.contains(TiposVariaveisEnum.INTEGER.toString()) || textoParticionado.contains("=")){
            return TiposVariaveisEnum.INTEGER.toString();
        }
        
        return TiposVariaveisEnum.LITERAL.toString();
    }

}
