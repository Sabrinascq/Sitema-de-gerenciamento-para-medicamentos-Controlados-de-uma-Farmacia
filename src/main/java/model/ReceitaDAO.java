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

public class ReceitaDAO {

    public boolean adiciona(Receita receita) {
        String sql = "INSERT INTO Receita(clienteId, nomeMedicamento, dataEmissao, posologia) VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, receita.getClienteId()); 
            stmt.setString(2, receita.getNomeMedicamento()); 
            stmt.setString(3, receita.getDataEmissao());
            stmt.setString(4, receita.getPosologia());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, "Erro ao salvar Receita", e);
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, "Erro ao fechar conexões", e);
            }
        }
    }

    public List<Receita> listarTodos() {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT * FROM Receita";
        
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Receita receita = new Receita();
                receita.setNomeMedicamento(rs.getString("nomeMedicamento"));
                receita.setDataEmissao(rs.getString("dataEmissao"));
                receita.setPosologia(rs.getString("posologia"));

                receitas.add(receita);
            }

        } catch (SQLException e) {
            Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, "Erro ao listar receitas", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, "Erro ao fechar conexões", e);
            }
        }
        return receitas;
    }
}