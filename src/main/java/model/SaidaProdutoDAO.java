package model;

import controller.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaidaProdutoDAO {

    public void registrarHistorico(String codigo, int qtd) {
        String sql = "INSERT INTO SaidaProduto (codigo_produto, quantidade) VALUES (?, ?)";
        try (Connection conn = Conexao.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            stmt.setInt(2, qtd);
            stmt.execute();
        } catch (SQLException e) {
            Logger.getLogger(SaidaProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public List<SaidaProduto> listarSaidas() {
        List<SaidaProduto> lista = new ArrayList<>();
        String sql = "SELECT * FROM SaidaProduto";
        try (Connection conn = Conexao.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while(rs.next()){
                SaidaProduto s = new SaidaProduto();
                s.setCodigoProduto(rs.getString("codigo_produto"));
                s.setQuantidade(rs.getInt("quantidade"));
                s.setDataSaida(rs.getString("data_saida"));
                lista.add(s);
            }
        } catch (SQLException e) {
            Logger.getLogger(SaidaProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }
}