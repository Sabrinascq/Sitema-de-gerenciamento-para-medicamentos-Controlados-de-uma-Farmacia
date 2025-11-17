package model;
import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicamentoControladoDAO {
    private final Connection connection;

    public MedicamentoControladoDAO() {
        this.connection = Conexao.getConexaoMySQL();
    }

    public void adiciona(MedicamentoControlado med) {
        String sql = "INSERT INTO MedicamentoControlado(nome, tipoControle, dosagem, numReceita, valReceita, descricao) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, med.getNome());
            stmt.setString(2, med.getTipoControle());
            stmt.setString(3, med.getDosagem());
            // Atenção: Se der erro aqui, verifique se no seu modelo é String ou int
            stmt.setInt(4, med.getNumReceita()); 
            stmt.setInt(5, med.getValReceita());
            stmt.setString(6, med.getDescricao());
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}