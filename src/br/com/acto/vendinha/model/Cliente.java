package br.com.acto.vendinha.model;

import java.util.List;
import java.util.Objects;

public class Cliente extends BaseModel {

    private Long id;
    private String nome;
    private String email;
    private Integer cpf;
    private String telefone;
    private List<String> itens;

    public Cliente() {

    };

    public Cliente(String nome, String email, Integer cpf, String telefone) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public void imprimirNome() {
        System.out.println("Meu nome é: " + this.nome);
    }

    public void imprimirNome(String sufix) {
        System.out.println("Meu nome é: " + this.nome + sufix);
    }

    public void adicionarItem(String item) {
        // Adicionar o item
        itens.add(item);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id*2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(email, cliente.email) && Objects.equals(cpf, cliente.cpf) && Objects.equals(telefone, cliente.telefone) && Objects.equals(itens, cliente.itens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, cpf, telefone, itens);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf=" + cpf +
                ", telefone='" + telefone + '\'' +
                ", itens=" + itens +
                '}';
    }
}
