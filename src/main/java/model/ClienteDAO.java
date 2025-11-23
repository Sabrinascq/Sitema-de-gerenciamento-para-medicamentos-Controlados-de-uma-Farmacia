package model;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    public boolean adiciona(Cliente cliente) {
        String sql = "INSERT INTO Cliente(nome, dataNasc, cpf, telefone, endereco) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getDataNasc());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());

            stmt.execute();
            return true;

        } catch (SQLException u) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, u);
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setNome(rs.getString("nome"));
                cliente.setDataNasc(rs.getString("dataNasc"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return clientes;
    }
    public Cliente buscarPorCpf(String cpf) {
    String sql = "SELECT id, nome, dataNasc, cpf, telefone, endereco FROM Cliente WHERE cpf = ?"; 
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Cliente cliente = null;

    try {
        connection = Conexao.getConexaoMySQL();
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, cpf);
        rs = stmt.executeQuery();

        if (rs.next()) {
            cliente = new Cliente();
            
            
            cliente.setNome(rs.getString("nome"));
            cliente.setDataNasc(rs.getString("dataNasc"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEndereco(rs.getString("endereco"));
        }

    } catch (SQLException e) {
        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, "Erro ao buscar Cliente por CPF", e);
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, "Erro ao fechar conexões", e);
        }
    }
    return cliente;
}
}