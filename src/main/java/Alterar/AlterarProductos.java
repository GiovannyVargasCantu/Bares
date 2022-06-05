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
 * @author GUILLERMO
 */
public class AlterarProductos extends javax.swing.JFrame {

    /**
     * Creates new form AlterarProductos
     */
    public AlterarProductos() {
        initComponents();
        InicializarOpciones();
    }
    
    public void InicializarOpciones(){
        //Agregar
        ProductoIDTexto.setEnabled(false);
        NombreProductoTexto.setEnabled(false);
        CantidadProductoTexto.setEnabled(false);
        PrecioProductoTexto.setEnabled(false);
        TipoProductoIDTexto.setEnabled(false);
        //Modificar
        buscarButton.setEnabled(false);
        ProductoIDModificar.setEnabled(false);
        NombreProductoModificar.setEnabled(false);
        CantidadProductoModificar.setEnabled(false);
        PrecioProductoModificar.setEnabled(false);
        TipoProductoIDModificar.setEnabled(false);
        //Eliminar
        ProductoIDEliminar.setEnabled(false);
    }
    
    private void InicializarAgregar(){
        NombreProductoTexto.setEnabled(true);
        CantidadProductoTexto.setEnabled(true);
        PrecioProductoTexto.setEnabled(true);
        TipoProductoIDTexto.setEnabled(true);
        ProductoID = null;
        int ProductoIntIDNuevo = 0;
        String ProductoIDNuevo = null;
        try {
            ProductoIDTexto.setEnabled(false);
            bd = new Conexion();
            ResultSet rs = bd.ObtenerID(11);
            
            rs.next();
            ProductoID = rs.getString(1);
            ProductoIntIDNuevo = Integer.parseInt(ProductoID);
            ProductoIDNuevo = String.valueOf(ProductoIntIDNuevo + 1);
            ProductoIDTexto.setText(ProductoIDNuevo);
        } catch (SQLException ex) {
            Logger.getLogger(AlterarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void InicializarModificar() {
        buscarButton.setEnabled(true);
        ProductoIDModificar.setEnabled(true);
    }
    
    private void InicializarEliminar(){
        ProductoIDEliminar.setEnabled(true);
    }
    
    private void OcultarAgregar() {
        ProductoIDTexto.setEnabled(false);
        NombreProductoTexto.setEnabled(false);
        CantidadProductoTexto.setEnabled(false);
        PrecioProductoTexto.setEnabled(false);
        TipoProductoIDTexto.setEnabled(false);
    }
    
    private void OcultarModificar() {
        buscarButton.setEnabled(false);
        ProductoIDModificar.setEnabled(false);
        NombreProductoModificar.setEnabled(false);
        CantidadProductoModificar.setEnabled(false);
        PrecioProductoModificar.setEnabled(false);
        TipoProductoIDModificar.setEnabled(false);
    }
    
    private void OcultarEliminar() {
        ProductoIDEliminar.setEnabled(false);
    }
    
    
    private Conexion bd;
    String OpcionElegida;
    int elegir;
    String[] ProductosID = ObtenerIDS();
    String ProductoID;
    String NombreProducto;
    String CantidadProducto;
    String PrecioProducto;
    String TipoProductoID;
    String Query;
    
    private void AgregarProducto(){
        ProductoID = ProductoIDTexto.getText();
        NombreProducto = NombreProductoTexto.getText();
        CantidadProducto = CantidadProductoTexto.getText();
        PrecioProducto = PrecioProductoTexto.getText();
        TipoProductoID = TipoProductoIDTexto.getText();
        
        Query = "('" + NombreProducto + "','" + CantidadProducto + "','"
                + PrecioProducto + "','" + TipoProductoID + "');";
        
        bd = new Conexion();
        bd.AgregarDatos(Query, 11);
        
        JOptionPane.showMessageDialog(null, "Producto agregado con éxito.");
    }
    
    private void ModificarProducto(){
        ProductoID = IDModificacion.getText();
        NombreProducto = NombreProductoModificar.getText();
        CantidadProducto = CantidadProductoModificar.getText();
        PrecioProducto = PrecioProductoModificar.getText();
        TipoProductoID = TipoProductoIDModificar.getText();
        
        Query = "SET NombreProducto ='" + NombreProducto + "', Cantidad = '" + CantidadProducto
                + "', PrecioUnidad = '" + PrecioProducto + "', TipoProductoID = '" + TipoProductoID
                + "' WHERE ProductoID = " + ProductoID;
        
        bd = new Conexion();
        bd.ModificarDatos(Query, 11);
        
        JOptionPane.showMessageDialog(null, "Producto modificado con éxito.");
    }
    
    private void EliminarProducto(){
        ProductoID = ProductoIDEliminar.getText();
        
        Query = "DELETE FROM Productos WHERE ProductoID = " + ProductoID + ";";
        
        bd = new Conexion();
        bd.EliminarDatos(Query);
        
        JOptionPane.showMessageDialog(null, "Producto eliminado con éxito.");
    }
    
    private String[] ObtenerIDS() {
        bd = new Conexion();
        return bd.ObtenerIDs(11);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        ProductoIDEliminar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        OpcionesDatos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        regresarButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ProductoIDTexto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        NombreProductoTexto = new javax.swing.JTextField();
        CantidadProductoTexto = new javax.swing.JTextField();
        PrecioProductoTexto = new javax.swing.JTextField();
        TipoProductoIDTexto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        NombreProductoModificar = new javax.swing.JTextField();
        CantidadProductoModificar = new javax.swing.JTextField();
        PrecioProductoModificar = new javax.swing.JTextField();
        TipoProductoIDModificar = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        IDModificacion = new javax.swing.JTextField();
        ProductoIDModificar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        ProductoIDEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductoIDEliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Eliminar");

        jLabel12.setText("Inserte ID a Eliminar");

        jLabel18.setText("Producto ID:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProductoIDEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addGap(15, 15, 15)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProductoIDEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Productos");

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

        ProductoIDTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductoIDTextoActionPerformed(evt);
            }
        });

        jLabel5.setText("Agregar");

        CantidadProductoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadProductoTextoActionPerformed(evt);
            }
        });

        jLabel6.setText("Producto ID");

        jLabel7.setText("Nombre");

        jLabel8.setText("Cantidad");

        jLabel9.setText("Precio Unidad");

        jLabel10.setText("Tipo Producto ID");

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
                        .addComponent(ProductoIDTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NombreProductoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CantidadProductoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(TipoProductoIDTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PrecioProductoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(ProductoIDTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreProductoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CantidadProductoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrecioProductoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoProductoIDTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Modificar");

        jLabel11.setText("ProductoID a Modificar");

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

        jLabel14.setText("Cantidad");

        jLabel15.setText("Precio Unidad");

        jLabel16.setText("Tipo Producto ID");

        jLabel17.setText("ProductoID:");

        IDModificacion.setEditable(false);
        IDModificacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        IDModificacion.setText("0");

        ProductoIDModificar.setModel(new javax.swing.DefaultComboBoxModel<>(ProductosID));

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
                        .addComponent(TipoProductoIDModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(ProductoIDModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(PrecioProductoModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(CantidadProductoModificar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombreProductoModificar, javax.swing.GroupLayout.Alignment.LEADING))))
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
                    .addComponent(ProductoIDModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarButton)
                    .addComponent(jLabel17)
                    .addComponent(IDModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreProductoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CantidadProductoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrecioProductoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoProductoIDModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(404, 404, 404)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(379, 379, 379)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(regresarButton)
                                .addGap(7, 7, 7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(OpcionesDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(474, 474, 474)))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OpcionesDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(10, 10, 10))
                    .addComponent(regresarButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        

    }//GEN-LAST:event_jButton1MouseClicked

    private void regresarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarButtonMouseClicked
        // TODO add your handling code here:
        AlterarMenu Menu = new AlterarMenu();
        Menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarButtonMouseClicked

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regresarButtonActionPerformed

    private void ProductoIDTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductoIDTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductoIDTextoActionPerformed

    private void CantidadProductoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadProductoTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadProductoTextoActionPerformed

    private void buscarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarButtonMouseClicked
        
    }//GEN-LAST:event_buscarButtonMouseClicked

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            NombreProductoModificar.setEnabled(false);
            CantidadProductoModificar.setEnabled(false);
            PrecioProductoModificar.setEnabled(false);
            TipoProductoIDModificar.setEnabled(false);

            bd = new Conexion();
            String idBuscado = ProductoIDModificar.getSelectedItem().toString();
            ResultSet rs = bd.ObtenerDatos(11, idBuscado);

            rs.next();
            IDModificacion.setText(rs.getString(1));
            NombreProductoModificar.setText(rs.getString(2));
            CantidadProductoModificar.setText(rs.getString(3));
            PrecioProductoModificar.setText(rs.getString(4));
            TipoProductoIDModificar.setText(rs.getString(5));

            NombreProductoModificar.setEnabled(true);
            CantidadProductoModificar.setEnabled(true);
            PrecioProductoModificar.setEnabled(true);
            TipoProductoIDModificar.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(AlterarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void ProductoIDEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductoIDEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductoIDEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        switch(elegir){
            case 1: AgregarProducto();
            ProductoIDTexto.setText(null);
            NombreProductoTexto.setText(null);
            CantidadProductoTexto.setText(null);
            PrecioProductoTexto.setText(null);
            TipoProductoIDTexto.setText(null);
            break;
            case 2: ModificarProducto();
            NombreProductoModificar.setText(null);
            CantidadProductoModificar.setText(null);
            PrecioProductoModificar.setText(null);
            TipoProductoIDModificar.setText(null);
            break;
            case 3: EliminarProducto();
            ProductoIDEliminar.setText(null);
            break;
        }
        
        String[] NuevosProductoID = ObtenerIDS();
        ProductoIDModificar.setModel(new javax.swing.DefaultComboBoxModel<>(NuevosProductoID));
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CantidadProductoModificar;
    private javax.swing.JTextField CantidadProductoTexto;
    private javax.swing.JTextField IDModificacion;
    private javax.swing.JTextField NombreProductoModificar;
    private javax.swing.JTextField NombreProductoTexto;
    private javax.swing.JComboBox<String> OpcionesDatos;
    private javax.swing.JTextField PrecioProductoModificar;
    private javax.swing.JTextField PrecioProductoTexto;
    private javax.swing.JTextField ProductoIDEliminar;
    private javax.swing.JComboBox<String> ProductoIDModificar;
    private javax.swing.JTextField ProductoIDTexto;
    private javax.swing.JTextField TipoProductoIDModificar;
    private javax.swing.JTextField TipoProductoIDTexto;
    private javax.swing.JButton buscarButton;
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
    private javax.swing.JLabel jLabel18;
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
