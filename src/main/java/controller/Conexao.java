package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao { 

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/saude_hub";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConexaoMySQL() {
        
        try {
            
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado. Verifique seu pom.xml.");
            throw new RuntimeException("Erro ao carregar o driver", e);
            
        } catch (SQLException e) {
            System.err.println("Falha ao conectar com o banco de dados.");
            throw new RuntimeException("Erro de conexão com o BD", e);
        }
    }

    /**
     * (OPCIONAL) Método main para testar esta classe rapidamente.
     * Você pode clicar com o botão direito neste arquivo e "Executar"
     * para ver se a conexão funciona.
     * (Baseado no teste da página 12)
     */
    public static void main(String[] args) {
        try {
            Connection con = Conexao.getConexaoMySQL(); // <-- NOME ALTERADO
            //
            System.out.println("SUCESSO: Conexão com o MySQL realizada!"); 
            
            // Boa prática: fechar a conexão de teste
            con.close();
            System.out.println("Conexão fechada.");

        } catch (Exception e) {
            //
            System.err.println("FALHA: Não foi possível conectar.");
        }
    }
}