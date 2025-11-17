package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Relatorio {

    public void gerarRelatorio() {
        System.out.println("=== RELATÓRIO DE CLIENTES ===");
        
        // 1. Conectar ao banco
        Connection con = Conexao.getConexaoMySQL();
        String sql = "SELECT * FROM Cliente";

        try {
            // 2. Preparar e Executar a consulta (SELECT)
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery(); // ResultSet guarda os dados que voltaram do banco

            // 3. Ler linha por linha enquanto tiver dados
            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String telefone = resultado.getString("telefone");
                
                System.out.println("Cliente: " + nome + " | CPF: " + cpf + " | Tel: " + telefone);
            }
            
            System.out.println("=== FIM DO RELATÓRIO ===");
            
            // 4. Fechar tudo
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            System.err.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }
}