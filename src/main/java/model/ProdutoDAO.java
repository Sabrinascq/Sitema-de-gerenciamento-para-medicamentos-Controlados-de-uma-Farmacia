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
import javax.swing.JOptionPane;

public class ProdutoDAO {

    public boolean salvarOuSomar(Produto produto) {
        String sql = "INSERT INTO Produto (nome, preco, codigo, quantidade) VALUES (?, ?, ?, ?) "
                   + "ON DUPLICATE KEY UPDATE quantidade = quantidade + ?";

        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getPreco());
            stmt.setString(3, produto.getCodigo());
            stmt.setInt(4, produto.getQuantidade());

            stmt.setInt(5, produto.getQuantidade());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public boolean baixarEstoque(String codigo, int qtdSaida) {
        if (!verificarEstoqueSuficiente(codigo, qtdSaida)) {
             JOptionPane.showMessageDialog(null, "Estoque insuficiente!");
             return false;
        }

        String sql = "UPDATE Produto SET quantidade = quantidade - ? WHERE codigo = ?";
        
        try (Connection conn = Conexao.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, qtdSaida);
            stmt.setString(2, codigo);

            int linhas = stmt.executeUpdate();
            return linhas > 0;

        } catch (SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    private boolean verificarEstoqueSuficiente(String codigo, int qtdSaida) {
        String sql = "SELECT quantidade FROM Produto WHERE codigo = ?";
        try (Connection conn = Conexao.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("quantidade") >= qtdSaida;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        
        try (Connection conn = Conexao.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setNome(rs.getString("nome"));
                prod.setPreco(rs.getFloat("preco"));
                prod.setCodigo(rs.getString("codigo"));
                prod.setQuantidade(rs.getInt("quantidade"));
                produtos.add(prod);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return produtos;
    }
}