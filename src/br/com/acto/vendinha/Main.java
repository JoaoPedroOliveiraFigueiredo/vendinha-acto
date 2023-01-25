package br.com.acto.vendinha;

import br.com.acto.vendinha.entity.ClienteEntity;
import br.com.acto.vendinha.entity.PessoaFisicaEntity;
import br.com.acto.vendinha.model.Cliente;
import br.com.acto.vendinha.model.PessoaFisica;
import br.com.acto.vendinha.util.SqlUtil;

import java.sql.SQLException;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        criarTabelas();
        ClienteEntity clienteEntity = new ClienteEntity();
        PessoaFisicaEntity pessoaFisicaEntity = new PessoaFisicaEntity();

        Cliente cliente = new Cliente();
        cliente.setNome("Zé da Silva de Oliveira");
        cliente.setEmail("ze@gmail.com");
        cliente.setCpf(789546);
        cliente.setTelefone("(67) 9 93262627");
        cliente.setId(2L);

        clienteEntity.atualizar(cliente);
//        clienteEntity.remover(cliente.getId());
//        clienteEntity.inserir(cliente);

//        System.out.println("Buscando clientes cadastrados");
//        List<Cliente> clientes = clienteEntity.buscarTodos();
//        System.out.println(clientes);
//
//        System.out.println("Buscando pessoas físicas cadastradas");
//        List<PessoaFisica> pessoasFisicas = pessoaFisicaEntity.buscarTodos();
//        System.out.println(pessoasFisicas);
    }

    private static void criarTabelas() {
        try {
            SqlUtil.criarTabelaCliente();
            SqlUtil.criarTabelaPessoaFisica();
            SqlUtil.criarTabelaPessoaJuridica();
            SqlUtil.criarTabelaProduto();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
