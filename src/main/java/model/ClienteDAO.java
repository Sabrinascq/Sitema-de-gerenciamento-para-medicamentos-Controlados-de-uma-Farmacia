package model;

import controller.Conexao; // 1. Importar a classe de conexão
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    
    // 2. Criar uma variável para a conexão
    private final Connection connection;

    // 3. Construtor que pega a conexão
    public ClienteDAO() {
        this.connection = Conexao.getConexaoMySQL();
    }

    // 4. Método "adiciona" CORRIGIDO
    public boolean adiciona(Cliente cliente) {
        // O SQL correto com placeholders (?)
        String sql = "INSERT INTO Cliente(nome, dataNasc, cpf, telefone, endereco) VALUES (?, ?, ?, ?, ?)";
        
        try {
            // 5. Preparar o SQL
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // 6. Substituir os "?" pelos dados reais do cliente
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getDataNasc());
            stmt.setInt(3, cliente.getCpf());
            stmt.setInt(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            
            // 7. Executar o SQL
            stmt.execute();
            
            // 8. Fechar a conexão
            stmt.close();
            connection.close();
            
            return true; // Deu certo!
            
        } catch (SQLException u) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, u);
            return false; // Deu errado!
        }
    }
}