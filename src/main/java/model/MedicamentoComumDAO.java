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

public class MedicamentoComumDAO {

    public boolean adiciona(MedicamentoComum med) {
        String sql = "INSERT INTO MedicamentoComum(nome, tipoControle, dosagem, indicacao) VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, med.getNome());
            stmt.setString(2, med.getTipoControle());
            stmt.setString(3, med.getDosagem());
            stmt.setString(4, med.getIndicacao());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(MedicamentoComumDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(MedicamentoComumDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public List<MedicamentoComum> listarTodos() {
        List<MedicamentoComum> medicamentos = new ArrayList<>();
        String sql = "SELECT * FROM MedicamentoComum";
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                MedicamentoComum med = new MedicamentoComum();

                med.setNome(rs.getString("nome"));
                med.setTipoControle(rs.getString("tipoControle"));
                med.setDosagem(rs.getString("dosagem"));
                med.setIndicacao(rs.getString("indicacao"));

                medicamentos.add(med);
            }

        } catch (SQLException e) {
            Logger.getLogger(MedicamentoComumDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(MedicamentoComumDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return medicamentos;
    }
    public boolean existePorNome(String nome) {
    String sql = "SELECT nome FROM MedicamentoComum WHERE nome = ?";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        connection = Conexao.getConexaoMySQL();
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();

        return rs.next();

    } catch (SQLException e) {
        Logger.getLogger(MedicamentoComumDAO.class.getName()).log(Level.SEVERE, "Erro ao buscar Medicamento Comum", e);
        return false;
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            Logger.getLogger(MedicamentoComumDAO.class.getName()).log(Level.SEVERE, "Erro ao fechar conexões", e);
        }
    }
}
}