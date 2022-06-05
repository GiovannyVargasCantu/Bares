/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Alterar;

import SQL.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Giovanny Vargas
 */
public class AlterarUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form AlterarMenu
     */
    public AlterarUsuarios() {
        initComponents();
        InicializarOpciones();
    }

    private void InicializarOpciones(){
        //Agregar
        UsuarioIDTexto.setEnabled(false);
        NombreUsuarioTexto.setEnabled(false);
        ContraseniaTexto.setEnabled(false);
        PuestoTxT.setEnabled(false);
        //Modificar
        UsuarioIDModificar.setEnabled(false);
        buscarButton.setEnabled(false);
        NombreUsuarioModificar.setEnabled(false);
        ContraseniaModificar.setEnabled(false);
        //Eliminar
        EmpleadoIDEliminar.setEnabled(false);
        EmpleadoIDRadioEliminar.setEnabled(false);
    }
    private void InicializarAgregar(){
        
        NombreUsuarioTexto.setEnabled(true);
        ContraseniaTexto.setEnabled(true);
        PuestoTxT.setEnabled(true);
        String ID = null;
        int IntIDNuevo = 0;
        String IDNuevo = null;
        try {
            // TODO add your handling code here:
            UsuarioIDTexto.setEnabled(false);
            
            bd = new Conexion();
            ResultSet rs = bd.ObtenerID(18);
            
            rs.next();
            ID= rs.getString(1);
            IntIDNuevo =  Integer.parseInt(ID);
            IDNuevo = String.valueOf(IntIDNuevo + 1);
            UsuarioIDTexto.setText(IDNuevo);
            
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AlterarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void InicializarModificar(){
        UsuarioIDModificar.setEnabled(true);
        buscarButton.setEnabled(true);
        PuestoModificarTxT.setEnabled(true);
        
    }
    private void InicializarEliminar(){
       EmpleadoIDEliminar.setEnabled(true);
       EmpleadoIDRadioEliminar.setEnabled(true);
    }
    private void OcultarAgregar(){
        UsuarioIDTexto.setEnabled(false);
        NombreUsuarioTexto.setEnabled(false);
        ContraseniaTexto.setEnabled(false);
        PuestoTxT.setEnabled(false);
    }
    private void OcultarModificar() {
        UsuarioIDModificar.setEnabled(false);
        NombreUsuarioModificar.setEnabled(false);
        ContraseniaModificar.setEnabled(false);
        PuestoModificarTxT.setEnabled(false);
        buscarButton.setEnabled(false);
    }
     private void OcultarEliminar() {
       EmpleadoIDEliminar.setEnabled(false);
       EmpleadoIDRadioEliminar.setEnabled(false);
    }

    private Conexion bd;
    String OpcionElegida;
    int elegir;
    int bandera;
    String[] UsuarioID = ObtenerIDS(18);
    String Campo1 ;//Empleado
    String Campo2; //Nom
    String Campo3;//Ape
    int Campo4;//Corr
    String Query = null;
    String[] PuestoNombres= ObtenerIDS(5);
    String[] PuestoNombresModificar = ObtenerIDS(5);
    
    
    
    //Este Metodo funciona a la perfeccion
     private void AgregarUsuarios() {
       //Campo1 = EmpleadoIDTexto.getText();
       Campo2 = NombreUsuarioTexto.getText();
       Campo3 = ContraseniaTexto.getText();
       String aux2 = PuestoTxT.getSelectedItem().toString();
       Campo4 = ObtenerPuestoNombre(aux2);
       
       //INSERT INTO BALBLABA VALUES ()
           Query = "('"+Campo2+"','"+Campo3+"',"+Campo4+")";

       bd = new Conexion();        
       bd.AgregarDatos(Query, 18);
       
       JOptionPane.showMessageDialog(null, "Cliente agregado con éxito.");
     }

     private void ModificarUsuarios(){
         Campo1 = IDModificacion.getText();
         Campo2 = NombreUsuarioModificar.getText();
         Campo3 = ContraseniaModificar.getText();
         String aux2 = PuestoModificarTxT.getSelectedItem().toString();
         Campo4 = ObtenerPuestoNombre(aux2);
         System.out.println(Campo4);
             Query = "SET NombreUsuario='"+Campo2+"',Contrasenia = '"+Campo3+"',PuestoID = "+Campo4+"  WHERE UsuarioID = " + Campo1 + ";";
         bd = new Conexion();
         bd.ModificarDatos(Query, 18);
         
         JOptionPane.showMessageDialog(null, "Cliente modificado con éxito.");

     }
     //Este Metodo funciona a la perfeccion
       private void EliminarUsuarios() {
           
       if(EmpleadoIDRadioEliminar.isSelected()) Campo1 = EmpleadoIDEliminar.getText();   
       
           
       

            if (EmpleadoIDRadioEliminar.isSelected()) {
                Query = "DELETE FROM Usuarios WHERE UsuarioID="+Campo1+";";
            }
          
            
            bd = new Conexion();
            bd.EliminarDatos(Query);
            
            JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito.");
    }
       private String[] ObtenerIDS(int tabla) {
        bd = new Conexion();
        return bd.ObtenerIDs(tabla);
    }
         private int ObtenerPuestoNombre(String Nombre) {
        bd = new Conexion();
        return bd.PuestoID(Nombre);
    }
         private String ObtenerPuestoID(int ID) {
      bd = new Conexion();
      return bd.PuestoNombre(ID);
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
        jLabel20 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        OpcionesDatos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        regresarButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        UsuarioIDTexto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Puesto = new javax.swing.JLabel();
        PuestoTxT = new javax.swing.JComboBox<>();
        ContraseniaTexto = new javax.swing.JPasswordField();
        NombreUsuarioTexto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        DecoEmpleadoIDModificar = new javax.swing.JLabel();
        NombreUsuarioModificar = new javax.swing.JTextField();
        ContraseniaModificar = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        DecoEmpleadoID = new javax.swing.JLabel();
        IDModificacion = new javax.swing.JTextField();
        UsuarioIDModificar = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        PuestoModificarTxT = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        EmpleadoIDEliminar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        EmpleadoIDRadioEliminar = new javax.swing.JRadioButton();

        jLabel20.setText("jLabel20");

        jTextField1.setText("jTextField1");

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

        jLabel2.setText("Usuarios");

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

        UsuarioIDTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioIDTextoActionPerformed(evt);
            }
        });

        jLabel5.setText("Agregar");

        jLabel6.setText("Usuario ID");

        jLabel7.setText("Nombre Usuario");

        jLabel8.setText("Contraseña");

        Puesto.setText("Puesto");

        PuestoTxT.setModel(new javax.swing.DefaultComboBoxModel<>(PuestoNombres));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ContraseniaTexto)
                            .addComponent(UsuarioIDTexto)
                            .addComponent(NombreUsuarioTexto))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(Puesto)
                        .addGap(109, 109, 109)
                        .addComponent(PuestoTxT, 0, 172, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsuarioIDTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(NombreUsuarioTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ContraseniaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Puesto)
                    .addComponent(PuestoTxT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Modificar");

        DecoEmpleadoIDModificar.setText("Usuario ID a Modificar:");

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

        jLabel13.setText("Nombre Usuario");

        jLabel14.setText("Contraseña");

        DecoEmpleadoID.setText("UsuarioID:");

        IDModificacion.setEditable(false);
        IDModificacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        IDModificacion.setText("0");

        UsuarioIDModificar.setModel(new javax.swing.DefaultComboBoxModel<>(UsuarioID));

        jLabel18.setText("Puesto");

        PuestoModificarTxT.setModel(new javax.swing.DefaultComboBoxModel<>(PuestoNombresModificar));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DecoEmpleadoIDModificar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(DecoEmpleadoID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarButton)
                            .addComponent(UsuarioIDModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ContraseniaModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(NombreUsuarioModificar, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(25, 25, 25)
                        .addComponent(PuestoModificarTxT, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DecoEmpleadoIDModificar)
                    .addComponent(UsuarioIDModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarButton)
                    .addComponent(DecoEmpleadoID)
                    .addComponent(IDModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreUsuarioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContraseniaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(PuestoModificarTxT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        EmpleadoIDEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleadoIDEliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Eliminar");

        jLabel12.setText("Escoja en base a que eliminara");

        buttonGroup1.add(EmpleadoIDRadioEliminar);
        EmpleadoIDRadioEliminar.setText("Empleado ID");
        EmpleadoIDRadioEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmpleadoIDRadioEliminarMouseClicked(evt);
            }
        });
        EmpleadoIDRadioEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleadoIDRadioEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(EmpleadoIDEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmpleadoIDRadioEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel12)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(EmpleadoIDRadioEliminar)
                    .addComponent(EmpleadoIDEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(528, 528, 528)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(530, 530, 530)
                        .addComponent(OpcionesDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(509, 509, 509)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(415, 415, 415)
                .addComponent(regresarButton)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OpcionesDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(regresarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        switch(elegir){
            case 1: AgregarUsuarios();
                    NombreUsuarioTexto.setText(null);
                    break;
            case 2: ModificarUsuarios();
                    NombreUsuarioModificar.setText(null);
                    ContraseniaModificar.setText(null);
                    break;
            case 3: EliminarUsuarios();
                    EmpleadoIDEliminar.setText(null);
                    break;
        }
        String [] NuevosUsuariosID = ObtenerIDS(18);
        UsuarioIDModificar.setModel(new javax.swing.DefaultComboBoxModel<>(NuevosUsuariosID));
        
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

    private void EmpleadoIDEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleadoIDEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpleadoIDEliminarActionPerformed

    private void EmpleadoIDRadioEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleadoIDRadioEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpleadoIDRadioEliminarActionPerformed

    private void EmpleadoIDRadioEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadoIDRadioEliminarMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_EmpleadoIDRadioEliminarMouseClicked

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            NombreUsuarioModificar.setEnabled(false);
            ContraseniaModificar.setEnabled(false);
            
            bd = new Conexion();
            String idBuscado = UsuarioIDModificar.getSelectedItem().toString();
            ResultSet rs = bd.ObtenerDatos(18, idBuscado);
            
           
            
            rs.next();
            IDModificacion.setText(rs.getString(1));
            NombreUsuarioModificar.setText(rs.getString(2));
            ContraseniaModificar.setText(rs.getString(3));
            //Municipio obtener nombre
            String aux2 = ObtenerPuestoID(rs.getInt(4));
            PuestoModificarTxT.setSelectedItem(aux2);
            
           
            
            NombreUsuarioModificar.setEnabled(true);
            ContraseniaModificar.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(AlterarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void buscarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarButtonMouseClicked
     
    }//GEN-LAST:event_buscarButtonMouseClicked

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regresarButtonActionPerformed

    private void regresarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarButtonMouseClicked
        // TODO add your handling code here:
        AlterarMenu Menu = new AlterarMenu();
        Menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarButtonMouseClicked

    private void UsuarioIDTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioIDTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioIDTextoActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ContraseniaModificar;
    private javax.swing.JPasswordField ContraseniaTexto;
    private javax.swing.JLabel DecoEmpleadoID;
    private javax.swing.JLabel DecoEmpleadoIDModificar;
    private javax.swing.JTextField EmpleadoIDEliminar;
    private javax.swing.JRadioButton EmpleadoIDRadioEliminar;
    private javax.swing.JTextField IDModificacion;
    private javax.swing.JTextField NombreUsuarioModificar;
    private javax.swing.JTextField NombreUsuarioTexto;
    private javax.swing.JComboBox<String> OpcionesDatos;
    private javax.swing.JLabel Puesto;
    private javax.swing.JComboBox<String> PuestoModificarTxT;
    private javax.swing.JComboBox<String> PuestoTxT;
    private javax.swing.JComboBox<String> UsuarioIDModificar;
    private javax.swing.JTextField UsuarioIDTexto;
    private javax.swing.JButton buscarButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton regresarButton;
    // End of variables declaration//GEN-END:variables

    


 



   
}
