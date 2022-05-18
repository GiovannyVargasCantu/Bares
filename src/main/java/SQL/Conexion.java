/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

    import com.sun.jdi.Value;
    import java.awt.HeadlessException;
    import java.sql.Connection;

    /**
     *
     * @author Giovanny Vargas
     */
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import java.util.List;
    import java.sql.SQLException;
    import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
    import javax.swing.JOptionPane;

//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import java.sql.ResultSetMetaData;
    
public class Conexion {
    public static Connection conectar = null;
    //String usuario = "usersql";
    //String contrasenia = "root2";
    String bd = "Bares";
    String ip = "localhost";
    String puerto = "1433";
    Statement st = null;
    ResultSet rs = null;
    
    
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
    
       public  List<Value> ConsultaClientes() {
            List<Value> values = new ArrayList<Value>();
             try {
                 st = conectar.createStatement();
                 rs = st.executeQuery("Select * from Cliente");

                 
                 while(rs.next()) {
                     Valores v = new Valores();
                     v.setClienteID(rs.getString("ClienteID"));
                     v.setNombre(rs.getString("Nombre"));
                     v.setApellidos(rs.getString("Apellido"));
                     v.setTarjetaBancaria(rs.getString("TarjetaBancaria"));
                     v.setNumeroTelCliente(rs.getString("NumeroCliente"));
                     values.add((Value) v);
                 }
             } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
             finally{
                 try {
                     rs.close();
                 } catch (SQLException e) {
                 }
                 try {
                     st.close();
                 } catch (SQLException e) {
                 }
             }
        return values;
       }
      
}

