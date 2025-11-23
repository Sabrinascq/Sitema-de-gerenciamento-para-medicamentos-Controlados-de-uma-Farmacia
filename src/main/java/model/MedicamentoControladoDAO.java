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

public class MedicamentoControladoDAO {

    public boolean adiciona(MedicamentoControlado med) {
        String sql = "INSERT INTO MedicamentoControlado(nome, tipoControle, dosagem, numReceita, valReceita, descricao) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, med.getNome());
            stmt.setString(2, med.getTipoControle());
            stmt.setString(3, med.getDosagem());
            stmt.setString(4, med.getNumReceita());
            stmt.setString(5, med.getValReceita());
            stmt.setString(6, med.getDescricao());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(MedicamentoControladoDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(MedicamentoControladoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public List<MedicamentoControlado> listarTodos() {
        List<MedicamentoControlado> medicamentos = new ArrayList<>();
        String sql = "SELECT * FROM MedicamentoControlado";
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                MedicamentoControlado med = new MedicamentoControlado();

                med.setNome(rs.getString("nome"));
                med.setTipoControle(rs.getString("tipoControle"));
                med.setDosagem(rs.getString("dosagem"));
                med.setNumReceita(rs.getString("numReceita"));
                med.setValReceita(rs.getString("valReceita"));
                med.setDescricao(rs.getString("descricao"));

                medicamentos.add(med);
            }

        } catch (SQLException e) {
            Logger.getLogger(MedicamentoControladoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(MedicamentoControladoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return medicamentos;
    }

public boolean existePorNome(String nome) {
    String sql = "SELECT nome FROM MedicamentoControlado WHERE nome = ?"; 
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
        Logger.getLogger(MedicamentoControladoDAO.class.getName()).log(Level.SEVERE, "Erro ao buscar Medicamento Controlado", e); 
        return false;
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            Logger.getLogger(MedicamentoControladoDAO.class.getName()).log(Level.SEVERE, "Erro ao fechar conexões", e);
        }
    }
}
}