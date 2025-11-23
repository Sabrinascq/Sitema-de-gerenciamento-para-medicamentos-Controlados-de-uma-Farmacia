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

public class FuncionarioDAO {

    public boolean adiciona(Funcionario func) {
        String sql = "INSERT INTO Funcionario(nome, senha, dataNasc, cpf) VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getSenha());
            stmt.setString(3, func.getDataNasc());
            stmt.setString(4, func.getCpf());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

public Funcionario login(String cpf, String senha) {
    String sql = "SELECT nome, senha, dataNasc, cpf FROM Funcionario WHERE cpf = ? AND senha = ?";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Funcionario func = null;

    try {
        connection = Conexao.getConexaoMySQL();
        stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, cpf);
        stmt.setString(2, senha);
        
        rs = stmt.executeQuery();

        if (rs.next()) {
            func = new Funcionario();
            func.setNome(rs.getString("nome"));
            func.setSenha(rs.getString("senha"));
            func.setDataNasc(rs.getString("dataNasc"));
            func.setCpf(rs.getString("cpf"));
        }

    } catch (SQLException e) {
        Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    return func;
}
    public List<Funcionario> listarTodos() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario";
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario func = new Funcionario();

                func.setNome(rs.getString("nome"));
                func.setSenha(rs.getString("senha"));
                func.setDataNasc(rs.getString("dataNasc"));
                func.setCpf(rs.getString("cpf"));

                funcionarios.add(func);
            }

        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return funcionarios;
    }
}