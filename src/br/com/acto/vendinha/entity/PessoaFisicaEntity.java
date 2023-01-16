package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.model.PessoaFisica;

import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaEntity extends GenericEntity<PessoaFisica> {

    public List<PessoaFisica> pessoasFisicas;

    public PessoaFisicaEntity() {
        this.pessoasFisicas = new ArrayList<PessoaFisica>();
    }

    @Override
    public void cadastrar(PessoaFisica pessoaFisica) {
        this.pessoasFisicas.add(pessoaFisica);
    }

    @Override
    public List<PessoaFisica> buscarTodos() {
        return this.pessoasFisicas;
    }

    public PessoaFisica buscarPorCPF(String cpf) {
        return null;
    }

}
