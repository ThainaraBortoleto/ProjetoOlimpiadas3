package model;

import java.io.Serializable;

public class Pais implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private String area;
    private String populacao;

    public Pais() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    @Override
    public String toString() {
        return "Pais [id=" + id + ", nome=" + nome + ", area=" + area
                + ", populacao=" + populacao + "]";
    }


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Pais pais = (Pais) object;

        if (id != pais.id) return false;
        if (nome != null ? !nome.equals(pais.nome) : pais.nome != null) return false;
        if (area != null ? !area.equals(pais.area) : pais.area != null) return false;
        if (populacao != null ? !populacao.equals(pais.populacao) : pais.populacao != null) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (populacao != null ? populacao.hashCode() : 0);
        return result;
    }
}
