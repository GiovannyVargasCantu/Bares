/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SQL.CapaPresentacion;

import Consultas.Consultas;
import SQL.Conexion;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Giovanny Vargas
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        AsignarNombrePuesto();
        ValidacionPuesto();
        AsignarNombreUsuario();
        mostrarFecha();
        mostrarTiempo();
        Conexion con = new Conexion();
        con.establecerConexion();
        System.out.println(Conexion.usuario+""+Conexion.contrasenia);
        
    }
    private Conexion bd;
    int puesto=0;
     private void AsignarNombrePuesto() {
        NombreUsuario.setText(Conexion.usuario);
    }
      private void AsignarNombreUsuario() {
        jLabel3.setText(Ingresar.usuario);
    }
     private void ValidacionPuesto(){
         bd = new Conexion();
         puesto = bd.ObtenerPuestoID();
         switch(puesto){
             case 1: break;
             case 2: break;
             case 3: consultaButton.setEnabled(false);
                     catalogoButton.setEnabled(false);
                     break;
             case 4: catalogoButton.setEnabled(false);
                     break;
         }
     }
     void mostrarFecha(){
        Date fecha = new Date();
        SimpleDateFormat sfecha = new SimpleDateFormat("dd/MM/yyyy");
        FechaLabel.setText(sfecha.format(fecha));
    }
    
    void mostrarTiempo(){
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date hora = new Date();
        SimpleDateFormat shora = new SimpleDateFormat("hh:mm:ss a");
        HoraLabel.setText(shora.format(hora));
            }
        }).start();
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
        bg = new javax.swing.JPanel();
        BotonRegreso = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        catalogoButton = new javax.swing.JButton();
        operacionButton = new javax.swing.JButton();
        consultaButton = new javax.swing.JButton();
        TextoBienvenida = new javax.swing.JLabel();
        NombreUsuario = new javax.swing.JLabel();
        FechaLabel = new javax.swing.JLabel();
        HoraLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonRegreso.setText("Cerrar Sesi??n");
        BotonRegreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRegresoMouseClicked(evt);
            }
        });
        bg.add(BotonRegreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 466, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 490));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        bg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 180, 150));

        jPanel3.setBackground(new java.awt.Color(170, 170, 170));

        catalogoButton.setBackground(new java.awt.Color(170, 170, 170));
        catalogoButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        catalogoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/catego.png"))); // NOI18N
        catalogoButton.setText("Catalogos");
        catalogoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catalogoButtonMouseClicked(evt);
            }
        });
        catalogoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoButtonActionPerformed(evt);
            }
        });

        operacionButton.setBackground(new java.awt.Color(170, 170, 170));
        operacionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fasff.png"))); // NOI18N
        operacionButton.setText("Operacion");
        operacionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                operacionButtonMouseClicked(evt);
            }
        });
        operacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operacionButtonActionPerformed(evt);
            }
        });

        consultaButton.setBackground(new java.awt.Color(170, 170, 170));
        consultaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consulta.png"))); // NOI18N
        consultaButton.setText("Consulta");
        consultaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultaButtonMouseClicked(evt);
            }
        });
        consultaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(catalogoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(operacionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(consultaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(catalogoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(operacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consultaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        bg.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 490));

        TextoBienvenida.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TextoBienvenida.setText("Bienvenido");
        bg.add(TextoBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 180, 50));

        NombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        NombreUsuario.setForeground(new java.awt.Color(0, 204, 0));
        NombreUsuario.setText("jLabel3");
        bg.add(NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 90, 30));

        FechaLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        FechaLabel.setText("Fecha");
        bg.add(FechaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        HoraLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        HoraLabel.setText("Hora");
        bg.add(HoraLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Puesto:");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("jLabel3");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void catalogoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catalogoButtonMouseClicked

    }//GEN-LAST:event_catalogoButtonMouseClicked

    private void BotonRegresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegresoMouseClicked
        // TODO add your handling code here:
        Ingresar ingreso = new Ingresar();
        ingreso.setVisible(true);
        dispose();
    }//GEN-LAST:event_BotonRegresoMouseClicked

    private void catalogoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogoButtonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Catalogo catalogo = new Catalogo();
            catalogo.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_catalogoButtonActionPerformed

    private void operacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operacionButtonActionPerformed
        // TODO add your handling code here:
        Operaciones consulta = new Operaciones();
        consulta.setVisible(true);
        dispose();
    }//GEN-LAST:event_operacionButtonActionPerformed

    private void consultaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaButtonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            //Leave it to me!
            Consultas consulta = new Consultas();
            consulta.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_consultaButtonActionPerformed

    private void consultaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultaButtonMouseClicked
        
    }//GEN-LAST:event_consultaButtonMouseClicked

    private void operacionButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_operacionButtonMouseClicked
        // TODO add your handling code here:
        //Leave it to me!
        
    }//GEN-LAST:event_operacionButtonMouseClicked

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonRegreso;
    private javax.swing.JLabel FechaLabel;
    private javax.swing.JLabel HoraLabel;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JLabel TextoBienvenida;
    private javax.swing.JPanel bg;
    private javax.swing.JButton catalogoButton;
    private javax.swing.JButton consultaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton operacionButton;
    // End of variables declaration//GEN-END:variables

}
