package com.silvio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SILVIO
 */
public class FabricaConexao {
    
    private static Connection connection;//implementa a interface para conexao
    private static final String URL_CONEXAO = "jdbc:mysql://localhost:3306/sistema-carros";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    
    public static Connection getConnection() {
        if(connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (SQLException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
    
    public static void fecharConexao(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            connection = null;
        }
    }   
    
    
}
