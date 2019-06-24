package models;

import enums.CategoriaSemanticaEnum;
import java.util.Objects;

public class TabelaSemantica {
    
    private String nome;
    private CategoriaSemanticaEnum categoria;
    private String tipo;
    private Integer nivel;

    public TabelaSemantica(String nome, String tipo, Integer nivel) {
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaSemanticaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaSemanticaEnum categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.nivel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TabelaSemantica other = (TabelaSemantica) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nivel, other.nivel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TabelaSemantica{" + "nome=" + nome + ", categoria=" + categoria + ", tipo=" + tipo + ", nivel=" + nivel + '}';
    }
    
}
