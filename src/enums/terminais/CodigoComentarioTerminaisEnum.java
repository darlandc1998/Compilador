package enums.terminais;

import models.Pilha;


public enum CodigoComentarioTerminaisEnum {
    
    INICIO_COMENTARIO(1, "(*"),
    FIM_COMENTARIO(2,"*)");
    
    private Integer codigo;
    private String palavra;

    CodigoComentarioTerminaisEnum(Integer codigo, String palavra) {
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
    
    public static CodigoComentarioTerminaisEnum getCodigo(String palavra) {
        for (CodigoComentarioTerminaisEnum codigoEnum : CodigoComentarioTerminaisEnum.values()) {
            if (codigoEnum.getPalavra().equals(palavra.toLowerCase())) {
                return codigoEnum;
            }
        }
        return null;
    }
    
     public Pilha getPilha(){
        return new Pilha(getCodigo(), getPalavra());
    }
    
}
