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
public class AlterarEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form AlterarMenu
     */
    public AlterarEmpleados() {
        initComponents();
        InicializarOpciones();
    }

    private void InicializarOpciones(){
        //Agregar
        EmpleadoIDTexto.setEnabled(false);
        NombreEmpleadoTexto.setEnabled(false);
        ApellidosEmpleadoTexto.setEnabled(false);
        CorreoTexto.setEnabled(false);
        LugarNacimientoTexto.setEnabled(false);
        //Modificar
        //IndiceClienteIDModificar.setEnabled(false);
        EmpleadoIDModificar.setEnabled(false);
        buscarButton.setEnabled(false);
        NombreEmpleadoModificar.setEnabled(false);
        ApellidoEmpleadoModificar.setEnabled(false);
        CorreoModificar.setEnabled(false);
        LugarNacimientoModificar.setEnabled(false);
        //Eliminar
        EmpleadoIDEliminar.setEnabled(false);
        CorreoEliminar.setEnabled(false);
        EmpleadoIDRadioEliminar.setEnabled(false);
        CorreoRadioEliminar.setEnabled(false);
    }
    private void InicializarAgregar(){
        
        NombreEmpleadoTexto.setEnabled(true);
        ApellidosEmpleadoTexto.setEnabled(true);
        CorreoTexto.setEnabled(true);
        LugarNacimientoTexto.setEnabled(true);
        DireccionTexto.setEnabled(true);
        HorarioTexto.setEnabled(true);
        MunicipiosNombres.setEnabled(true);
        GerenteTexto.setEnabled(true);
        PuestoTxT.setEnabled(true);
        
        String ID = null;
        int IntIDNuevo = 0;
        String IDNuevo = null;
        try {
            // TODO add your handling code here:
            EmpleadoIDTexto.setEnabled(false);
            
            bd = new Conexion();
            ResultSet rs = bd.ObtenerID(3);
            
            rs.next();
            ID= rs.getString(1);
            IntIDNuevo =  Integer.parseInt(ID);
            IDNuevo = String.valueOf(IntIDNuevo + 1);
            EmpleadoIDTexto.setText(IDNuevo);
            
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AlterarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void InicializarModificar(){
        EmpleadoIDModificar.setEnabled(true);
        buscarButton.setEnabled(true);
        
    }
    private void InicializarEliminar(){
       EmpleadoIDEliminar.setEnabled(true);
       CorreoEliminar.setEnabled(true);
       EmpleadoIDRadioEliminar.setEnabled(true);
       CorreoRadioEliminar.setEnabled(true);
    }
    private void OcultarAgregar(){
        EmpleadoIDTexto.setEnabled(false);
        NombreEmpleadoTexto.setEnabled(false);
        ApellidosEmpleadoTexto.setEnabled(false);
        CorreoTexto.setEnabled(false);
        LugarNacimientoTexto.setEnabled(false);
        DireccionTexto.setEnabled(false);
        HorarioTexto.setEnabled(false);
        MunicipiosNombres.setEnabled(false);
        GerenteTexto.setEnabled(false);
        PuestoTxT.setEnabled(false);
    }
    private void OcultarModificar() {
        EmpleadoIDModificar.setEnabled(false);
        NombreEmpleadoModificar.setEnabled(false);
        ApellidoEmpleadoModificar.setEnabled(false);
        CorreoModificar.setEnabled(false);
        LugarNacimientoModificar.setEnabled(false);
        DireccionModificar.setEnabled(false);
        HorarioTextoModificar.setEnabled(false);
        MunicipioModificar.setEnabled(false);
        GerenteModificar.setEnabled(false);
        PuestoModificarTxT.setEnabled(false);
        buscarButton.setEnabled(false);
    }
     private void OcultarEliminar() {
       EmpleadoIDEliminar.setEnabled(false);
       CorreoEliminar.setEnabled(false);
       EmpleadoIDRadioEliminar.setEnabled(false);
       CorreoRadioEliminar.setEnabled(false);
    }

    private Conexion bd;
    String OpcionElegida;
    int elegir;
    int bandera;
    String[] EmpleadosID = ObtenerIDS(3);
    String Campo1 ;//Empleado
    String Campo2; //Nom
    String Campo3;//Ape
    String Campo4;//Corr
    String Campo5;//Lug
    String Campo6;//Direccion
    String Campo7;//Horario
    int Campo8;//Municipio
    String Campo9;//Gerente
    int Campo10;//PuestoID
    String Query = null;
    String[] MunicipiosID  = ObtenerIDS(10);
    String[] MunicipioIDModificar = ObtenerIDS(10);
    String[] HorariosNombres = ObtenerIDS(4);
    String[] HorariosModificar = ObtenerIDS(4);
    String[] PuestoNombres= ObtenerIDS(5);
    String[] PuestoNombresModificar = ObtenerIDS(5);
    
    
    
    //Este Metodo funciona a la perfeccion
     private void AgregarEmpleado() {
       //Campo1 = EmpleadoIDTexto.getText();
       Campo2 = NombreEmpleadoTexto.getText();
       Campo3= ApellidosEmpleadoTexto.getText();
       Campo4 = CorreoTexto.getText();
       Campo5 = LugarNacimientoTexto.getText();
       Campo6 = DireccionTexto.getText();
       Campo7 = HorarioTexto.getSelectedItem().toString();
       String aux = MunicipiosNombres.getSelectedItem().toString();
       Campo8 = ObtenerMunicipioNombre(aux);
       Campo9 = GerenteTexto.getText();
       String aux2 = PuestoTxT.getSelectedItem().toString();
       Campo10 = ObtenerPuestoNombre(aux2);
       
       //INSERT INTO BALBLABA VALUES ()
       if("".equals(GerenteTexto.getText())){
           System.out.println("Pruebaa");
           Query = "('"+Campo2+"','"+Campo3+"','"+Campo4+"','"+Campo5+"','"+Campo6+"','"+Campo7+"',"+Campo8+", NULL ,"+Campo10+");";
           
       }
       else{
           Query = "('"+Campo2+"','"+Campo3+"','"+Campo4+"','"+Campo5+"','"+Campo6+"','"+Campo7+"',"+Campo8+","+Campo9+" ,"+Campo10+");";
       }
       bd = new Conexion();        
       bd.AgregarDatos(Query, 3);
       
       JOptionPane.showMessageDialog(null, "Cliente agregado con éxito.");
     }

     private void ModificarEmpleado(){
         
         Campo1 = IDModificacion.getText();
         Campo2 = NombreEmpleadoModificar.getText();
         Campo3 = ApellidoEmpleadoModificar.getText();
         Campo4 = CorreoModificar.getText();
         Campo5 = LugarNacimientoModificar.getText();
         Campo6 = DireccionModificar.getText();
         Campo7 = HorarioTextoModificar.getSelectedItem().toString();
         String aux = MunicipioModificar.getSelectedItem().toString();
         Campo8 = ObtenerMunicipioNombre(aux);
         Campo9 = GerenteModificar.getText();
         System.out.println(Campo9);
         String aux2 = PuestoModificarTxT.getSelectedItem().toString();
         Campo10 = ObtenerPuestoNombre(aux2);
         if("".equals(GerenteModificar.getText())){
         Query = "SET Nombre= '" + Campo2 + "', Apellidos= '" + Campo3
                 + "', Correo = '" + Campo4 + "', LugarNacimiento = '" + Campo5
                 + "', Direccion = '"+Campo6+"', HorarioID = '"+Campo7+"'"
                 + ", MunicipioID = "+Campo8+", GerenteID = NULL , PuestoID = "+Campo10+" WHERE EmpleadoID = " + Campo1 + ";";
           }
         else{
             Query = "SET Nombre= '" + Campo2 + "', Apellidos= '" + Campo3
                 + "', Correo = '" + Campo4 + "', LugarNacimiento = '" + Campo5
                 + "', Direccion = '"+Campo6+"', HorarioID = '"+Campo7+"'"
                 + ", MunicipioID = "+Campo8+", GerenteID ="+Campo9+", PuestoID = "+Campo10+" WHERE EmpleadoID = " + Campo1 + ";";
         }
         bd = new Conexion();
         bd.ModificarDatos(Query, 3);
         
         JOptionPane.showMessageDialog(null, "Cliente modificado con éxito.");

     }
     //Este Metodo funciona a la perfeccion
       private void EliminarEmpleado() {
           
       if(EmpleadoIDRadioEliminar.isSelected()) Campo1 = EmpleadoIDEliminar.getText();    
       if(CorreoRadioEliminar.isSelected()) Campo4 = CorreoEliminar.getText();
       
           
       

            if (EmpleadoIDRadioEliminar.isSelected()) {
                Query = "DELETE FROM Empleado WHERE EmpleadoID="+Campo1+";";
            }
            if(CorreoRadioEliminar.isSelected()){
                Query = "DELETE FROM Empleado WHERE C='"+Campo4+"';";
            }
            
            bd = new Conexion();
            bd.EliminarDatos(Query);
            
            JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito.");
    }
       private String[] ObtenerIDS(int tabla) {
        bd = new Conexion();
        return bd.ObtenerIDs(tabla);
    }
          private int ObtenerMunicipioNombre(String Nombre) {
              bd = new Conexion();
              return bd.MunicipioID(Nombre);
       
    }
          private String ObtenerMunicipioID(int ID){
              bd = new Conexion();
              return bd.MunicipioNombre(ID);
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
        EmpleadoIDTexto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        NombreEmpleadoTexto = new javax.swing.JTextField();
        ApellidosEmpleadoTexto = new javax.swing.JTextField();
        CorreoTexto = new javax.swing.JTextField();
        LugarNacimientoTexto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LugarNacTexto = new javax.swing.JLabel();
        Municipio = new javax.swing.JLabel();
        Gerente = new javax.swing.JLabel();
        Puesto = new javax.swing.JLabel();
        MunicipiosNombres = new javax.swing.JComboBox<>();
        GerenteTexto = new javax.swing.JTextField();
        Direccion = new javax.swing.JLabel();
        DireccionTexto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        HorarioTexto = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        PuestoTxT = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        DecoEmpleadoIDModificar = new javax.swing.JLabel();
        NombreEmpleadoModificar = new javax.swing.JTextField();
        ApellidoEmpleadoModificar = new javax.swing.JTextField();
        CorreoModificar = new javax.swing.JTextField();
        LugarNacimientoModificar = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        DecoEmpleadoID = new javax.swing.JLabel();
        IDModificacion = new javax.swing.JTextField();
        EmpleadoIDModificar = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        DireccionModificar = new javax.swing.JTextField();
        GerenteModificar = new javax.swing.JTextField();
        MunicipioModificar = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        HorarioTextoModificar = new javax.swing.JComboBox<>();
        jCheckBox2 = new javax.swing.JCheckBox();
        PuestoModificarTxT = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        EmpleadoIDEliminar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        EmpleadoIDRadioEliminar = new javax.swing.JRadioButton();
        CorreoEliminar = new javax.swing.JTextField();
        CorreoRadioEliminar = new javax.swing.JRadioButton();

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

        jLabel2.setText("Empleados");

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

        EmpleadoIDTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleadoIDTextoActionPerformed(evt);
            }
        });

        jLabel5.setText("Agregar");

        ApellidosEmpleadoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidosEmpleadoTextoActionPerformed(evt);
            }
        });

        jLabel6.setText("Empleado ID");

        jLabel7.setText("Nombre");

        jLabel8.setText("Apellidos");

        jLabel9.setText("Correo");

        LugarNacTexto.setText("Lugar Nacimiento");

        Municipio.setText("Municipio");

        Gerente.setText("Gerente");

        Puesto.setText("Puesto");

        MunicipiosNombres.setModel(new javax.swing.DefaultComboBoxModel<>(MunicipiosID));
        MunicipiosNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MunicipiosNombresActionPerformed(evt);
            }
        });

        Direccion.setText("Direccion");

        DireccionTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DireccionTextoActionPerformed(evt);
            }
        });

        jLabel19.setText("Horario");

        HorarioTexto.setModel(new javax.swing.DefaultComboBoxModel<>(HorariosNombres));

        jCheckBox1.setText("No");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(LugarNacTexto)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EmpleadoIDTexto)
                                    .addComponent(NombreEmpleadoTexto)
                                    .addComponent(ApellidosEmpleadoTexto)
                                    .addComponent(CorreoTexto)
                                    .addComponent(LugarNacimientoTexto)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Direccion)
                                    .addComponent(jLabel19))
                                .addGap(97, 97, 97)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DireccionTexto)
                                    .addComponent(HorarioTexto, 0, 165, Short.MAX_VALUE))))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Municipio)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Gerente)
                                    .addComponent(Puesto))
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GerenteTexto)
                            .addComponent(MunicipiosNombres, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PuestoTxT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmpleadoIDTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreEmpleadoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApellidosEmpleadoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CorreoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LugarNacimientoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LugarNacTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Direccion)
                    .addComponent(DireccionTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(HorarioTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Municipio)
                    .addComponent(MunicipiosNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Gerente)
                    .addComponent(GerenteTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Puesto)
                    .addComponent(PuestoTxT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Modificar");

        DecoEmpleadoIDModificar.setText("Empleado ID a Modificar");

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

        jLabel15.setText("Correo");

        jLabel16.setText("Lugar Nacimiento");

        DecoEmpleadoID.setText("EmpleadoID:");

        IDModificacion.setEditable(false);
        IDModificacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        IDModificacion.setText("0");

        EmpleadoIDModificar.setModel(new javax.swing.DefaultComboBoxModel<>(EmpleadosID));

        jLabel10.setText("Direccion");

        jLabel11.setText("Municipio");

        jLabel17.setText("Gerente");

        jLabel18.setText("Puesto");

        MunicipioModificar.setModel(new javax.swing.DefaultComboBoxModel<>(MunicipioIDModificar));

        jLabel21.setText("Horario");

        HorarioTextoModificar.setModel(new javax.swing.DefaultComboBoxModel<>(HorariosModificar));

        jCheckBox2.setText("No");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        PuestoModificarTxT.setModel(new javax.swing.DefaultComboBoxModel<>(PuestoNombresModificar));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                            .addComponent(EmpleadoIDModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CorreoModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(ApellidoEmpleadoModificar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombreEmpleadoModificar, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel10))
                                .addComponent(jLabel11)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addGap(19, 19, 19)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PuestoModificarTxT, 0, 118, Short.MAX_VALUE)
                            .addComponent(LugarNacimientoModificar)
                            .addComponent(GerenteModificar)
                            .addComponent(MunicipioModificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DireccionModificar)
                            .addComponent(HorarioTextoModificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(EmpleadoIDModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarButton)
                    .addComponent(DecoEmpleadoID)
                    .addComponent(IDModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreEmpleadoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApellidoEmpleadoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CorreoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LugarNacimientoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(DireccionModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(HorarioTextoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(MunicipioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jCheckBox2)
                    .addComponent(GerenteModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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

        buttonGroup1.add(CorreoRadioEliminar);
        CorreoRadioEliminar.setText("Correo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CorreoEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(EmpleadoIDEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CorreoRadioEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EmpleadoIDRadioEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel12)))
                        .addGap(0, 29, Short.MAX_VALUE)))
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
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CorreoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CorreoRadioEliminar))
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(121, 121, 121)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(regresarButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        switch(elegir){
            case 1: AgregarEmpleado();
                    NombreEmpleadoTexto.setText(null);
                    ApellidosEmpleadoTexto.setText(null);
                    CorreoTexto.setText(null);
                    LugarNacimientoTexto.setText(null);
                    DireccionTexto.setText(null);
                    GerenteTexto.setText(null);
                    break;
            case 2: ModificarEmpleado();
                    NombreEmpleadoModificar.setText(null);
                    ApellidoEmpleadoModificar.setText(null);
                    CorreoModificar.setText(null);
                    LugarNacimientoModificar.setText(null);
                    DireccionModificar.setText(null);
                    GerenteModificar.setText(null);
                    break;
            case 3: EliminarEmpleado();
                    EmpleadoIDEliminar.setText(null);
                    CorreoEliminar.setText(null);
                    break;
        }
        String [] NuevosClientesID = ObtenerIDS(3);
        EmpleadoIDModificar.setModel(new javax.swing.DefaultComboBoxModel<>(NuevosClientesID));
        
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

    private void EmpleadoIDTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleadoIDTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpleadoIDTextoActionPerformed

    private void ApellidosEmpleadoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidosEmpleadoTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidosEmpleadoTextoActionPerformed

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
            NombreEmpleadoModificar.setEnabled(false);
            ApellidoEmpleadoModificar.setEnabled(false);
            CorreoModificar.setEnabled(false);
            LugarNacimientoModificar.setEnabled(false);
            DireccionModificar.setEnabled(false);
            HorarioTextoModificar.setEnabled(false);
            MunicipioModificar.setEnabled(false);
            GerenteModificar.setEnabled(false);
            PuestoModificarTxT.setEnabled(false);
            
            bd = new Conexion();
            String idBuscado = EmpleadoIDModificar.getSelectedItem().toString();
            ResultSet rs = bd.ObtenerDatos(3, idBuscado);
            
           
            
            rs.next();
            IDModificacion.setText(rs.getString(1));
            NombreEmpleadoModificar.setText(rs.getString(2));
            ApellidoEmpleadoModificar.setText(rs.getString(3));
            CorreoModificar.setText(rs.getString(4));
            LugarNacimientoModificar.setText(rs.getString(5));
            DireccionModificar.setText(rs.getString(6));
            HorarioTextoModificar.setSelectedItem(rs.getString(7));
            //Municipio obtener nombre
            String aux = ObtenerMunicipioID(rs.getInt(8));
            MunicipioModificar.setSelectedItem(aux);
            GerenteModificar.setText(rs.getString(9));
            String aux2 = ObtenerPuestoID(rs.getInt(10));
            PuestoModificarTxT.setSelectedItem(aux2);
            
           
            
            NombreEmpleadoModificar.setEnabled(true);
            ApellidoEmpleadoModificar.setEnabled(true);
            CorreoModificar.setEnabled(true);
            LugarNacimientoModificar.setEnabled(true);
            DireccionModificar.setEnabled(true);
            HorarioTextoModificar.setEnabled(true);
            MunicipioModificar.setEnabled(true);
            GerenteModificar.setEnabled(true);
            PuestoModificarTxT.setEnabled(true);
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AlterarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
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

    private void DireccionTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DireccionTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DireccionTextoActionPerformed

    private void MunicipiosNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MunicipiosNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MunicipiosNombresActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected()){
        GerenteTexto.setText(null);
        GerenteTexto.setEnabled(false);
        }
        else{
            GerenteTexto.setEnabled(true);
        }
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox2.isSelected()){
        GerenteModificar.setEnabled(false);
        GerenteModificar.setText(null);
        }
        else{
            GerenteModificar.setEnabled(true);
            }
        
    }//GEN-LAST:event_jCheckBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new AlterarEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ApellidoEmpleadoModificar;
    private javax.swing.JTextField ApellidosEmpleadoTexto;
    private javax.swing.JTextField CorreoEliminar;
    private javax.swing.JTextField CorreoModificar;
    private javax.swing.JRadioButton CorreoRadioEliminar;
    private javax.swing.JTextField CorreoTexto;
    private javax.swing.JLabel DecoEmpleadoID;
    private javax.swing.JLabel DecoEmpleadoIDModificar;
    private javax.swing.JLabel Direccion;
    private javax.swing.JTextField DireccionModificar;
    private javax.swing.JTextField DireccionTexto;
    private javax.swing.JTextField EmpleadoIDEliminar;
    private javax.swing.JComboBox<String> EmpleadoIDModificar;
    private javax.swing.JRadioButton EmpleadoIDRadioEliminar;
    private javax.swing.JTextField EmpleadoIDTexto;
    private javax.swing.JLabel Gerente;
    private javax.swing.JTextField GerenteModificar;
    private javax.swing.JTextField GerenteTexto;
    private javax.swing.JComboBox<String> HorarioTexto;
    private javax.swing.JComboBox<String> HorarioTextoModificar;
    private javax.swing.JTextField IDModificacion;
    private javax.swing.JLabel LugarNacTexto;
    private javax.swing.JTextField LugarNacimientoModificar;
    private javax.swing.JTextField LugarNacimientoTexto;
    private javax.swing.JLabel Municipio;
    private javax.swing.JComboBox<String> MunicipioModificar;
    private javax.swing.JComboBox<String> MunicipiosNombres;
    private javax.swing.JTextField NombreEmpleadoModificar;
    private javax.swing.JTextField NombreEmpleadoTexto;
    private javax.swing.JComboBox<String> OpcionesDatos;
    private javax.swing.JLabel Puesto;
    private javax.swing.JComboBox<String> PuestoModificarTxT;
    private javax.swing.JComboBox<String> PuestoTxT;
    private javax.swing.JButton buscarButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton regresarButton;
    // End of variables declaration//GEN-END:variables

    


 



   
}
