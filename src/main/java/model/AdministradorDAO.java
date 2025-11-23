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

public class AdministradorDAO {

    public boolean adiciona(Administrador admin) {
        String sql = "INSERT INTO Administrador(nome, senha, dataNasc, cpf, tipoAtividade) VALUES (?, ?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement stmt = null;
        
        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, admin.getNome());
            stmt.setString(2, admin.getSenha());
            stmt.setString(3, admin.getDataNasc());
            stmt.setString(4, admin.getCpf());
            stmt.setString(5, admin.getTipoAtividade());
            
            stmt.execute();
            return true;
            
        } catch (SQLException e) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public Administrador login(String cpf, String senha) {
        String sql = "SELECT nome, senha, dataNasc, cpf, tipoAtividade FROM Administrador WHERE cpf = ? AND senha = ?";
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Administrador admin = null;

        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                admin = new Administrador();
                admin.setNome(rs.getString("nome"));
                admin.setSenha(rs.getString("senha"));
                admin.setDataNasc(rs.getString("dataNasc"));
                admin.setCpf(rs.getString("cpf"));
                admin.setTipoAtividade(rs.getString("tipoAtividade"));
            }

        } catch (SQLException e) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return admin;
    }

    public List<Administrador> listarTodos() {
        List<Administrador> admins = new ArrayList<>();
        String sql = "SELECT * FROM Administrador";
        
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            connection = Conexao.getConexaoMySQL();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Administrador admin = new Administrador();
                       
                admin.setNome(rs.getString("nome"));
                admin.setSenha(rs.getString("senha"));
                admin.setDataNasc(rs.getString("dataNasc"));
                admin.setCpf(rs.getString("cpf"));
                admin.setTipoAtividade(rs.getString("tipoAtividade"));
                
                admins.add(admin);
            }
            
        } catch (SQLException e) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return admins;
    }
}