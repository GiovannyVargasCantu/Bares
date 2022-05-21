/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Alterar;

import SQL.Conexion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giovanny Vargas
 */
public class AlterarMenu extends javax.swing.JFrame {

    /**
     * Creates new form AlterarMenu
     */
    public AlterarMenu() {
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
        IndiceClienteIDModficar.setEnabled(false);
        ClienteIDModificar.setEnabled(false);
        NombreClienteModificar.setEnabled(false);
        ApellidoClienteModificar.setEnabled(false);
        TarjetaBancariaModificar.setEnabled(false);
        NumeroTelefonoContactoModificar.setEnabled(false);
        ClienteIDRadioModificar.setEnabled(false);
        NombreClienteRadioModificar.setEnabled(false);
        ApellidosClienteRadioModificar.setEnabled(false);
        TarjetaBancariaRadioModificar.setEnabled(false);
        NumeroTelefonicoContactoRadioModificar.setEnabled(false);
        //Eliminar
        jTextField3.setEnabled(false);
    }
    private void InicializarAgregar(){
        ClienteIDTexto.setEnabled(true);
        NombreClienteTexto.setEnabled(true);
        ApellidosClienteTexto.setEnabled(true);
        TarjetaBancariaTexto.setEnabled(true);
        NumeroTelefonoContactoTexto.setEnabled(true);
    }
    private void InicializarModificar(){
        IndiceClienteIDModficar.setEnabled(true);
        ClienteIDModificar.setEnabled(true);
        NombreClienteModificar.setEnabled(true);
        ApellidoClienteModificar.setEnabled(true);
        TarjetaBancariaModificar.setEnabled(true);
        NumeroTelefonoContactoModificar.setEnabled(true);
        ClienteIDRadioModificar.setEnabled(true);
        NombreClienteRadioModificar.setEnabled(true);
        ApellidosClienteRadioModificar.setEnabled(true);
        TarjetaBancariaRadioModificar.setEnabled(true);
        NumeroTelefonicoContactoRadioModificar.setEnabled(true);
        
    }
    private void InicializarEliminar(){
        jTextField3.setEnabled(true);
    }
    private void OcultarAgregar(){
        ClienteIDTexto.setEnabled(false);
        NombreClienteTexto.setEnabled(false);
        ApellidosClienteTexto.setEnabled(false);
        TarjetaBancariaTexto.setEnabled(false);
        NumeroTelefonoContactoTexto.setEnabled(false);
    }
    private void OcultarModificar() {
        IndiceClienteIDModficar.setEnabled(false);
        ClienteIDModificar.setEnabled(false);
        NombreClienteModificar.setEnabled(false);
        ApellidoClienteModificar.setEnabled(false);
        TarjetaBancariaModificar.setEnabled(false);
        NumeroTelefonoContactoModificar.setEnabled(false);
        ClienteIDRadioModificar.setEnabled(false);
        NombreClienteRadioModificar.setEnabled(false);
        ApellidosClienteRadioModificar.setEnabled(false);
        TarjetaBancariaRadioModificar.setEnabled(false);
        NumeroTelefonicoContactoRadioModificar.setEnabled(false);
    }
     private void OcultarEliminar() {
       jTextField3.setEnabled(false);
    }

    private Conexion bd;
    String OpcionElegida;
    int elegir;
    String IndiceClienteID;
    String ClienteID ;
    String NombreCliente; 
    String ApellidoCliente;
    String TarjetaBancaria;
    String NumeroTelefonoContacto;
    
     private void AgregarCliente() {
       ClienteID = ClienteIDTexto.getText();
       NombreCliente = NombreClienteTexto.getText();
       ApellidoCliente = ApellidosClienteTexto.getText();
       TarjetaBancaria = TarjetaBancariaTexto.getText();
       NumeroTelefonoContacto = NumeroTelefonoContactoTexto.getText();
       
       String Query = "INSERT INTO CLIENTE VALUES (" +ClienteID+ ",'"+NombreCliente+"','"+ApellidoCliente+"','"+TarjetaBancaria+"','"+NumeroTelefonoContacto+"');";
       bd = new Conexion();        
       bd.AgregarClientes(Query);
     }
     
     private void ModificarCliente(){
         IndiceClienteID =IndiceClienteIDModficar.getText();
         String Query = null;
         if(ClienteIDRadioModificar.isSelected()) ClienteID = ClienteIDModificar.getText();
         if(NombreClienteRadioModificar.isSelected()) NombreCliente = NombreClienteModificar.getText();
         if(ApellidosClienteRadioModificar.isSelected()) ApellidoCliente = ApellidoClienteModificar.getText();
         if(TarjetaBancariaRadioModificar.isSelected()) TarjetaBancaria = TarjetaBancariaModificar.getText();
         if(NumeroTelefonicoContactoRadioModificar.isSelected()) NumeroTelefonoContacto = NumeroTelefonoContactoModificar.getText();
         
        
             
         /*if((ClienteIDRadioModificar.isSelected())&&(NombreClienteRadioModificar.isSelected())&&(ApellidosClienteRadioModificar.isSelected())&&(TarjetaBancariaRadioModificar.isSelected())&&(NumeroTelefonicoContactoRadioModificar.isSelected())){
             Query = "UPDATE Cliente SET ClienteID = "+ClienteID+",Nombre='"+NombreCliente+"',Apellido='"+ApellidoCliente+"',TarjetaBancaria = '"+TarjetaBancariaModificar+"',NumeroClienteContacto='"+NumeroTelefonoContactoModificar+"' WHERE ClienteID ="+IndiceClienteID+";";
         }     
         
         //else if((ClienteIDRadioModificar.isSelected())&&(NombreClienteRadioModificar.isSelected())&&(ApellidosClienteRadioModificar.isSelected())&&(TarjetaBancariaRadioModificar.isSelected())){
             Query = "UPDATE Cliente SET ClienteID = "+ClienteID+",Nombre='"+NombreCliente+"',Apellido='"+ApellidoCliente+"',TarjetaBancaria = '"+TarjetaBancariaModificar+"' WHERE ClienteID ="+IndiceClienteID+";";
         }
             
             
         else if((ClienteIDRadioModificar.isSelected())&&(NombreClienteRadioModificar.isSelected())&&(ApellidosClienteRadioModificar.isSelected())){
             Query = "UPDATE Cliente SET ClienteID = "+ClienteID+",Nombre='"+NombreCliente+"',Apellido='"+ApellidoCliente+"' WHERE ClienteID ="+IndiceClienteID+";";
         
         }
         //Cliente ID 
         else if((ClienteIDRadioModificar.isSelected())&&(NombreClienteRadioModificar.isSelected())){
             Query = "UPDATE Cliente SET ClienteID = "+ClienteID+",Nombre='"+NombreCliente+"' WHERE ClienteID ="+IndiceClienteID+";";
             
         }
         else*/if((ClienteIDRadioModificar.isSelected())){
             Query = "UPDATE Cliente SET ClienteID = "+ClienteID+" WHERE ClienteID ="+IndiceClienteID+";";
          
         }
         
         
         
         bd = new Conexion();
         bd.ModificarClientes(Query);

     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        OpcionesDatos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
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
        ClienteIDRadioModificar = new javax.swing.JRadioButton();
        NombreClienteRadioModificar = new javax.swing.JRadioButton();
        ApellidosClienteRadioModificar = new javax.swing.JRadioButton();
        TarjetaBancariaRadioModificar = new javax.swing.JRadioButton();
        NumeroTelefonicoContactoRadioModificar = new javax.swing.JRadioButton();
        ClienteIDModificar = new javax.swing.JTextField();
        NombreClienteModificar = new javax.swing.JTextField();
        ApellidoClienteModificar = new javax.swing.JTextField();
        TarjetaBancariaModificar = new javax.swing.JTextField();
        NumeroTelefonoContactoModificar = new javax.swing.JTextField();
        IndiceClienteIDModficar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

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

        jButton2.setText("Regresar");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Modificar");

        jLabel11.setText("ClienteID a Modificar");

        ClienteIDRadioModificar.setText("Cliente ID");

        NombreClienteRadioModificar.setText("Nombre");

        ApellidosClienteRadioModificar.setText("Apellidos");

        TarjetaBancariaRadioModificar.setText("Tarjeta Bancaria");
        TarjetaBancariaRadioModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TarjetaBancariaRadioModificarActionPerformed(evt);
            }
        });

        NumeroTelefonicoContactoRadioModificar.setText("Telefono Contacto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(IndiceClienteIDModficar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ClienteIDModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(NombreClienteModificar)
                            .addComponent(ApellidoClienteModificar)
                            .addComponent(TarjetaBancariaModificar)
                            .addComponent(NumeroTelefonoContactoModificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(NumeroTelefonicoContactoRadioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TarjetaBancariaRadioModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ApellidosClienteRadioModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NombreClienteRadioModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ClienteIDRadioModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21))))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(IndiceClienteIDModficar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClienteIDModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClienteIDRadioModificar))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreClienteRadioModificar)
                    .addComponent(NombreClienteModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ApellidosClienteRadioModificar)
                    .addComponent(ApellidoClienteModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TarjetaBancariaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TarjetaBancariaRadioModificar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumeroTelefonoContactoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumeroTelefonicoContactoRadioModificar))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Eliminar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(106, 106, 106))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addComponent(jButton2)
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
            case 3: System.out.println("JG DIFF");
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

    private void TarjetaBancariaRadioModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TarjetaBancariaRadioModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TarjetaBancariaRadioModificarActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ApellidoClienteModificar;
    private javax.swing.JRadioButton ApellidosClienteRadioModificar;
    private javax.swing.JTextField ApellidosClienteTexto;
    private javax.swing.JTextField ClienteIDModificar;
    private javax.swing.JRadioButton ClienteIDRadioModificar;
    private javax.swing.JTextField ClienteIDTexto;
    private javax.swing.JTextField IndiceClienteIDModficar;
    private javax.swing.JTextField NombreClienteModificar;
    private javax.swing.JRadioButton NombreClienteRadioModificar;
    private javax.swing.JTextField NombreClienteTexto;
    private javax.swing.JRadioButton NumeroTelefonicoContactoRadioModificar;
    private javax.swing.JTextField NumeroTelefonoContactoModificar;
    private javax.swing.JTextField NumeroTelefonoContactoTexto;
    private javax.swing.JComboBox<String> OpcionesDatos;
    private javax.swing.JTextField TarjetaBancariaModificar;
    private javax.swing.JRadioButton TarjetaBancariaRadioModificar;
    private javax.swing.JTextField TarjetaBancariaTexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

   

   
}
