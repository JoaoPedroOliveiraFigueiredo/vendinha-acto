package br.com.acto.vendinha.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSqlServerConnection implements ConnectionFactory{

    private Connection connection;

    public Connection conectarDB() {

        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=vendinha;encrypt=false;user=admin;password=admin";
        try {
            connection = DriverManager.getConnection(connectionURL);
            return connection;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no BD");
            e.printStackTrace();
            return null;
        }
    }

    public Connection getConexao() {
        if(connection == null) {
            return this.conectarDB();
        } else return connection;
    }
}
