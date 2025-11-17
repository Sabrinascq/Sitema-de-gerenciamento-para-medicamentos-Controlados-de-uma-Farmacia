package model;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {
    private final Connection connection;

    public FuncionarioDAO() {
        this.connection = Conexao.getConexaoMySQL();
    }

    public void adiciona(Funcionario func) {
        String sql = "INSERT INTO Funcionario(nome, senha, dataNasc, cpf) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, func.getNome());
            stmt.setInt(2, func.getSenha());
            stmt.setInt(3, func.getDataNasc());
            stmt.setInt(4, func.getCpf());
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}