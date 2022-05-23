/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Alterar;

import SQL.CapaPresentacion.Operaciones;
import SQL.Conexion;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giovanny Vargas
 */
public class AlterarClientes extends javax.swing.JFrame {

    /**
     * Creates new form AlterarMenu
     */
    public AlterarClientes() {
        initComponents();
        InicializarOpciones();
    }

    private void InicializarOpciones(){
        //Agregar
        ClienteIDTexto.setEnabled(false);
        NombreClienteTexto.setEnabled(false);
        ApellidosClienteTexto.setEnabled(false);
        TarjetaBancariaTexto.setEnabled(false);
        NumeroTelefonoContactoTexto.setEnabled(false);
        //Modificar
        IndiceClienteIDModificar.setEnabled(false);
        buscarButton.setEnabled(false);
        //ClienteIDModificar.setEnabled(false);
        NombreClienteModificar.setEnabled(false);
        ApellidoClienteModificar.setEnabled(false);
        TarjetaBancariaModificar.setEnabled(false);
        NumeroTelefonoContactoModificar.setEnabled(false);
        /*ClienteIDRadioModificar.setEnabled(false);
        NombreClienteRadioModificar.setEnabled(false);
        ApellidosClienteRadioModificar.setEnabled(false);
        TarjetaBancariaRadioModificar.setEnabled(false);
        NumeroTelefonicoContactoRadioModificar.setEnabled(false);*/
        //Eliminar
        ClienteIDEliminar.setEnabled(false);
        TarjetaBancariaEliminar.setEnabled(false);
        NumeroTelefonoContactoEliminar.setEnabled(false);
        ClienteIDRadioEliminar.setEnabled(false);
        TarjetaBancariaRadioEliminar.setEnabled(false);
        NumeroTelefonoContactoRadioEliminar.setEnabled(false);
    }
    private void InicializarAgregar(){
        
        NombreClienteTexto.setEnabled(true);
        ApellidosClienteTexto.setEnabled(true);
        TarjetaBancariaTexto.setEnabled(true);
        NumeroTelefonoContactoTexto.setEnabled(true);
        String ClienteID = null;
        int ClienteIntIDNuevo = 0;
        String ClienteIDNuevo = null;
        try {
            // TODO add your handling code here:
            ClienteIDTexto.setEnabled(false);
            
            bd = new Conexion();
            ResultSet rs = bd.ObtenerID(1);
            
            rs.next();
            ClienteID = rs.getString(1);
            ClienteIntIDNuevo =  Integer.parseInt(ClienteID);
            ClienteIDNuevo = String.valueOf(ClienteIntIDNuevo + 1);
            ClienteIDTexto.setText(ClienteIDNuevo);
            
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AlterarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void InicializarModificar(){
        IndiceClienteIDModificar.setEnabled(true);
        //ClienteIDModificar.setEnabled(true);
        
        /*ClienteIDRadioModificar.setEnabled(true);
        NombreClienteRadioModificar.setEnabled(true);
        ApellidosClienteRadioModificar.setEnabled(true);
        TarjetaBancariaRadioModificar.setEnabled(true);
        NumeroTelefonicoContactoRadioModificar.setEnabled(true);*/
        buscarButton.setEnabled(true);
        
    }
    private void InicializarEliminar(){
       ClienteIDEliminar.setEnabled(true);
       TarjetaBancariaEliminar.setEnabled(true);
       NumeroTelefonoContactoEliminar.setEnabled(true);
       ClienteIDRadioEliminar.setEnabled(true);
       TarjetaBancariaRadioEliminar.setEnabled(true);
       NumeroTelefonoContactoRadioEliminar.setEnabled(true);
    }
    private void OcultarAgregar(){
        ClienteIDTexto.setEnabled(false);
        NombreClienteTexto.setEnabled(false);
        ApellidosClienteTexto.setEnabled(false);
        TarjetaBancariaTexto.setEnabled(false);
        NumeroTelefonoContactoTexto.setEnabled(false);
    }
    private void OcultarModificar() {
        IndiceClienteIDModificar.setEnabled(false);
        /*ClienteIDModificar.setEnabled(false);*/
        NombreClienteModificar.setEnabled(false);
        ApellidoClienteModificar.setEnabled(false);
        TarjetaBancariaModificar.setEnabled(false);
        NumeroTelefonoContactoModificar.setEnabled(false);
        /*ClienteIDRadioModificar.setEnabled(false);
        NombreClienteRadioModificar.setEnabled(false);
        ApellidosClienteRadioModificar.setEnabled(false);
        TarjetaBancariaRadioModificar.setEnabled(false);
        NumeroTelefonicoContactoRadioModificar.setEnabled(false);*/
        buscarButton.setEnabled(false);
    }
     private void OcultarEliminar() {
       ClienteIDEliminar.setEnabled(false);
       TarjetaBancariaEliminar.setEnabled(false);
       NumeroTelefonoContactoEliminar.setEnabled(false);
       ClienteIDRadioEliminar.setEnabled(false);
       TarjetaBancariaRadioEliminar.setEnabled(false);
       NumeroTelefonoContactoRadioEliminar.setEnabled(false);
    }

    private Conexion bd;
    String OpcionElegida;
    int elegir;
    int bandera;
    String IndiceClienteID;
    String ClienteID ;
    String NombreCliente; 
    String ApellidoCliente;
    String TarjetaBancaria;
    String NumeroTelefonoContacto;
    String Query = null;
    
    
    //Este Metodo funciona a la perfeccion
     private void AgregarCliente() {
       ClienteID = ClienteIDTexto.getText();
       NombreCliente = NombreClienteTexto.getText();
       ApellidoCliente = ApellidosClienteTexto.getText();
       TarjetaBancaria = TarjetaBancariaTexto.getText();
       NumeroTelefonoContacto = NumeroTelefonoContactoTexto.getText();
       
       Query = "('"+NombreCliente+"','"+ApellidoCliente+"','"+TarjetaBancaria+"','"+NumeroTelefonoContacto+"');";
       bd = new Conexion();        
       bd.AgregarDatos(Query, 1);
       
       JOptionPane.showMessageDialog(null, "Cliente agregado con éxito.");
     }

     private void ModificarCliente(){
        
         String clienteID = IDModificacion.getText();
         String nombre = NombreClienteModificar.getText();
         String apellidos = ApellidoClienteModificar.getText();
         String tarjeta = TarjetaBancariaModificar.getText();
         String numContact = NumeroTelefonoContactoModificar.getText();
         
         Query = "SET Nombre= '" + nombre + "', Apellido= '" + apellidos 
                 + "', TarjetaBancaria = '" + tarjeta + "', NumeroClienteContacto = '" + numContact
                 + "' WHERE ClienteID = " + clienteID + ";";
         
         bd = new Conexion();
         bd.ModificarDatos(Query, 1);
         
         JOptionPane.showMessageDialog(null, "Cliente modificado con éxito.");

     }
     //Este Metodo funciona a la perfeccion
       private void EliminarCliente() {
           
       if(ClienteIDRadioEliminar.isSelected()) ClienteID = ClienteIDEliminar.getText();    
       if(TarjetaBancariaRadioEliminar.isSelected()) TarjetaBancaria = TarjetaBancariaEliminar.getText();
       if(NumeroTelefonoContactoRadioEliminar.isSelected()) NumeroTelefonoContacto = NumeroTelefonoContactoEliminar.getText();  
       
           
       

            if (ClienteIDRadioEliminar.isSelected()) {
                Query = "DELETE FROM Cliente WHERE ClienteID="+ClienteID+";";
            }
            if(TarjetaBancariaRadioEliminar.isSelected()){
                Query = "DELETE FROM Cliente WHERE TarjetaBancaria='"+TarjetaBancaria+"';";
            }
            if(NumeroTelefonoContactoRadioEliminar.isSelected()){
                Query = "DELETE FROM Cliente WHERE NumeroClienteContacto='"+NumeroTelefonoContacto+"';";
            }
            bd = new Conexion();
            bd.EliminarDatos(Query);
            
            JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        OpcionesDatos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        regresarButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ClienteIDTexto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        NombreClienteTexto = new javax.swing.JTextField();
        ApellidosClienteTexto = new javax.swing.JTextField();
        TarjetaBancariaTexto = new javax.swing.JTextField();
        NumeroTelefonoContactoTexto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        NombreClienteModificar = new javax.swing.JTextField();
        ApellidoClienteModificar = new javax.swing.JTextField();
        TarjetaBancariaModificar = new javax.swing.JTextField();
        NumeroTelefonoContactoModificar = new javax.swing.JTextField();
        IndiceClienteIDModificar = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        IDModificacion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        ClienteIDEliminar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ClienteIDRadioEliminar = new javax.swing.JRadioButton();
        TarjetaBancariaEliminar = new javax.swing.JTextField();
        NumeroTelefonoContactoEliminar = new javax.swing.JTextField();
        TarjetaBancariaRadioEliminar = new javax.swing.JRadioButton();
        NumeroTelefonoContactoRadioEliminar = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("¿Que desea realizar?");

        OpcionesDatos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agregar","Modificar","Eliminar" }));
        OpcionesDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionesDatosActionPerformed(evt);
            }
        });

        jButton1.setText("Realizar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel2.setText("Clientes");

        regresarButton.setText("Regresar");
        regresarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarButtonMouseClicked(evt);
            }
        });
        regresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        ClienteIDTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteIDTextoActionPerformed(evt);
            }
        });

        jLabel5.setText("Agregar");

        ApellidosClienteTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidosClienteTextoActionPerformed(evt);
            }
        });

        jLabel6.setText("Cliente ID");

        jLabel7.setText("Nombre");

        jLabel8.setText("Apellidos");

        jLabel9.setText("Tarjeta Bancaria");

        jLabel10.setText("Telefono Contacto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClienteIDTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NombreClienteTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ApellidosClienteTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(NumeroTelefonoContactoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TarjetaBancariaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClienteIDTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreClienteTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApellidosClienteTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TarjetaBancariaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumeroTelefonoContactoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Modificar");

        jLabel11.setText("ClienteID a Modificar");

        buscarButton.setText("Buscar");
        buscarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarButtonMouseClicked(evt);
            }
        });
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        jLabel13.setText("Nombre");

        jLabel14.setText("Apellidos");

        jLabel15.setText("Tarjeta Bancaria");

        jLabel16.setText("Telefono Contacto");

        jLabel17.setText("ClienteID:");

        IDModificacion.setEditable(false);
        IDModificacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        IDModificacion.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NumeroTelefonoContactoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarButton)
                            .addComponent(IndiceClienteIDModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TarjetaBancariaModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(ApellidoClienteModificar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombreClienteModificar, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(IndiceClienteIDModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarButton)
                    .addComponent(jLabel17)
                    .addComponent(IDModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreClienteModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApellidoClienteModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TarjetaBancariaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumeroTelefonoContactoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        ClienteIDEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteIDEliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Eliminar");

        jLabel12.setText("Escoja en base a que eliminara");

        buttonGroup1.add(ClienteIDRadioEliminar);
        ClienteIDRadioEliminar.setText("Cliente ID");
        ClienteIDRadioEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClienteIDRadioEliminarMouseClicked(evt);
            }
        });
        ClienteIDRadioEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteIDRadioEliminarActionPerformed(evt);
            }
        });

        NumeroTelefonoContactoEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumeroTelefonoContactoEliminarActionPerformed(evt);
            }
        });

        buttonGroup1.add(TarjetaBancariaRadioEliminar);
        TarjetaBancariaRadioEliminar.setText("Tarjeta Bancaria");

        buttonGroup1.add(NumeroTelefonoContactoRadioEliminar);
        NumeroTelefonoContactoRadioEliminar.setText("Telefono Contacto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TarjetaBancariaEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(ClienteIDEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NumeroTelefonoContactoEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NumeroTelefonoContactoRadioEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TarjetaBancariaRadioEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ClienteIDRadioEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel12)))
                        .addGap(0, 47, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClienteIDRadioEliminar)
                    .addComponent(ClienteIDEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TarjetaBancariaEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TarjetaBancariaRadioEliminar))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NumeroTelefonoContactoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumeroTelefonoContactoRadioEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(426, 426, 426)
                        .addComponent(jLabel1)))
                .addContainerGap(476, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regresarButton)
                        .addGap(106, 106, 106))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(442, 442, 442)
                .addComponent(OpcionesDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OpcionesDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(regresarButton)
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        switch(elegir){
            case 1: AgregarCliente();
                    break;
            case 2: ModificarCliente();
                    break;
            case 3: EliminarCliente();
                    break;
        }
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void OpcionesDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionesDatosActionPerformed
        // TODO add your handling code here:
        //InicializarOpciones();
        OpcionElegida = OpcionesDatos.getSelectedItem().toString();
        
        
        
        elegir = 0;
        
        if(OpcionElegida.equals("Agregar")) elegir = 1;
        if(OpcionElegida.equals("Modificar")) elegir = 2;
        if(OpcionElegida.equals("Eliminar")) elegir = 3;
        switch(elegir){
            case 1: InicializarAgregar();
                    OcultarModificar();
                    OcultarEliminar();
                    break;
            case 2: InicializarModificar();
                    OcultarAgregar();
                    OcultarEliminar();
                    break;
            case 3: InicializarEliminar();
                    OcultarAgregar();
                    OcultarModificar();
                    break;
        }
    }//GEN-LAST:event_OpcionesDatosActionPerformed

    private void ClienteIDTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteIDTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClienteIDTextoActionPerformed

    private void ApellidosClienteTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidosClienteTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidosClienteTextoActionPerformed

    private void ClienteIDEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteIDEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClienteIDEliminarActionPerformed

    private void NumeroTelefonoContactoEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumeroTelefonoContactoEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumeroTelefonoContactoEliminarActionPerformed

    private void ClienteIDRadioEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteIDRadioEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClienteIDRadioEliminarActionPerformed

    private void ClienteIDRadioEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClienteIDRadioEliminarMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_ClienteIDRadioEliminarMouseClicked

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void buscarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarButtonMouseClicked
        try {
            // TODO add your handling code here:
            NombreClienteModificar.setEnabled(false);
            ApellidoClienteModificar.setEnabled(false);
            TarjetaBancariaModificar.setEnabled(false);
            NumeroTelefonoContactoModificar.setEnabled(false);
            
            bd = new Conexion();
            String idBuscado = IndiceClienteIDModificar.getText();
            ResultSet rs = bd.ObtenerDatos(1, idBuscado);
            
            rs.next();
            IDModificacion.setText(rs.getString(1));
            NombreClienteModificar.setText(rs.getString(2));
            ApellidoClienteModificar.setText(rs.getString(3));
            TarjetaBancariaModificar.setText(rs.getString(4));
            NumeroTelefonoContactoModificar.setText(rs.getString(5));
            
            NombreClienteModificar.setEnabled(true);
            ApellidoClienteModificar.setEnabled(true);
            TarjetaBancariaModificar.setEnabled(true);
            NumeroTelefonoContactoModificar.setEnabled(true);
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AlterarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarButtonMouseClicked

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regresarButtonActionPerformed

    private void regresarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarButtonMouseClicked
        // TODO add your handling code here:
        Operaciones operaciones = new Operaciones();
        operaciones.setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlterarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ApellidoClienteModificar;
    private javax.swing.JTextField ApellidosClienteTexto;
    private javax.swing.JTextField ClienteIDEliminar;
    private javax.swing.JRadioButton ClienteIDRadioEliminar;
    private javax.swing.JTextField ClienteIDTexto;
    private javax.swing.JTextField IDModificacion;
    private javax.swing.JTextField IndiceClienteIDModificar;
    private javax.swing.JTextField NombreClienteModificar;
    private javax.swing.JTextField NombreClienteTexto;
    private javax.swing.JTextField NumeroTelefonoContactoEliminar;
    private javax.swing.JTextField NumeroTelefonoContactoModificar;
    private javax.swing.JRadioButton NumeroTelefonoContactoRadioEliminar;
    private javax.swing.JTextField NumeroTelefonoContactoTexto;
    private javax.swing.JComboBox<String> OpcionesDatos;
    private javax.swing.JTextField TarjetaBancariaEliminar;
    private javax.swing.JTextField TarjetaBancariaModificar;
    private javax.swing.JRadioButton TarjetaBancariaRadioEliminar;
    private javax.swing.JTextField TarjetaBancariaTexto;
    private javax.swing.JButton buscarButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton regresarButton;
    // End of variables declaration//GEN-END:variables

  

   

   
}
