package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao { 

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/saude_hub";
    private static final String USER = "root";
    private static final String PASS = "thiago";

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
}