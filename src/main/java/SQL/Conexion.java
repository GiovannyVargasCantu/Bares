/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.awt.HeadlessException;
import java.sql.Connection;

/**
 *
 * @author Giovanny Vargas
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Conexion {
    Connection conectar = null;
    
    String usuario = "usersql";
    String contrasenia = "root2";
    String bd = "Bares";
    String ip = "localhost";
    String puerto = "1433";
    
    String cadena = "jdbc:sqlserver://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
        try {
            String cadenaConexion = "jdbc:sqlserver://localhost:"+puerto+";"+"databaseName="+bd+";encrypt=true;trustServerCertificate=true";
            conectar = DriverManager.getConnection(cadenaConexion,usuario,contrasenia);
            JOptionPane.showMessageDialog(null,"Se conecto correctamente a la base de datos");
        } catch (HeadlessException | SQLException e) { 
             System.out.println("Error al conectar a la base de datos, error:"+ e.toString());
            }
        return conectar;    
        }
  
}

