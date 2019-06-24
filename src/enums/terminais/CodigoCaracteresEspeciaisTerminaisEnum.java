package enums.terminais;

import models.Pilha;


public enum CodigoCaracteresEspeciaisTerminaisEnum {
    
    MAIS(30, "+"),
    MENOS(31, "-"),
    ASTERISCO(32, "*"),
    BARRA(33, "/"),
    COLCHETE_D(34, "]"),
    COLCHETE_E(35, "["),
    PARENTESES_D(36, "("),
    PARENTESES_E(37, ")"),
    DOIS_PONTOS_IGUAL(38, ":="),
    DOIS_PONTOS(39, ":"),
    IGUAL(40, "="),
    MAIOR(41, ">"),
    MAIOR_IGUAL(42, ">="),
    MENOR(43, "<"),
    MENOR_IGUAL(44, "<="),
    DIFERENTE(45, "<>"),
    VIRGULA(46, ","),
    PONTO_VIRGULA(47, ";"),
    LITERAL(48, "literal"),
    PONTO(49, "."),
    RETICENCIAS(50, ".."),
    CIFRAO(51, "$"),
    ESPACO(52," ");
    
    private Integer codigo;
    private String palavra;

    CodigoCaracteresEspeciaisTerminaisEnum(Integer codigo, String palavra) {
        this.codigo = codigo;
        this.palavra = palavra;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public static CodigoCaracteresEspeciaisTerminaisEnum getCodigo(String palavra) {
        for (CodigoCaracteresEspeciaisTerminaisEnum codigoEnum : CodigoCaracteresEspeciaisTerminaisEnum.values()) {
            if (codigoEnum.getPalavra().equals(palavra.toLowerCase())) {
                return codigoEnum;
            }
        }
        return null;
    }
    
    public Pilha getPilha(){
        return new Pilha(getCodigo(), getPalavra());
    }
    
    public Pilha getPilha(Integer linha){
        return new Pilha(getCodigo(), getPalavra(), linha);
    }

    @Override
    public String toString() {
        return "CodigoPalavrasEnum{" + "codigo=" + codigo + ", palavra=" + palavra + '}';
    }
}
