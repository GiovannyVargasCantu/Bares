/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Alterar;

import SQL.Conexion;
import static SQL.Conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class AlterarMesa extends javax.swing.JFrame {

    /**
     * Creates new form AlterarMesa
     */
    public AlterarMesa() {
        initComponents();
        opcion.removeAllItems();
        opcion.addItem("Agregar");
        opcion.addItem("Modificar");
        opcion.addItem("Eliminar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void desahabilitarAgreagar(){
        sillasAgregar.setEnabled(false);
        anchoAgre.setEnabled(false);
        anchoAgre.setEditable(false);
        LargoAgre.setEditable(false);
        LargoAgre.setEnabled(false);
    }
    
    private void habilitarAgreagar(){
        sillasAgregar.setEnabled(true);
        anchoAgre.setEnabled(true);
        anchoAgre.setEditable(true);
        LargoAgre.setEditable(true);
        LargoAgre.setEnabled(true);
    }
    
    private void desahabilitarModificar(){
        MesaIDmodificar.setEnabled(false);
        MesaIDmodificar.setEditable(false);
        anchoModificar.setEnabled(false);
        anchoModificar.setEditable(false);
        largoModificar.setEditable(false);
        largoModificar.setEnabled(false);
        sillasModificar.setEnabled(false);
    }
    
    private void habilitarModificar(){
        MesaIDmodificar.setEnabled(true);
        MesaIDmodificar.setEditable(true);
        anchoModificar.setEnabled(true);
        anchoModificar.setEditable(true);
        largoModificar.setEditable(true);
        largoModificar.setEnabled(true);
        sillasModificar.setEnabled(true);
    }
    
    private void deshabilitarEliminar(){
        eliminarMesaID.setEnabled(false);
        eliminarMesaID.setEditable(false);
    }
    private void habilitarEliminar(){
        eliminarMesaID.setEnabled(true);
        eliminarMesaID.setEditable(true);
    }
    private void agregarMesa(){
        Conexion bd = new Conexion();
        ResultSet rs;
        Statement s;
        int sillas = (int) sillasAgregar.getValue();
        String ancho = anchoAgre.getText();
        String altura = LargoAgre.getText();
        try {
            s = conexion.createStatement();
            String query = "INSERT INTO Mesas\n" +
                            "VALUES ("+sillas+","+ancho+","+altura+")";
            int a = s.executeUpdate(query);
            actualizarMesa();
            JOptionPane.showMessageDialog(null, "Mesa generada con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al generar mesa");
            System.out.println(ex);
        }
    }
    private void modificarMesa(){
        Conexion bd = new Conexion();
        ResultSet rs;
        Statement s;
        int sillas = (int) sillasModificar.getValue();
        System.out.println(sillas);
        String ancho = anchoModificar.getText();
        System.out.println(ancho);
        String altura = largoModificar.getText();
        System.out.println(altura);
        try {
            s = conexion.createStatement();
            String query = "UPDATE Mesas\n" +
                "set NumeroSillas = "+sillas+", Ancho = "+ancho+", Largo = "+altura+"\n" +
                "where MesaID = "+MesaIDmodificar.getSelectedItem();
            int a = s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Mesa modificada con exito");
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al generar mesa");
        }
    }
    private void actualizarMesa(){
        Conexion bd = new Conexion();
        ResultSet rs;
        Statement s;
        try {
            s = conexion.createStatement();
            String query = "select * from Mesas where MesaID =  "+MesaIDmodificar.getSelectedItem();
            rs = s.executeQuery(query);
            while(rs.next()){
                sillasModificar.setValue(rs.getInt("NumeroSillas"));
                anchoModificar.setText(rs.getString("Ancho"));
                largoModificar.setText(rs.getString("Largo"));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    private void actualizarMesaID(){
        Conexion bd = new Conexion();
        ResultSet rs;
        Statement s;
        MesaIDmodificar.removeAllItems();
        try {
            s = conexion.createStatement();
            String query = "select * from Mesas";
            rs = s.executeQuery(query);
            while(rs.next()){
                MesaIDmodificar.addItem(rs.getString("MesaID"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    private void actualizarMesaEliminar(){
        eliminarMesaID.removeAllItems();
        Conexion bd = new Conexion();
        ResultSet rs;
        Statement s;
        try {
            s = conexion.createStatement();
            String query = "select * from Mesas where not exists (Select * from Comanda where Comanda.MesaID = Mesas.MesaID)";
            rs = s.executeQuery(query);
            while(rs.next()){
                eliminarMesaID.addItem(rs.getString("MesaID"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    private void eliminarMesa(){
        actualizarMesa();
        Conexion bd = new Conexion();
        ResultSet rs;
        Statement s;
        try {
            s = conexion.createStatement();
            String query = "DELETE FROM Mesas WHERE MesaID = "+eliminarMesaID.getSelectedItem();
            int a = s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Mesa eliminada con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al generar mesa");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        anchoAgre = new javax.swing.JTextField();
        LargoAgre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sillasAgregar = new javax.swing.JSpinner();
        comandaIDEliminar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        eliminarMesaID = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        MesaIDmodificar = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        anchoModificar = new javax.swing.JTextField();
        largoModificar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        sillasModificar = new javax.swing.JSpinner();
        Regresar = new javax.swing.JButton();
        opcion = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        RealizarAccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Agregar");

        jLabel1.setText("Ancho");

        jLabel2.setText("Largo");

        anchoAgre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anchoAgreActionPerformed(evt);
            }
        });
        anchoAgre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anchoAgreKeyTyped(evt);
            }
        });

        LargoAgre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LargoAgreKeyTyped(evt);
            }
        });

        jLabel3.setText("Numero Sillas");

        sillasAgregar.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(anchoAgre, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LargoAgre, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(sillasAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sillasAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(anchoAgre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LargoAgre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comandaIDEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Eliminar");

        eliminarMesaID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        eliminarMesaID.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel15.setText("Mesa ID");

        javax.swing.GroupLayout comandaIDEliminarLayout = new javax.swing.GroupLayout(comandaIDEliminar);
        comandaIDEliminar.setLayout(comandaIDEliminarLayout);
        comandaIDEliminarLayout.setHorizontalGroup(
            comandaIDEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comandaIDEliminarLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(eliminarMesaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(comandaIDEliminarLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        comandaIDEliminarLayout.setVerticalGroup(
            comandaIDEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comandaIDEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(42, 42, 42)
                .addGroup(comandaIDEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarMesaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Modificar");

        MesaIDmodificar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        MesaIDmodificar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MesaIDmodificarItemStateChanged(evt);
            }
        });
        MesaIDmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MesaIDmodificarActionPerformed(evt);
            }
        });

        jLabel8.setText("MesaID");

        jLabel9.setText("Ancho");

        jLabel10.setText("Largo");

        anchoModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anchoModificarKeyTyped(evt);
            }
        });

        largoModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                largoModificarKeyTyped(evt);
            }
        });

        jLabel11.setText("Numero Sillas");

        sillasModificar.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MesaIDmodificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(anchoModificar)
                    .addComponent(sillasModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(largoModificar))
                .addGap(0, 72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(108, 108, 108))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MesaIDmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(anchoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(largoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sillasModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        Regresar.setText("Regresar");
        Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegresarMouseClicked(evt);
            }
        });
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(comandaIDEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regresar)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comandaIDEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(Regresar)
                .addContainerGap())
        );

        opcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opcion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                opcionItemStateChanged(evt);
            }
        });

        jLabel13.setText("Mesas");

        jLabel14.setText("ElegirOpcion");

        RealizarAccion.setText("Realizar");
        RealizarAccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RealizarAccionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RealizarAccionMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(493, 493, 493)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(opcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(507, 507, 507)
                                .addComponent(jLabel13)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(487, 487, 487)
                .addComponent(RealizarAccion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(12, 12, 12)
                .addComponent(opcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RealizarAccion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anchoAgreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anchoAgreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anchoAgreActionPerformed

    private void anchoAgreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anchoAgreKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_anchoAgreKeyTyped

    private void LargoAgreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LargoAgreKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_LargoAgreKeyTyped

    private void anchoModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anchoModificarKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_anchoModificarKeyTyped

    private void largoModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_largoModificarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_largoModificarKeyTyped

    private void opcionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_opcionItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==evt.SELECTED){
            switch(opcion.getSelectedIndex()){
                case 0:
                    habilitarAgreagar();
                    desahabilitarModificar();
                    deshabilitarEliminar();
                    
                    eliminarMesaID.removeAllItems();
                    MesaIDmodificar.removeAllItems();
                    sillasModificar.setValue(1);
                    anchoModificar.setText(null);
                    largoModificar.setText(null);
                    break;
                    
                case 1:
                    actualizarMesaID();
                    habilitarModificar();
                    desahabilitarAgreagar();
                    deshabilitarEliminar();
                    eliminarMesaID.removeAllItems();
                    sillasAgregar.setValue(1);
                    anchoAgre.setText(null);
                    LargoAgre.setText(null);
                    break;
                    
                case 2:
                    actualizarMesaEliminar();
                    habilitarEliminar();
                    desahabilitarAgreagar();
                    desahabilitarModificar();
                    sillasAgregar.setValue(1);
                    anchoAgre.setText(null);
                    LargoAgre.setText(null);
                    MesaIDmodificar.removeAllItems();
                    sillasModificar.setValue(1);
                    anchoModificar.setText(null);
                    largoModificar.setText(null);
                    break;
            }
        }
    }//GEN-LAST:event_opcionItemStateChanged

    private void RealizarAccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RealizarAccionMouseClicked
        // TODO add your handling code here:
        switch(opcion.getSelectedIndex()){
                case 0:
                    agregarMesa();
                    sillasAgregar.setValue(1);
                    anchoAgre.setText(null);
                    LargoAgre.setText(null);
                    break;
                    
                case 1:
                    modificarMesa();
                    MesaIDmodificar.removeAllItems();
                    actualizarMesaID();
                    sillasModificar.setValue(1);
                    anchoModificar.setText(null);
                    largoModificar.setText(null);
                    break;
                    
                case 2:
                    eliminarMesa();
                    actualizarMesaEliminar();
                    break;
            }
    }//GEN-LAST:event_RealizarAccionMouseClicked

    private void MesaIDmodificarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MesaIDmodificarItemStateChanged
        // TODO add your handling code here:
        actualizarMesa();
    }//GEN-LAST:event_MesaIDmodificarItemStateChanged

    private void MesaIDmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MesaIDmodificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MesaIDmodificarActionPerformed

    private void RealizarAccionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RealizarAccionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RealizarAccionMouseEntered

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegresarActionPerformed

    private void RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegresarMouseClicked
        // TODO add your handling code here:
        AlterarMenu alt = new AlterarMenu();
        alt.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegresarMouseClicked

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
            java.util.logging.Logger.getLogger(AlterarMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarMesa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LargoAgre;
    private javax.swing.JComboBox<String> MesaIDmodificar;
    private javax.swing.JButton RealizarAccion;
    private javax.swing.JButton Regresar;
    private javax.swing.JTextField anchoAgre;
    private javax.swing.JTextField anchoModificar;
    private javax.swing.JPanel comandaIDEliminar;
    private javax.swing.JComboBox<String> eliminarMesaID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField largoModificar;
    private javax.swing.JComboBox<String> opcion;
    private javax.swing.JSpinner sillasAgregar;
    private javax.swing.JSpinner sillasModificar;
    // End of variables declaration//GEN-END:variables
}
