package br.com.acto.vendinha.model;

import java.util.Date;
import java.util.Objects;

public class Produto extends BaseModel{

    private String descricao;
    private Double valor;
    private String marca;
    private String modelo;
    private Date vencimento;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(descricao, produto.descricao) && Objects.equals(valor, produto.valor) && Objects.equals(marca, produto.marca) && Objects.equals(modelo, produto.modelo) && Objects.equals(vencimento, produto.vencimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descricao, valor, marca, modelo, vencimento);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", vencimento=" + vencimento +
                '}';
    }
}
