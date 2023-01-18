package br.com.acto.vendinha.db;

import java.sql.Connection;

public interface ConnectionFactory {

    Connection conectarDB();

    Connection getConexao();

}
