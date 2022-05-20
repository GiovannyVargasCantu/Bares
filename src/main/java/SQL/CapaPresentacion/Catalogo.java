/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SQL.CapaPresentacion;

import TablasCatalogo.TablaProveedores;
import TablasCatalogo.TablaClientes;
import TablasCatalogo.TablaComandas;
import TablasCatalogo.TablaEmpleados;
import TablasCatalogo.TablaEstados;
import TablasCatalogo.TablaFacturas;
import TablasCatalogo.TablaHorarios;
import TablasCatalogo.TablaMunicipios;
import TablasCatalogo.TablaProductos;
import TablasCatalogo.TablaPuestos;
import TablasCatalogo.TablaTickets;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Giovanny Vargas
 */
public class Catalogo extends javax.swing.JFrame {

    /**
     * Creates new form Consultas
     */
    public Catalogo() {
        initComponents();
    }
    
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonClientes = new javax.swing.JButton();
        BotonRegresoConsultas = new javax.swing.JButton();
        BotonProveedores = new javax.swing.JButton();
        BotonEmpleados = new javax.swing.JButton();
        BotonHorarios = new javax.swing.JButton();
        BotonPuestos = new javax.swing.JButton();
        BotonProductos = new javax.swing.JButton();
        BotonFacturas = new javax.swing.JButton();
        BotonTickets = new javax.swing.JButton();
        BotonComandas = new javax.swing.JButton();
        BotonEstados = new javax.swing.JButton();
        BotonMunicipios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonClientes.setText("Clientes");
        BotonClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonClientesMouseClicked(evt);
            }
        });

        BotonRegresoConsultas.setText("Regresar");
        BotonRegresoConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRegresoConsultasMouseClicked(evt);
            }
        });

        BotonProveedores.setText("Proveedores");
        BotonProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonProveedoresMouseClicked(evt);
            }
        });

        BotonEmpleados.setText("Empleados");
        BotonEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonEmpleadosMouseClicked(evt);
            }
        });

        BotonHorarios.setText("Horarios");
        BotonHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonHorariosMouseClicked(evt);
            }
        });

        BotonPuestos.setText("Puestos");
        BotonPuestos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonPuestosMouseClicked(evt);
            }
        });

        BotonProductos.setText("Productos");
        BotonProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonProductosMouseClicked(evt);
            }
        });

        BotonFacturas.setText("Facturas");
        BotonFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonFacturasMouseClicked(evt);
            }
        });

        BotonTickets.setText("Tickets");
        BotonTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonTicketsMouseClicked(evt);
            }
        });

        BotonComandas.setText("Comandas");
        BotonComandas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonComandasMouseClicked(evt);
            }
        });

        BotonEstados.setText("Estados");
        BotonEstados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonEstadosMouseClicked(evt);
            }
        });

        BotonMunicipios.setText("Municipios");
        BotonMunicipios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonMunicipiosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonRegresoConsultas)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonFacturas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonTickets))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonClientes)
                        .addGap(67, 67, 67)
                        .addComponent(BotonEmpleados)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(BotonProveedores))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(BotonComandas)))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonHorarios)
                    .addComponent(BotonEstados))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonPuestos)
                        .addGap(74, 74, 74)
                        .addComponent(BotonProductos))
                    .addComponent(BotonMunicipios))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonClientes)
                    .addComponent(BotonProveedores)
                    .addComponent(BotonEmpleados)
                    .addComponent(BotonHorarios)
                    .addComponent(BotonPuestos)
                    .addComponent(BotonProductos))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonFacturas)
                    .addComponent(BotonTickets)
                    .addComponent(BotonComandas)
                    .addComponent(BotonEstados)
                    .addComponent(BotonMunicipios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addComponent(BotonRegresoConsultas)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonClientesMouseClicked
        try {
            // TODO add your handling code here:
            TablaClientes tabla = new TablaClientes();
            tabla.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonClientesMouseClicked

    private void BotonRegresoConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegresoConsultasMouseClicked
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_BotonRegresoConsultasMouseClicked

    private void BotonProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonProveedoresMouseClicked
        try {
            // TODO add your handling code here:
            TablaProveedores tabla = new TablaProveedores();
            tabla.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonProveedoresMouseClicked

    private void BotonEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEmpleadosMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            TablaEmpleados tabla = new TablaEmpleados();
            tabla.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonEmpleadosMouseClicked

    private void BotonHorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonHorariosMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            TablaHorarios tabla = new TablaHorarios();
            tabla.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonHorariosMouseClicked

    private void BotonPuestosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonPuestosMouseClicked
        try {
            // TODO add your handling code here:
            TablaPuestos tabla = new TablaPuestos();
            tabla.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonPuestosMouseClicked

    private void BotonProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonProductosMouseClicked
        try {
            // TODO add your handling code here:
            TablaProductos tabla = new TablaProductos();
            tabla.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonProductosMouseClicked

    private void BotonFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonFacturasMouseClicked
        try {
            // TODO add your handling code here:
            TablaFacturas tabla = new TablaFacturas();
            tabla.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonFacturasMouseClicked

    private void BotonTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonTicketsMouseClicked
        try {
            // TODO add your handling code here:
            TablaTickets tabla = new TablaTickets();
            tabla.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonTicketsMouseClicked

    private void BotonComandasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonComandasMouseClicked
        try {
            // TODO add your handling code here:
            TablaComandas tabla = new TablaComandas();
            tabla.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonComandasMouseClicked

    private void BotonEstadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEstadosMouseClicked
        try {
            // TODO add your handling code here:
            TablaEstados tabla = new TablaEstados();
            tabla.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonEstadosMouseClicked

    private void BotonMunicipiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonMunicipiosMouseClicked
        try {
            // TODO add your handling code here:
            TablaMunicipios tabla = new TablaMunicipios();
            tabla.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonMunicipiosMouseClicked

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
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Catalogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonClientes;
    private javax.swing.JButton BotonComandas;
    private javax.swing.JButton BotonEmpleados;
    private javax.swing.JButton BotonEstados;
    private javax.swing.JButton BotonFacturas;
    private javax.swing.JButton BotonHorarios;
    private javax.swing.JButton BotonMunicipios;
    private javax.swing.JButton BotonProductos;
    private javax.swing.JButton BotonProveedores;
    private javax.swing.JButton BotonPuestos;
    private javax.swing.JButton BotonRegresoConsultas;
    private javax.swing.JButton BotonTickets;
    // End of variables declaration//GEN-END:variables
}
