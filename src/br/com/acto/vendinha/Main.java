package br.com.acto.vendinha;

import br.com.acto.vendinha.entity.ClienteEntity;
import br.com.acto.vendinha.model.Cliente;
import br.com.acto.vendinha.util.SqlUtil;

import java.sql.SQLException;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        criarTabelas();
        ClienteEntity clienteEntity = new ClienteEntity();

        System.out.println("Buscando clientes cadastrados");
        List<Cliente> clientes = clienteEntity.buscarTodos();
        System.out.println(clientes);
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
