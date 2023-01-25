package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.MSSqlServerConnection;
import br.com.acto.vendinha.model.PessoaFisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaEntity {

    private Connection connection;

    // 1- método get conection
    private Connection getConexao(){
        if(connection == null) {
            ConnectionFactory connectionFactory = new MSSqlServerConnection();
            connection = connectionFactory.getConexao();
        }
        return connection;
    }

    // 2- buscar todos
    public List<PessoaFisica> buscarTodos() {
        List<PessoaFisica> resultado = new ArrayList<PessoaFisica>();
        try {
            getConexao();
            String sql = "SELECT * FROM pessoa_fisica";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setId(resultSet.getLong("id"));
                pessoaFisica.setNome(resultSet.getString("nome"));
                pessoaFisica.setIdade(resultSet.getInt("idade"));
                pessoaFisica.setEndereco(resultSet.getString("endereco"));
                pessoaFisica.setContato(resultSet.getString("contato"));
                pessoaFisica.setCpf(resultSet.getString("cpf"));
                pessoaFisica.setRg(resultSet.getString("rg"));
                resultado.add(pessoaFisica);
            }

            return resultado;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
