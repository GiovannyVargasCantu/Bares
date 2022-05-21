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

    public ResultSet CatalogoEmpleados() {
       ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "Select * from Empleado";

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet CatalogoHorarios() {
         ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "Select * from Horario";

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet CatalogoPuestos() {
        ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "Select * from Puesto";

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet CatalogoFacturas() {
       ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "Select * from Factura";

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet CatalogoTickets() {
        ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "Select * from Ticket";

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet CatalogoComandas() {
      ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "Select * from Comanda";

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet CatalogoEstados() {
        ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "Select * from Estados";

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet CatalogoMunicipios() {
       ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "Select * from Municipios";

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(query);
        } catch (Exception e)
        {
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

    public void AgregarClientes(String Query) {
       ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = Query;

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
                TablaModificar = "Empleados";
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
            s.executeQuery(query);
            System.out.println("Record deleted successfully");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public ResultSet ObtenerDatos(int Tabla, String Buscado) {
        String tablaModificar = null;
        switch(Tabla) {
            case 1:
                tablaModificar = "Cliente";
            break;
        }
        
        ResultSet rs = null;
        try {
            Statement s = conexion.createStatement();
            String query = "SLECT * FROM " + tablaModificar + " WHERE ClienteID = " + Buscado;
            
            rs = s.executeQuery(query);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}

