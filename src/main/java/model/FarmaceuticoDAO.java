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

public class FarmaceuticoDAO {

    public boolean adiciona(Farmaceutico farm) {
        String sql = "INSERT INTO Farmaceutico(nome, senha, dataNasc, cpf, crf, uni) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, farm.getNome());
            stmt.setString(2, farm.getSenha());
            stmt.setString(3, farm.getDataNasc());
            stmt.setString(4, farm.getCpf());
            stmt.setString(5, farm.getCrf());
            stmt.setString(6, farm.getUni());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(FarmaceuticoDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(FarmaceuticoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public List<Farmaceutico> listarTodos() {
        List<Farmaceutico> farmaceuticos = new ArrayList<>();
        String sql = "SELECT * FROM Farmaceutico";
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Farmaceutico farm = new Farmaceutico();

                farm.setNome(rs.getString("nome"));
                farm.setSenha(rs.getString("senha"));
                farm.setDataNasc(rs.getString("dataNasc"));
                farm.setCpf(rs.getString("cpf"));
                farm.setCrf(rs.getString("crf"));
                farm.setUni(rs.getString("uni"));

                farmaceuticos.add(farm);
            }

        } catch (SQLException e) {
            Logger.getLogger(FarmaceuticoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(FarmaceuticoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return farmaceuticos;
    }
}