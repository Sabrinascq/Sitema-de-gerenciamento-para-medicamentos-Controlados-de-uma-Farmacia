package model;
import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicamentoComumDAO {
    private final Connection connection;

    public MedicamentoComumDAO() {
        this.connection = Conexao.getConexaoMySQL();
    }

    public void adiciona(MedicamentoComum med) {
        String sql = "INSERT INTO MedicamentoComum(nome, tipoControle, dosagem, indicacao) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, med.getNome());
            stmt.setString(2, med.getTipoControle());
            stmt.setString(3, med.getDosagem());
            stmt.setString(4, med.getIndicacao());
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}