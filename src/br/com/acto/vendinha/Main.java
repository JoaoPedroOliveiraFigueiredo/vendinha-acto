package br.com.acto.vendinha;

import br.com.acto.vendinha.util.SqlUtil;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
        criarTabelas();
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
