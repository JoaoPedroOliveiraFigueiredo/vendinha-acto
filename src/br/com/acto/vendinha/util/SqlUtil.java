package br.com.acto.vendinha.util;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.MSSqlServerConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {

    private static Connection connection;

    private static Connection getConexao() {
        if(connection == null) {
            ConnectionFactory connectionFactory = new MSSqlServerConnection();
            connection = connectionFactory.getConexao();
        }
        return connection;
    }

    public static void criarTabelaCliente() throws SQLException {

        getConexao();

        try {
            String sqlCliente = "if not exists (select * from sysobjects where name='cliente' and xtype='U') \n" +
                    "CREATE TABLE cliente ( \n" +
                    "id INT NOT NULL IDENTITY(1,1), \n" +
                    "nome VARCHAR(255) NOT NULL, \n" +
                    "email VARCHAR(255) NOT NULL, \n" +
                    "cpf INT NOT NULL, \n" +
                    "telefone VARCHAR(255), \n" +
                    "CONSTRAINT pk_cliente PRIMARY KEY (id ASC), \n" +
                    "CONSTRAINT uq_cliente_email UNIQUE(email), \n" +
                    "CONSTRAINT uq_cliente_cpf UNIQUE(cpf), \n" +
                    ")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCliente);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void criarTabelaPessoaFisica() throws SQLException {

        getConexao();

        try {
            String sqlPessoFisica = "if not exists (select * from sysobjects where name='pessoa_fisica' and xtype='U') \n" +
                    "CREATE TABLE pessoa_fisica( \n" +
                    "id INT NOT NULL IDENTITY(1,1), \n" +
                    "nome VARCHAR(255) NOT NULL, \n" +
                    "idade INT NOT NULL, \n" +
                    "endereco VARCHAR(255) NOT NULL, \n" +
                    "contato VARCHAR(255) NOT NULL, \n" +
                    "cpf VARCHAR(255) NOT NULL, \n" +
                    "rg VARCHAR(255) NOT NULL, \n" +
                    "sexo VARCHAR(255) NOT NULL, \n" +
                    "CONSTRAINT pk_pessoa_fisica PRIMARY KEY (id ASC), \n" +
                    "CONSTRAINT uq_pessoa_fisica_cpf UNIQUE (cpf), \n" +
                    "CONSTRAINT uq_pessoa_fisica_rg UNIQUE (rg), \n" +
                    ")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlPessoFisica);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void criarTabelaPessoaJuridica() throws SQLException {

        getConexao();

        try {
            String sqlPessoJuridica = "if not exists (select * from sysobjects where name='pessoa_juridica' and xtype='U') \n" +
                    "CREATE TABLE pessoa_juridica( \n" +
                    "id INT NOT NULL IDENTITY(1,1), \n" +
                    "nome VARCHAR(255) NOT NULL, \n" +
                    "idade INT NOT NULL, \n" +
                    "endereco VARCHAR(255) NOT NULL, \n" +
                    "contato VARCHAR(255) NOT NULL, \n" +
                    "cnpj VARCHAR(255) NOT NULL, \n" +
                    "razao_social VARCHAR(255) NOT NULL, \n" +
                    "CONSTRAINT pk_pessoa_juridica PRIMARY KEY (id ASC), \n" +
                    "CONSTRAINT uq_pessoa_juridica_cnpj UNIQUE (cnpj), \n" +
                    "CONSTRAINT uq_pessoa_juridica_razao_social UNIQUE (razao_social), \n" +
                    ")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlPessoJuridica);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void criarTabelaProduto() throws SQLException {

        getConexao();

        try {
            String sqlProduto = "if not exists (select * from sysobjects where name='produto' and xtype='U') \n" +
                    "CREATE TABLE produto( \n" +
                    "id INT NOT NULL IDENTITY(1,1), \n" +
                    "descricao VARCHAR(255) NOT NULL, \n" +
                    "valor REAL NOT NULL, \n" +
                    "marca VARCHAR(255) NOT NULL, \n" +
                    "modelo VARCHAR(255) NOT NULL, \n" +
                    "vencimento DATE NOT NULL, \n" +
                    "CONSTRAINT pk_produto PRIMARY KEY (id ASC), \n" +
                    ")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlProduto);
        } catch (SQLException e) {
            throw e;
        }
    }

}
