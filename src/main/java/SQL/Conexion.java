/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;


    /**
     *
     * @author Giovanny Vargas
     */

    import SQL.CapaPresentacion.Ingresar;
    import java.awt.HeadlessException;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import javax.swing.JOptionPane;

//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import java.sql.ResultSetMetaData;
    
public class Conexion {
    public static Connection conexion = null;
    public static String cadenaconexion = "jdbc:sqlserver://localhost:1433;databaseName=Bares;encrypt=true;trustServerCertificate=true";
    public static boolean validacion = true;
    public Connection establecerConexion(){
         //System.out.println(usuario);
         //System.out.println(contrasenia);

        try {
            conexion = DriverManager.getConnection(cadenaconexion,Ingresar.usuario,Ingresar.contrasenia);
            System.out.println(Ingresar.usuario);
            System.out.println(Ingresar.contrasenia);
           JOptionPane.showMessageDialog(null,"Credenciales correctas");
           validacion = true;
        } catch (HeadlessException | SQLException e) { 
            JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos, error:"+ e.toString());
            validacion = false;
            }
        return conexion;    
        }
    
    public void estableceConexion()
    {
        if (conexion != null)
            return;

        try
        {
           conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Bares;encrypt=true;trustServerCertificate=true","usersql","root2");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
     public ResultSet dameListaClientes()
    {
        ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "Select * from Cliente";

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
     
    public void cierraConexion()
    {
        try
        {
            conexion.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ResultSet CatalogoProveedores() {
      ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "Select * from Proveedor";

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
}

