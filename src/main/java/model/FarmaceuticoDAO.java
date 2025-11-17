package model;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FarmaceuticoDAO {
    private final Connection connection;

    public FarmaceuticoDAO() {
        this.connection = Conexao.getConexaoMySQL();
    }

    public void adiciona(Farmaceutico farm) {
        String sql = "INSERT INTO Farmaceutico(nome, senha, dataNasc, cpf, crf, uni) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, farm.getNome());
            stmt.setInt(2, farm.getSenha());
            stmt.setInt(3, farm.getDataNasc());
            stmt.setInt(4, farm.getCpf());
            stmt.setInt(5, farm.getCrf());
            stmt.setString(6, farm.getUni());
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}