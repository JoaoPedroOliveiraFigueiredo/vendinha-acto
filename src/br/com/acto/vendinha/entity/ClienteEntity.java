package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteEntity extends GenericEntity<Cliente>{

    public List<Cliente> clientes;

    public ClienteEntity() {
        this.clientes = new ArrayList<Cliente>();
    }

    @Override
    public void cadastrar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return this.clientes;
    }
}
