package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.model.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaEntity extends GenericEntity<PessoaJuridica>{

    public List<PessoaJuridica> pessoasJuridicas;

    public PessoaJuridicaEntity() {
        this.pessoasJuridicas = new ArrayList<PessoaJuridica>();
    }

    @Override
    public void cadastrar(PessoaJuridica pessoaJuridica) {
        this.pessoasJuridicas.add(pessoaJuridica);
    }

    @Override
    public List<PessoaJuridica> buscarTodos() {
        return this.pessoasJuridicas;
    }

    public PessoaJuridica buscarPorCPNJ(String cnpj) {
        return null;
    }

}
