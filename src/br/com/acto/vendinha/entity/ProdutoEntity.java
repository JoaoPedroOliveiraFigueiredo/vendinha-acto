package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoEntity extends GenericEntity<Produto>{

    public List produtos;

    public ProdutoEntity() {
        this.produtos = new ArrayList();
    }

    @Override
    public List<Produto> buscarTodos() {
        return this.produtos;
    }

    @Override
    public void cadastrar(Produto produto) {
        this.produtos.add(produto);
    }
}
