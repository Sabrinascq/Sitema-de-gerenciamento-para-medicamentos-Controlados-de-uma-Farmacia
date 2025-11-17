package model;
import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornecedorDAO {
    private final Connection connection;

    public FornecedorDAO() {
        this.connection = Conexao.getConexaoMySQL();
    }

    public void adiciona(Fornecedor forn) {
        String sql = "INSERT INTO Fornecedor(nome, cnpj) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, forn.getNome());
            stmt.setInt(2, forn.getCnpj());
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}