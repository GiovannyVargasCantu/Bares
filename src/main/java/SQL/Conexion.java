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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                Tabla = "Productos";
            break;
            case 12:
                Tabla = "DetalleComanda";
            break;
            case 13:
                 Tabla = "DetalleProveedor"; //TODO
            break;
            case 14:
                 Tabla = "DetalleTicket"; //TODO
            break;
            case 15: 
                 Tabla = "Mesas"; //TODO
            break;
            case 16: 
                 Tabla = "MeseroAtiendeMesa"; //TODO
            break;
            case 17:
                 Tabla = "TipoProducto"; //TODO
            break;
            case 18: 
                 Tabla = "Usuarios"; //TODO
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
                TablaModificar = "Productos";
            break;
            case 12:
                TablaModificar = "DetalleComanda";
            break;
            case 13:
                 TablaModificar = "DetalleProveedor"; //TODO
            break;
            case 14:
                 TablaModificar = "DetalleTicket"; //TODO
            break;
            case 15: 
                 TablaModificar = "Mesas"; //TODO
            break;
            case 16: 
                 TablaModificar = "MeseroAtiendeMesa"; //TODO
            break;
            case 17:
                 TablaModificar = "TipoProducto"; //TODO
            break;
            case 18: 
                 TablaModificar = "Usuarios"; //TODO
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
                TablaModificar = "Productos";
            break;
            case 12:
                TablaModificar = "DetalleComanda";
            break;
            case 13:
                 TablaModificar = "DetalleProveedor"; //TODO
            break;
            case 14:
                 TablaModificar = "DetalleTicket"; //TODO
            break;
            case 15: 
                 TablaModificar = "Mesas"; //TODO
            break;
            case 16: 
                 TablaModificar = "MeseroAtiendeMesa"; //TODO
            break;
            case 17:
                 TablaModificar = "TipoProducto"; //TODO
            break;
            case 18: 
                 TablaModificar = "Usuarios"; //TODO
            break;
            //Add more cases for the other tables!
        }
        
        ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            String query = "UPDATE " + TablaModificar + " "+ Query;

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            s.executeUpdate(query);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void EliminarDatos(String Query) {
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
        int comillasNecesitadas = 0;
        switch(Tabla) {
            case 1:
                TablaModificar = "Cliente";
                IDBuscado = "ClienteID";
            break;
            case 2:
                TablaModificar = "Proveedor";
                IDBuscado = "ProveedorID";
            break;
            case 3:
                TablaModificar = "Empleado";
                IDBuscado = "EmpleadoID";
            break;
            case 4:
                TablaModificar = "Horario";
                IDBuscado = "HorarioID";
                comillasNecesitadas = 1;
            break;
            case 5:
                TablaModificar = "Puesto";
                IDBuscado = "PuestoID";
            break;
            case 6:
                TablaModificar = "Factura";
                IDBuscado = "FacturaID";
            break;
            case 7:
                TablaModificar = "Ticket";
                IDBuscado = "TicketID";
            break;
            case 8:
                TablaModificar = "Comanda";
                IDBuscado = "ComandaID";
            break;
            case 9:
                TablaModificar = "Estados";
                IDBuscado = "EstadosID";
            break;
            case 10:
                TablaModificar = "Municipios";
                IDBuscado = "MunicipiosID";
            break;
            case 11:
                TablaModificar = "Productos";
                IDBuscado = "ProductoID";
            break;
            case 12:
                TablaModificar = "DetalleComanda"; 
            break;
            case 13:
                 TablaModificar = "DetalleProveedor"; //TODO
            break;
            case 14:
                 TablaModificar = "DetalleTicket"; //TODO
            break;
            case 15: 
                 TablaModificar = "Mesas";
                 IDBuscado = "MesaID";//TODO
            break;
            case 16: 
                 TablaModificar = "MeseroAtiendeMesa"; //TODO
            break;
            case 17:
                 TablaModificar = "TipoProducto";
                 IDBuscado = "TipoProductoID";
            break;
            case 18: 
                 TablaModificar = "Usuarios";
                 IDBuscado = "UsuarioID";//TODO
            break;
        }
        
        ResultSet rs = null;
        try {
            String query;
            
            Statement s = conexion.createStatement();
            if(comillasNecesitadas == 0) {
                query = "SELECT * FROM " + TablaModificar + " WHERE " + IDBuscado + " = " + Buscado;
            } else {
                query = "SELECT * FROM " + TablaModificar + " WHERE " + IDBuscado + " = '" + Buscado + "'";
            }
            
            rs = s.executeQuery(query);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet ObtenerID(int Tabla) {
        String TablaBuscar = null;
        String IDBuscado = null;
        String query = null;
        int elegir = 0; //Esto es para los autoincrementos cambia el query.
        switch(Tabla) {
            case 1:
                TablaBuscar = "Cliente";
                elegir = 1;
            break;
            case 2:
                TablaBuscar = "Proveedor";
                elegir = 1;
            break;
            case 3:
                TablaBuscar = "Empleado";
                elegir = 1;
            break;
            case 4:
                TablaBuscar = "Horario";
            break;
            case 5:
                TablaBuscar = "Puesto";
                elegir = 1;
            break;
            case 6:
                TablaBuscar = "Factura";
                elegir = 1;
            break;
            case 7:
                TablaBuscar = "Ticket";
                elegir = 1;
            break;
            case 8:
                TablaBuscar = "Comanda";
                elegir = 1;
            break;
            case 9:
                TablaBuscar = "Estados";
            break;
            case 10:
                TablaBuscar = "Municipios";
            break;
            case 11:
                TablaBuscar = "Productos";
                elegir = 1;
            break;
            case 12:
                TablaBuscar = "DetalleComanda";
            break;
            case 13:
                 TablaBuscar = "DetalleProveedor"; //TODO
            break;
            case 14:
                 TablaBuscar = "DetalleTicket"; //TODO
            break;
            case 15: 
                 TablaBuscar = "Mesas"; //TODO
                 elegir = 1;
            break;
            case 16: 
                 TablaBuscar = "MeseroAtiendeMesa"; //TODO
            break;
            case 17:
                 TablaBuscar = "TipoProducto"; //TODO
                 elegir = 1;
            break;
            case 18: 
                 TablaBuscar = "Usuarios"; //TODO
                 elegir = 1;
            break;
        }
        
        ResultSet rs = null;
        try {
            Statement s = conexion.createStatement();
            if(elegir == 1){
            query = "select IDENT_CURRENT( '"+TablaBuscar+"' )";
            }
            else{
                query = "SELECT MAX("+IDBuscado+") FROM " + TablaBuscar + "";
            }
            rs = s.executeQuery(query);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public String[] ObtenerNombreTablas() {
        ResultSet rs = null;
        ArrayList<String> list = new ArrayList<String>();
        String[] tablas = null;
        try {
            Statement s = conexion.createStatement();
            String query = "SELECT name\n" +
"FROM sys.Tables";
            
            rs = s.executeQuery(query);
            while(rs.next()){
                list.add(rs.getString(1));
            }
            tablas = new String[list.size()];
            list.toArray(tablas);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tablas;
    }

    public String[] ObtenerNombreColumnas(int NombreTabla) {
        String Tabla = null;
        switch(NombreTabla) {
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
                Tabla = "Productos";
            break;
            case 12:
                Tabla = "DetalleComanda";
            break;
            case 13:
                 Tabla = "DetalleProveedor"; //TODO
            break;
            case 14:
                 Tabla = "DetalleTicket"; //TODO
            break;
            case 15: 
                 Tabla = "Mesas"; //TODO
            break;
            case 16: 
                 Tabla = "MeseroAtiendeMesa"; //TODO
            break;
            case 17:
                 Tabla = "TipoProducto"; //TODO
            break;
            case 18: 
                 Tabla = "Usuarios"; //TODO
            break;
            //Add some more!
        }
        
        ResultSet rs = null;
        ArrayList<String> list = new ArrayList<String>();
        String[] tablas = null;
        try {
            Statement s = conexion.createStatement();
            String query = "SELECT COLUMN_NAME\n" +
"FROM INFORMATION_SCHEMA.COLUMNS\n" +
"WHERE TABLE_NAME = N'"+Tabla+"'";
            
            rs = s.executeQuery(query);
            while(rs.next()){
                list.add(rs.getString(1));
            }
            tablas = new String[list.size()];
            list.toArray(tablas);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tablas;
    }

    public int ObtenerPuestoID() {
        int puesto = 0;
        ResultSet rs = null;
        try {
            Statement s = conexion.createStatement(); 
            String query = "Select PuestoID from Usuarios where NombreUsuario = '"+Ingresar.usuario+"'";
            rs = s.executeQuery(query);
            rs.next();
            puesto = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return puesto;
        
    }

    public String[] ObtenerIDs(int Tabla) {
        String TablaBuscar = null;
        String query = null;
        String ID = null;
        
        int elegir = 0; //Esto es para los autoincrementos cambia el query.
        switch(Tabla) {
            case 1:
                TablaBuscar = "Cliente";
                ID = "ClienteID";
            break;
            case 2:
                TablaBuscar = "Proveedor";
                ID = "ProveedorID";
            break;
            case 3:
                TablaBuscar = "Empleado";
                ID = "EmpleadoID";
            break;
            case 4:
                TablaBuscar = "Horario";
                ID = "HorarioID";
            break;
            case 5:
                TablaBuscar = "Puesto";
                ID = "NombrePuesto";
            break;
            case 6:
                TablaBuscar = "Factura";
                ID = "FacturaID";
            break;
            case 7:
                TablaBuscar = "Ticket";
                ID = "TicketID";
            break;
            case 8:
                TablaBuscar = "Comanda";
                ID = "ComandaID";
            break;
            case 9:
                TablaBuscar = "Estados";
                ID = "EstadoID";
            break;
            case 10:
                TablaBuscar = "Municipios";
                ID = "Nombre";
            break;
            case 11:
                TablaBuscar = "Productos";
                ID = "ProductoID";
            break;
            case 12:
                TablaBuscar = "DetalleComanda";
                //ID = "DetalleComandaID";
            break;
            case 13:
                 TablaBuscar = "DetalleProveedor"; //TODO
                //ID = "DetalleProveedorID";
            break;
            case 14:
                 TablaBuscar = "DetalleTicket"; //TODO
                //ID = "DetalleTicketID";
            break;
            case 15: 
                 TablaBuscar = "Mesas"; //TODO
                ID = "MesaID";
            break;
            case 16: 
                 TablaBuscar = "MeseroAtiendeMesa"; //TODO
                //ID = "";
            break;
            case 17:
                 TablaBuscar = "TipoProducto"; //TODO
                ID = "TipoProductoID";
            break;
            case 18: 
                 TablaBuscar = "Usuarios"; //TODO
                ID = "UsuarioID";
            break;
        }
       ResultSet rs = null;
        ArrayList<String> list = new ArrayList<String>();
        String[] IDs = null;
        try {
            Statement s = conexion.createStatement();
            query = "SELECT "+ID+" FROM "+TablaBuscar+" ORDER BY "+ID+" ASC";
            
            rs = s.executeQuery(query);
            while(rs.next()){
                list.add(rs.getString(1));
            }
            IDs = new String[list.size()];
            list.toArray(IDs);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDs;
    }
     public int MunicipioID(String MunicipioNombre) {
        int ID = 0;
        ResultSet rs = null;
        String Nombre = MunicipioNombre;
         try {
            Statement s = conexion.createStatement();
                
            String query = "SELECT MunicipioID FROM Municipios WHERE Nombre = '"+Nombre+"'";
            
            rs = s.executeQuery(query);
            rs.next();
            ID = rs.getInt(1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ID;
            }

    public String MunicipioNombre(int ID) {
        String Nombre = null;
        ResultSet rs = null;
         try {
            Statement s = conexion.createStatement();
                
            String query = "SELECT Nombre FROM Municipios WHERE MunicipioID = "+ID+"";
            
            rs = s.executeQuery(query);
            rs.next();
            Nombre = rs.getString(1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Nombre;
    }

    public int PuestoID(String Nombre) {
       int ID = 0;
        ResultSet rs = null;
         try {
            Statement s = conexion.createStatement();
                
            String query = "SELECT PuestoID FROM Puesto WHERE NombrePuesto = '"+Nombre+"'";
            
            rs = s.executeQuery(query);
            rs.next();
            ID = rs.getInt(1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ID;
    }

    public String PuestoNombre(int ID) {
       String Nombre = null;
        ResultSet rs = null;
         try {
            Statement s = conexion.createStatement();
                
            String query = "SELECT NombrePuesto FROM Puesto WHERE PuestoID = "+ID+"";
            
            rs = s.executeQuery(query);
            rs.next();
            Nombre = rs.getString(1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Nombre;
    }
    
   
}

