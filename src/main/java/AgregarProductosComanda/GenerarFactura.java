/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AgregarProductosComanda;

import SQL.CapaPresentacion.Ingresar;
import SQL.CapaPresentacion.Operaciones;
import SQL.Conexion;
import static SQL.Conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class GenerarFactura extends javax.swing.JFrame {
    String correo; // ya ta
    String RFC; // ya ta
    String fecha; // ahi va
    String ticketID; // ya ta
    String clienteID; // ya ta
    /**
     * Creates new form GenerarFactura
     */
    public GenerarFactura() {
        initComponents();
        Resultado.removeAllItems();
        TicketEfectuar.removeAllItems();
        RealizarFacturaButton.setEnabled(false);
        Resultado.removeAllItems();
        
        Conexion bd = new Conexion();
        ResultSet rs;
        Statement s;
        try {
            s = conexion.createStatement();
            String query = "select * from Ticket where not exists (select * from Factura where TicketID = Ticket.TicketID) AND Fecha = '"+Ingresar.devolverFecha()+"'";
            rs = s.executeQuery(query);
            while(rs.next()){
                TicketEfectuar.addItem(rs.getString("TicketID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Panelclienteold = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NombreCliente = new javax.swing.JTextField();
        Resultado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        RealizarFacturaButton = new javax.swing.JButton();
        TicketEfectuar = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        correoJt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        RFCJt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Regreso = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Generar Factura");

        jLabel2.setText("Ingrese el nombre del cliente:");

        NombreCliente.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                NombreClienteComponentAdded(evt);
            }
        });
        NombreCliente.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                NombreClienteCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                NombreClienteInputMethodTextChanged(evt);
            }
        });
        NombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreClienteActionPerformed(evt);
            }
        });
        NombreCliente.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                NombreClientePropertyChange(evt);
            }
        });
        NombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NombreClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NombreClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombreClienteKeyTyped(evt);
            }
        });

        Resultado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Resultado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ResultadoItemStateChanged(evt);
            }
        });

        jLabel3.setText("Resultado:");

        RealizarFacturaButton.setText("Realizar Factura");
        RealizarFacturaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RealizarFacturaButtonMouseClicked(evt);
            }
        });

        TicketEfectuar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        TicketEfectuar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TicketEfectuarItemStateChanged(evt);
            }
        });

        jLabel4.setText("Ticket a efectuar factura:");

        jLabel5.setText("Correo:");

        correoJt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                correoJtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correoJtKeyTyped(evt);
            }
        });

        jLabel6.setText("RFC");

        RFCJt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RFCJtActionPerformed(evt);
            }
        });
        RFCJt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RFCJtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RFCJtKeyTyped(evt);
            }
        });

        jLabel7.setText("A partir de usuario existente");

        javax.swing.GroupLayout PanelclienteoldLayout = new javax.swing.GroupLayout(Panelclienteold);
        Panelclienteold.setLayout(PanelclienteoldLayout);
        PanelclienteoldLayout.setHorizontalGroup(
            PanelclienteoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelclienteoldLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(PanelclienteoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelclienteoldLayout.createSequentialGroup()
                        .addGroup(PanelclienteoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelclienteoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TicketEfectuar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreCliente)
                            .addComponent(correoJt)
                            .addComponent(Resultado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RFCJt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelclienteoldLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(RealizarFacturaButton)
                        .addGap(14, 14, 14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelclienteoldLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(113, 113, 113))
        );
        PanelclienteoldLayout.setVerticalGroup(
            PanelclienteoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelclienteoldLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(PanelclienteoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelclienteoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addGroup(PanelclienteoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TicketEfectuar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(PanelclienteoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(correoJt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelclienteoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(RFCJt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(RealizarFacturaButton)
                .addGap(66, 66, 66))
        );

        Regreso.setText("Regresar");
        Regreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegresoMouseClicked(evt);
            }
        });

        jLabel8.setText("A partir de nuevo usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(151, 151, 151))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(346, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regreso)
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(375, 375, 375)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(Panelclienteold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(Panelclienteold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)))
                .addComponent(Regreso)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreClienteActionPerformed
        // TODO add your handling code her
    }//GEN-LAST:event_NombreClienteActionPerformed

    private void NombreClienteInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_NombreClienteInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreClienteInputMethodTextChanged

    private void RegresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegresoMouseClicked
        // TODO add your handling code here:
        Operaciones op = new Operaciones();
        op.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegresoMouseClicked

    private void NombreClienteCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_NombreClienteCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreClienteCaretPositionChanged

    private void NombreClientePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_NombreClientePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreClientePropertyChange

    private void NombreClienteComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_NombreClienteComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreClienteComponentAdded

    private void NombreClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreClienteKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_NombreClienteKeyPressed

    private void NombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreClienteKeyTyped
        // TODO add your handling code here:
        if(NombreCliente.getText().length() >= 50){
            evt.consume();
        }
    }//GEN-LAST:event_NombreClienteKeyTyped

    private void NombreClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreClienteKeyReleased
        // TODO add your handling code here:
        if(NombreCliente.getText().length()==0){
            RealizarFacturaButton.setEnabled(false);
            Resultado.removeAllItems();
        }
        else{
        Resultado.removeAllItems();
        Conexion bd = new Conexion();
        ResultSet rs;
        Statement s;
        try {
            s = conexion.createStatement();
            String query = "select *,(Nombre+' '+Apellido) as NombreCompleto from Cliente where (Nombre+' '+Apellido) like '"+NombreCliente.getText()+"%'";
            rs = s.executeQuery(query);
            while(rs.next()){
                Resultado.addItem(rs.getString("Nombre")+' '+rs.getString("Apellido"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
        }
    }//GEN-LAST:event_NombreClienteKeyReleased

    private void ResultadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ResultadoItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==evt.SELECTED){
            if(Resultado.getSelectedItem()==null || (correoJt.getText().length()==0 || RFCJt.getText().length()!=13)){
                RealizarFacturaButton.setEnabled(false);
                System.out.println("Boton Desahbilitado");
            }
            else{
                RealizarFacturaButton.setEnabled(true);
            }
            Conexion bd = new Conexion();
                ResultSet rs;
                Statement s;
                try {
                    s = conexion.createStatement();
                    String query = "select * from Cliente where Nombre+' '+Apellido like '"+Resultado.getSelectedItem()+"'";
                    rs = s.executeQuery(query);
                    System.out.println("AA");
                    while(rs.next()){
                        clienteID = rs.getString("ClienteID");
                        System.out.println("m,ssd");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Ocurrio un error");
                }
        }
    }//GEN-LAST:event_ResultadoItemStateChanged

    private void TicketEfectuarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TicketEfectuarItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==evt.SELECTED){
            ticketID = (String) TicketEfectuar.getSelectedItem();
        }
    }//GEN-LAST:event_TicketEfectuarItemStateChanged

    private void RFCJtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RFCJtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RFCJtActionPerformed

    private void correoJtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoJtKeyTyped
        // TODO add your handling code here:
        if(correoJt.getText().length() >= 100){
            evt.consume();
        }
    }//GEN-LAST:event_correoJtKeyTyped

    private void RFCJtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RFCJtKeyTyped
        // TODO add your handling code here:
        if(RFCJt.getText().length() >= 13){
            evt.consume();
        }
    }//GEN-LAST:event_RFCJtKeyTyped

    private void correoJtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoJtKeyReleased
        // TODO add your handling code here:
        if(Resultado.getSelectedItem()==null || (correoJt.getText().length()==0 || RFCJt.getText().length()!=13)){
                RealizarFacturaButton.setEnabled(false);
                System.out.println("Boton Desahbilitado");
            }
        else{
            RealizarFacturaButton.setEnabled(true);
        }
    }//GEN-LAST:event_correoJtKeyReleased

    private void RFCJtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RFCJtKeyReleased
        // TODO add your handling code here:
        if(Resultado.getSelectedItem()==null || (correoJt.getText().length()==0 || RFCJt.getText().length()!=13)){
                RealizarFacturaButton.setEnabled(false);
                System.out.println("Boton Desahbilitado");
            }
        else{
            RealizarFacturaButton.setEnabled(true);
        }
    }//GEN-LAST:event_RFCJtKeyReleased

    private void RealizarFacturaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RealizarFacturaButtonMouseClicked
        // TODO add your handling code here:
        RFC = RFCJt.getText();
        correo = correoJt.getText();
        fecha = Ingresar.devolverFecha();
        Conexion bd = new Conexion();
        ResultSet rs;
        Statement s;
        try {
            s = conexion.createStatement();
            String query = "INSERT INTO Factura\n" +
                            "VALUES ('"+correo+"','"+RFC+"','"+fecha+"',"+ticketID+","+clienteID+")";
            int a = s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Factura realizada exitosamente");
            dispose();
            GenerarFactura gen = new GenerarFactura();
            gen.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }//GEN-LAST:event_RealizarFacturaButtonMouseClicked

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
            java.util.logging.Logger.getLogger(GenerarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NombreCliente;
    private javax.swing.JPanel Panelclienteold;
    private javax.swing.JTextField RFCJt;
    private javax.swing.JButton RealizarFacturaButton;
    private javax.swing.JButton Regreso;
    private javax.swing.JComboBox<String> Resultado;
    private javax.swing.JComboBox<String> TicketEfectuar;
    private javax.swing.JTextField correoJt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables
}
