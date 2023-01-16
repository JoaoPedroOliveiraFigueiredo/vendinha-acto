package br.com.acto.vendinha.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSqlServerConnection implements ConnectionFactory{

    public Connection conectarDB() {

        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=vendinha";
        try {
            Connection con = DriverManager.getConnection(connectionURL);
            return con;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no BD");
            e.printStackTrace();
            return null;
        }
    }
}
