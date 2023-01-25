package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.MSSqlServerConnection;
import br.com.acto.vendinha.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteEntity{

    private Connection connection;

    private Connection getConexao() {
        if(connection == null) {
            ConnectionFactory connectionFactory = new MSSqlServerConnection();
            connection = connectionFactory.getConexao();
        }
        return connection;
    }

    public boolean inserir(Cliente cliente) {
        try {
            getConexao();
            String sql = "INSERT INTO cliente (nome, email, cpf, telefone) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEmail());
            statement.setInt(3, cliente.getCpf());
            statement.setString(4, cliente.getTelefone());
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Cliente cliente){
        try {
            getConexao();
            String sql = "UPDATE cliente SET nome=?, email=?, cpf=?, telefone=? where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEmail());
            statement.setInt(3, cliente.getCpf());
            statement.setString(4, cliente.getTelefone());
            statement.setLong(5,  cliente.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Cliente cliente) {
        try {
            getConexao();
            String sql = "DELETE cliente where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, cliente.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Long id) {
        try {
            getConexao();
            String sql = "DELETE cliente where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Cliente> buscarTodos() {
        List<Cliente> resultado = new ArrayList<Cliente>(); // lista vazia para o resultado
        try {
            getConexao();
            String sql = "SELECT * FROM cliente";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getLong("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setCpf(resultSet.getInt("cpf"));
                cliente.setTelefone(resultSet.getString("telefone"));
                resultado.add(cliente);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

}
