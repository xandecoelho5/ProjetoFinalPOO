package br.edu.utfpr.dao;

import br.edu.utfpr.connection.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public abstract class AbstractDao<T extends Object> { //tipo generico(qualquer tipo de objeto) , tipo padrao que extende de object
    protected Connection connection;
    public abstract boolean insert(T object);
    public abstract boolean delete(int id);
    public abstract boolean update(T object);
    
    protected void openConnection(){
        try {
            if((connection == null) || (connection.isClosed())){
                connection = new Conexao().getConnection();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }      
    }
    
    protected void closeConnection(){
        try {
            if((connection != null) || (!connection.isClosed())){
                connection.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }      
    }
    
}
