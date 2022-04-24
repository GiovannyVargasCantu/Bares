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
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import javax.swing.JOptionPane;
    
public class Conexion {
    Connection conectar = null;
    //String usuario = "usersql";
    //String contrasenia = "root2";
    String bd = "Bares";
    String ip = "localhost";
    String puerto = "1433";
    
    String cadena = "jdbc:sqlserver://"+ip+":"+puerto+"/"+bd;
    public static boolean validacion = true;
    
    public Connection establecerConexion(String usuario, String contrasenia){
        try {
            String cadenaConexion = "jdbc:sqlserver://"+ip+":"+puerto+";"+"databaseName="+bd+";encrypt=true;trustServerCertificate=true";
            conectar = DriverManager.getConnection(cadenaConexion,usuario,contrasenia);
           JOptionPane.showMessageDialog(null,"Credenciales correctas");
           validacion = true;
       /* if(bandera){ //Si es cierto se genera el select y demas       //Prueba de select desde java
             Statement stm = conectar.createStatement();
              ResultSet rs = stm.executeQuery("Select * from Cliente");
              
             while(rs.next()) {
         System.out.print("Nombre: "+rs.getString("Nombre")+", ");
         System.out.print("Apellidos: "+rs.getString("Apellido"));
         System.out.println();
      }
    }*/
        } catch (HeadlessException | SQLException e) { 
            JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos, error:"+ e.toString());
            validacion = false;
            }
        return conectar;    
        }
  
        /*public int Login (String User, String Password){ //Metodo que iba utilizar previamente con tablas de SQL SERVER de Usuarios replicando las de Security, pero todo se hace
            desde establecer Conexion
            int resultado = 0;

            try {
                Statement ejecutor = conectar.createStatement();
                ResultSet result = ejecutor.executeQuery("Select * from Usuarios Where UsuarioID = '"+User+"'and Contrasenia = '"+Password+"'");

                if (result.next()){
                    JOptionPane.showMessageDialog(null,"Bienvenido");
                    resultado = 1;
                }
                else{
                    JOptionPane.showMessageDialog(null,"Credenciales incorrectas");
                    resultado = 0;
                }
                
            } 
            catch (HeadlessException | SQLException e) { 
                System.out.println("Error al conectar a la base de datos, error:"+ e.toString());
               }
            
            return resultado;
        }*/
}

