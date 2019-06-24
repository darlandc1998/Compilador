package enums.terminais;

import models.Pilha;

public enum CodigoPalavrasTerminaisEnum {
    PROGRAM(1, "program"),
    LABEL(2, "label"),
    CONST(3, "const"),
    VAR(4, "var"),
    PROCEDURE(5, "procedure"),
    BEGIN(6, "begin"),
    END(7, "end"),
    INTEGER(8, "integer"),
    ARRAY(9, "array"),
    OF(10, "of"),
    CALL(11, "call"),
    GOTO(12, "goto"),
    IF(13, "if"),
    THEN(14, "then"),
    ELSE(15, "else"),
    WHILE(16, "while"),
    DO(17, "do"),
    REPEAT(18, "repeat"),
    UNTIL(19, "until"),
    READLN(20, "readln"),
    WRITELN(21, "writeln"),
    OR(22, "or"),
    AND(23, "and"),
    NOT(24, "not"),
    IDENTIFICADOR(25, "identificador"),
    INTEIRO(26, "inteiro"),
    FOR(27, "for"),
    TO(28, "to"),
    CASE(29, "case");
    

    private Integer codigo;
    private String palavra;

    CodigoPalavrasTerminaisEnum(Integer codigo, String palavra) {
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

    public static CodigoPalavrasTerminaisEnum getCodigo(String palavra) {
        for (CodigoPalavrasTerminaisEnum codigoEnum : CodigoPalavrasTerminaisEnum.values()) {
            if (codigoEnum.getPalavra().equals(palavra.trim().toLowerCase())) {
                return codigoEnum;
            }
        }
        return null;
    }
    
    
    public Pilha getPilha(String palavra, Integer linha){
        return new Pilha(getCodigo(), palavra, linha);
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
