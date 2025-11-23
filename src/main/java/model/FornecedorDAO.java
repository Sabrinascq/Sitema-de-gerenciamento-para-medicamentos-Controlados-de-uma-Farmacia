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

public class FornecedorDAO {

    public boolean adiciona(Fornecedor forn) {
        String sql = "INSERT INTO Fornecedor(nome, cnpj) VALUES (?, ?)";
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, forn.getNome());
            stmt.setString(2, forn.getCnpj());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public List<Fornecedor> listarTodos() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM Fornecedor";
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor forn = new Fornecedor();

                forn.setNome(rs.getString("nome"));
                forn.setCnpj(rs.getString("cnpj"));

                fornecedores.add(forn);
            }

        } catch (SQLException e) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return fornecedores;
    }
}