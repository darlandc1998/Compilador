package enums.naoTerminais;

import models.Pilha;

public enum CodigoPalavrasNaoTerminaisEnum {
    PROGRAMA(52, "programa"),
    BLOCO(53, "bloco"),
    DCLROT(54, "dclrot"),
    LID(55, "lid"),
    REPIDENT(56, "repident"),
    DCLCONST(57, "dclconst"),
    LDCONST(58, "ldconst"),
    DCLVAR(59, "dclvar"),
    LDVAR(60, "ldvar"),
    TIPO(61, "tipo"),
    DCLPROC(62, "dclproc"),
    DEFPAR(63, "defpar"),
    CORPO(64, "corpo"),
    REPCOMANDO(65, "repcomando"),
    COMANDO(66, "comando"),
    RCOMID(67, "rcomid"),
    RVAR(68, "rvar"),
    PARAMETROS(69, "parametros"),
    REPPAR(70, "reppar"),
    ELSEPARTE(71, "elseparte"),
    VARIAVEL(72, "variavel"),
    VARIAVEL1(73, "variavel1"),
    REPVARIAVEL(74, "repvariavel"),
    ITEMSAIDA(75, "itemsaida"),
    REPITEM(76, "repitem"),
    EXPRESSAO(77, "expressao"),
    REPEXPSIMP(78, "repexpsimp"),
    EXPSIMP(79, "expsimp"),
    REPEXP(80, "repexp"),
    TERMO(81, "termo"),
    REPTERMO(82, "reptermo"),
    FATOR(83, "fator"),
    CONDCASE(84, "condcase"),
    CONTCASE(85, "contcase"),
    RPINTEIRO(86, "rpinteiro"),
    SEM_EFEITO(87, "sem_efeito");
    
    private Integer codigo;
    private String palavra;

    CodigoPalavrasNaoTerminaisEnum(Integer codigo, String palavra) {
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
    
     public Pilha getPilha(String palavra){
        return new Pilha(getCodigo(), palavra);
    }
    
    public Pilha getPilha(){
        return new Pilha(getCodigo(), getPalavra());
    }
    
    public static CodigoPalavrasNaoTerminaisEnum getCodigo(String palavra) {
        for (CodigoPalavrasNaoTerminaisEnum codigoEnum : CodigoPalavrasNaoTerminaisEnum.values()) {
            if (codigoEnum.getPalavra().equals(palavra.trim().toLowerCase())) {
                return codigoEnum;
            }
        }
        return null;
    }
    
}
