package servicos;

import enums.naoTerminais.CodigoPalavrasNaoTerminaisEnum;
import enums.parsing.TabelaParsingEnum;
import enums.terminais.CodigoCaracteresEspeciaisTerminaisEnum;
import enums.terminais.CodigoComentarioTerminaisEnum;
import enums.terminais.CodigoPalavrasTerminaisEnum;
import java.util.Stack;
import models.Pilha;


public final class ProcessarTextoSintatico {

    public static void debugarSintaxe(Stack<Pilha> pilhaSintatica, Stack<Pilha> pilhaLexica) throws Exception {

        if (pilhaSintatica.isEmpty()) {
            return;
        }

        Pilha pSintatica = pilhaSintatica.peek();
        Pilha pLexica = pilhaLexica.peek();
        
        if (pSintatica.getCodigo() < 52) {

            if (pSintatica.getCodigo().equals(pLexica.getCodigo())) {
                pilhaSintatica.pop();
                pilhaLexica.pop();
            } else {
                throw new Exception("Erro '" + getProximoValorTerminal(pilhaSintatica).getDescricao() + "' - linha " + (pLexica.getLinha() - 1));
            }

        } else {

            TabelaParsingEnum tbParsing;

            if ((tbParsing = TabelaParsingEnum.getValueByKeys(pSintatica.getCodigo(), pLexica.getCodigo())) != null) {
                pilhaSintatica.pop();
                
                for (String value : tbParsing.getProducoesInvertida()) {

                    CodigoCaracteresEspeciaisTerminaisEnum cEspeciaisEnum;
                    if ((cEspeciaisEnum = CodigoCaracteresEspeciaisTerminaisEnum.getCodigo(value)) != null) {
                        pilhaSintatica.add(cEspeciaisEnum.getPilha());
                    }

                    CodigoComentarioTerminaisEnum comentarioEnum;
                    if ((comentarioEnum = CodigoComentarioTerminaisEnum.getCodigo(value)) != null) {
                        pilhaSintatica.add(comentarioEnum.getPilha());
                    }

                    CodigoPalavrasTerminaisEnum palavraEnum;
                    if ((palavraEnum = CodigoPalavrasTerminaisEnum.getCodigo(value)) != null) {
                        pilhaSintatica.add(palavraEnum.getPilha());
                    }

                    CodigoPalavrasNaoTerminaisEnum naoTerminaisEnum;
                    if ((naoTerminaisEnum = CodigoPalavrasNaoTerminaisEnum.getCodigo(value)) != null) {
                        pilhaSintatica.add(naoTerminaisEnum.getPilha());
                    }
                }

            } else {
                throw new Exception("Erro '" + getProximoValorTerminal(pilhaSintatica).getDescricao() + "' - linha " + (pLexica.getLinha() - 1));
            }
        }
        
    }

    private static Pilha getProximoValorTerminal(Stack<Pilha> pilhaSintatica) {
        for (int i = (pilhaSintatica.size() - 1); i >= 0; i--) {
            Pilha p = pilhaSintatica.get(i);

            if (CodigoCaracteresEspeciaisTerminaisEnum.getCodigo(p.getDescricao()) != null) {
                return p;
            }

            if (CodigoPalavrasTerminaisEnum.getCodigo(p.getDescricao()) != null) {
                return p;
            }
        }

        return null;
    }

    

}
