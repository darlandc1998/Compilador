package servicos;

import enums.TiposVariaveisEnum;
import enums.terminais.CodigoCaracteresEspeciaisTerminaisEnum;
import enums.terminais.CodigoComentarioTerminaisEnum;
import enums.terminais.CodigoPalavrasTerminaisEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
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
        String operandoChave = null;

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

            if (palavra.trim().toLowerCase().equals(CodigoPalavrasTerminaisEnum.END.getPalavra()) && procedure) {
                nivel = 1;
                procedure = false;
                tabelaSemantica = exclusao(tabelaSemantica);
            }

            if (CodigoCaracteresEspeciaisTerminaisEnum.getCodigo(caracterAtualESequente) != null) {
                caracterAuxiliar = caracterAtualESequente;
                utilizarCaracterSequente = true;
            } else {
                caracterAuxiliar = caracterAtual;
                utilizarCaracterSequente = false;
            }

            for (String d : getDeclaracoes()) {

                if (d.equals(palavra)) {
                    declarando = true;
                }
            }

            if (palavra.trim().toLowerCase().equals(CodigoPalavrasTerminaisEnum.BEGIN.getPalavra())) {
                declarando = false;
            }

            if ((caracterAuxiliar.trim().isEmpty()) || (CodigoCaracteresEspeciaisTerminaisEnum.getCodigo(caracterAuxiliar) != null)) {
                if (!palavra.trim().isEmpty()) {
                    if (CodigoPalavrasTerminaisEnum.getCodigo(palavra) != null) {
                        pilha.push(CodigoPalavrasTerminaisEnum.getCodigo(palavra).getPilha(linha));
                    } else {
                        int index = palavra.charAt(0) == '-' ? 1 : 0;

                        if (Character.isDigit(palavra.charAt(index)) && !UtilString.soContemNumeros(palavra)) {
                            throw new Exception("Não permitido iniciar uma palavra com número e conter letras");
                        }

                        if (isNumber(palavra)) {
                            pilha.push(CodigoPalavrasTerminaisEnum.INTEIRO.getPilha(palavra, linha));
                        } else {
                            pilha.push(CodigoPalavrasTerminaisEnum.IDENTIFICADOR.getPilha(palavra, linha));

                            TabelaSemantica objSemantico = new TabelaSemantica(palavra.toUpperCase(), null, nivel);
                            if (declarando) {
                                if (!tabelaSemantica.contains(objSemantico)) {
                                    if ((!procedure) || (procedure && nivel == 2)) {
                                        objSemantico.setTipo(getTipoVariavel(i, codigoTexto));
                                    }
                                    tabelaSemantica.add(objSemantico);
                                } else {
                                    throw new Exception("Variável " + objSemantico.getNome() + " já declarada. Linha " + linha);
                                }
                            } else {
                                List<TabelaSemantica> listaTabelaSemantica = new ArrayList<>(tabelaSemantica);

                                if (!listaTabelaSemantica.contains(objSemantico)) {
                                    throw new Exception("Variável " + objSemantico.getNome() + " não declarada. Linha " + linha);
                                }

                                objSemantico = listaTabelaSemantica.get(listaTabelaSemantica.indexOf(objSemantico));

                                if (operandoChave != null && !operandoChave.trim().isEmpty()) {
                                    int indexOperando = listaTabelaSemantica.indexOf(new TabelaSemantica(operandoChave.toUpperCase(), null, nivel));
                                    if (indexOperando > -1) {
                                        TabelaSemantica objSemanticoChave = listaTabelaSemantica.get(indexOperando);
                                        if (!objSemanticoChave.getTipo().equals(objSemantico.getTipo())) {
                                            throw new Exception("Para realizar operação, os tipos devem ser iguais.");
                                        }
                                    }
                                }
                            }

                        }

                        if (procedure) {
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

                        if (codigoCaracterEspecialEnum.equals(CodigoCaracteresEspeciaisTerminaisEnum.DOIS_PONTOS_IGUAL)) {
                            operandoChave = pilha.get(pilha.size() - 2).getDescricao();
                        }

                        if (codigoCaracterEspecialEnum.equals(CodigoCaracteresEspeciaisTerminaisEnum.PONTO_VIRGULA)) {
                            operandoChave = null;
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

    private static String getTipoVariavel(Integer indexStart, String texto) {
        String textoParticionado = texto.substring(indexStart);
        textoParticionado = textoParticionado.substring(0, textoParticionado.indexOf(";"));

        if (textoParticionado.contains(TiposVariaveisEnum.ARRAY.toString())) {
            return TiposVariaveisEnum.ARRAY.toString();
        }

        if (textoParticionado.contains(TiposVariaveisEnum.INTEGER.toString()) || textoParticionado.contains("=")) {
            return TiposVariaveisEnum.INTEGER.toString();
        }

        return TiposVariaveisEnum.LITERAL.toString();
    }

    private static Set exclusao(Set<TabelaSemantica> tabelaSemantica) {

        //usando o Iterator, pois não se pode remover um item de uma lista equanto percorrendoa mesma.
        for (Iterator<TabelaSemantica> i = tabelaSemantica.iterator(); i.hasNext();) {

            int nivel = i.next().getNivel();

            if (nivel == 2) {
                i.remove();
            }
        }

        return tabelaSemantica;
    }
}
