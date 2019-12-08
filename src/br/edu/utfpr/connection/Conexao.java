package br.edu.utfpr.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    private Connection connection;
    private final String URL = "jdbc:postgresql://localhost:5432/alexandre";
    private final String USER = "postgres";
    private final String PASS = "1234";

    public Conexao() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connection Error. " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error Loading Driver. " + ex.getMessage());
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
}
