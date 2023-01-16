package br.com.acto.vendinha;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.MSSqlServerConnection;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new MSSqlServerConnection();
        System.out.println("Vai conectar no DB...");
        Connection con = connectionFactory.conectarDB();

        System.out.println(con);

    }
}
