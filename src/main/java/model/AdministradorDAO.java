package model;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdministradorDAO {
    private final Connection connection;

    public AdministradorDAO() {
        this.connection = Conexao.getConexaoMySQL();
    }

    public boolean adiciona(Administrador admin) {
        String sql = "INSERT INTO Administrador(nome, senha, dataNasc, cpf, tipoAtividade) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, admin.getNome());
            // Importante: Converta para String se o seu banco esperar texto, ou int se for número
            stmt.setInt(2, admin.getSenha()); 
            stmt.setInt(3, admin.getDataNasc());
            stmt.setInt(4, admin.getCpf());
            stmt.setString(5, admin.getTipoAtividade());
            stmt.execute();
            stmt.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}