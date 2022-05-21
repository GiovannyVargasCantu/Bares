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
    public static String cadenaconexion = "jdbc:sqlserver://localhost:1433;databaseName=Bares12;encrypt=true;trustServerCertificate=true";
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
           conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Bares12;encrypt=true;trustServerCertificate=true","usersql","root2");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
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
    
    public ResultSet Catalogo(int TablaCatalogo) {
        String Tabla = null;
        switch(TablaCatalogo) {
            case 1:
                Tabla = "Cliente";
            break;
            case 2:
                Tabla = "Proveedor";
            break;
            case 3:
                Tabla = "Empleado";
            break;
            case 4:
                Tabla = "Horario";
            break;
            case 5:
                Tabla = "Puesto";
            break;
            case 6:
                Tabla = "Factura";
            break;
            case 7:
                Tabla = "Ticket";
            break;
            case 8:
                Tabla = "Comanda";
            break;
            case 9:
                Tabla = "Estados";
            break;
            case 10:
                Tabla = "Municipios";
            break;
            case 11:
                Tabla = "Producto";
            break;
            //Add some more!
        }
        
        ResultSet rs = null;
        try {
            //Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "SELECT * FROM " + Tabla;
            
            rs = s.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet ConsultarBusqueda(String Query) {
        
        ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = Query;

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public void AgregarDatos(String Query, int Tabla) {
        String TablaModificar = null;
        switch(Tabla) {
            case 1:
                TablaModificar = "Cliente";
            break;
            case 2:
                TablaModificar = "Proveedor";
            break;
            case 3:
                TablaModificar = "Empleado";
            break;
            case 4:
                TablaModificar = "Horario";
            break;
            case 5:
                TablaModificar = "Puesto";
            break;
            case 6:
                TablaModificar = "Factura";
            break;
            case 7:
                TablaModificar = "Ticket";
            break;
            case 8:
                TablaModificar = "Comanda";
            break;
            case 9:
                TablaModificar = "Estados";
            break;
            case 10:
                TablaModificar = "Municipios";
            break;
            case 11:
                TablaModificar = "Producto";
            break;
        }
        
        ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "INSERT INTO " + TablaModificar
                + " VALUES " + Query;

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            s.executeUpdate(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
     
    }

    public void ModificarDatos(String Query, int Tabla) {
        String TablaModificar = null;
        switch(Tabla) {
            case 1:
                TablaModificar = "Cliente";
            break;
            case 2:
                TablaModificar = "Proveedor";
            break;
            case 3:
                TablaModificar = "Empleado";
            break;
            case 4:
                TablaModificar = "Horario";
            break;
            case 5:
                TablaModificar = "Puesto";
            break;
            case 6:
                TablaModificar = "Factura";
            break;
            case 7:
                TablaModificar = "Ticket";
            break;
            case 8:
                TablaModificar = "Comanda";
            break;
            case 9:
                TablaModificar = "Estados";
            break;
            case 10:
                TablaModificar = "Municipios";
            break;
            case 11:
                TablaModificar = "Producto";
            break;
            //Add more cases for the other tables!
        }
        
        ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "UPDATE " + TablaModificar + Query;

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            s.executeUpdate(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void EliminarClientes(String Query) {
        ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = Query;

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            s.executeUpdate(query);
            System.out.println("Record deleted successfully");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public ResultSet ObtenerDatos(int Tabla, String Buscado) {
        String TablaModificar = null;
        String IDBuscado = null;
        switch(Tabla) {
            case 1:
                TablaModificar = "Cliente";
                IDBuscado = "ClienteID";
            break;
            case 2:
                TablaModificar = "Proveedor";
            break;
            case 3:
                TablaModificar = "Empleado";
            break;
            case 4:
                TablaModificar = "Horario";
            break;
            case 5:
                TablaModificar = "Puesto";
            break;
            case 6:
                TablaModificar = "Factura";
            break;
            case 7:
                TablaModificar = "Ticket";
            break;
            case 8:
                TablaModificar = "Comanda";
            break;
            case 9:
                TablaModificar = "Estados";
            break;
            case 10:
                TablaModificar = "Municipios";
            break;
            case 11:
                TablaModificar = "Producto";
            break;
        }
        
        ResultSet rs = null;
        try {
            Statement s = conexion.createStatement();
            String query = "SLECT * FROM " + TablaModificar + " WHERE " + IDBuscado + " = " + Buscado;
            
            rs = s.executeQuery(query);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}

