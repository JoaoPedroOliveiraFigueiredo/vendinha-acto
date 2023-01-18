package br.com.acto.vendinha;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.MSSqlServerConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static Connection con;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new MSSqlServerConnection();
        con = connectionFactory.getConexao();
        criarTabelas();
    }

    private static void criarTabelas() {
        try {
            Statement statement = con.createStatement();
            String sqlCliente = "if not exists (select * from sysobjects where name='cliente' and xtype='U') \n" +
                    "CREATE TABLE cliente ( \n" +
                    "id INT NOT NULL IDENTITY(1,1), \n" +
                    "nome VARCHAR(255) NOT NULL, \n" +
                    "email VARCHAR(255) NOT NULL, \n" +
                    "cpf INT NOT NULL, \n" +
                    "telefone VARCHAR(255), \n" +
                    "CONSTRAINT pk_cliente PRIMARY KEY (id ASC), \n" +
                    "CONSTRAINT uq_email UNIQUE(email), \n" +
                    "CONSTRAINT uq_cpf UNIQUE(cpf), \n" +
                    ")";

            statement.executeUpdate(sqlCliente);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
