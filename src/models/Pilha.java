package models;


public class Pilha {
    
    private Integer codigo;
    private String Descricao;   
    private Integer linha;

    public Pilha(Integer codigo, String Descricao) {
        this.codigo = codigo;
        this.Descricao = Descricao;
    }
    
    public Pilha(Integer codigo, String Descricao, Integer linha) {
        this.codigo = codigo;
        this.Descricao = Descricao;       
        this.linha = linha;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }    

    public Integer getLinha() {
        return linha;
    }

    public void setLinha(Integer linha) {
        this.linha = linha;
    }
    
    @Override
    public String toString() {
        return "Pilha{" + "codigo=" + codigo + ", Descricao=" + Descricao + '}';
    }
    
    
}
