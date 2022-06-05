/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SQL.CapaPresentacion;

import SQL.Conexion;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giovanny Vargas
 */
public class Catalogo extends javax.swing.JFrame {

    /**
     * Creates new form Consultas
     */
    
    
    
    public Catalogo() throws SQLException {
        initComponents();
    }
    
 private Conexion bd;
 int elegir;
 String OpcionElegida;
 String[] IdentificadorColumnas = null;
 String[] NombreTablas =  ObtenerTablas();
 
 private void MostrarTabla(int tabla) throws SQLException{
     bd = new Conexion(); 
     IdentificadorColumnas = bd.ObtenerNombreColumnas(tabla);
     //System.out.println(Arrays.toString(IdentificadorColumnas));
DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
aModel.setRowCount(0);
aModel.setColumnIdentifiers(IdentificadorColumnas);
ResultSet rs =  bd.Catalogo(tabla);

// Loop through the ResultSet and transfer in the Model
ResultSetMetaData rsmd = rs.getMetaData();
int colNo = rsmd.getColumnCount();
while(rs.next()){
 Object[] objects = new Object[colNo];
 // tanks to umit ozkan for the bug fix!
 for(int i=0;i<colNo;i++){
  objects[i]=rs.getObject(i+1);
  }
 aModel.addRow(objects);
}
jTable1.setModel(aModel);
 }

    public String[] ObtenerTablas() {
        bd = new Conexion();
        return bd.ObtenerNombreTablas();
    }

    private String[] ObtenerColumnas(int NombreTablas) {
        bd = new Conexion();
        return bd.ObtenerNombreColumnas(NombreTablas);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonRegresoConsultas = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonRegresoConsultas.setText("Regresar");
        BotonRegresoConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRegresoConsultasMouseClicked(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(NombreTablas));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotonRegresoConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonRegresoConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegresoConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegresoConsultasMouseClicked
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_BotonRegresoConsultasMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
            try {
            // TODO add your handling code here:
            OpcionElegida = jComboBox1.getSelectedItem().toString();
            System.out.println(OpcionElegida);
            
           
            elegir = 0;
            
            if(OpcionElegida.equals("Cliente")) elegir = 1; //Ya hecha
            if(OpcionElegida.equals("Proveedor")) elegir = 2;//Saul
            if(OpcionElegida.equals("Empleado")) elegir = 3;//Gio
            if(OpcionElegida.equals("Horario")) elegir = 4;//Aldo
            if(OpcionElegida.equals("Puesto")) elegir = 5;//Saul
            if(OpcionElegida.equals("Factura")) elegir = 6;//No
            if(OpcionElegida.equals("Ticket")) elegir = 7;//No
            if(OpcionElegida.equals("Comanda")) elegir = 8;//No
            if(OpcionElegida.equals("Estados")) elegir = 9;//No
            if(OpcionElegida.equals("Municipios")) elegir = 10;//No
            if(OpcionElegida.equals("Productos")) elegir = 11;//Gio
            if(OpcionElegida.equals("DetalleComanda")) elegir = 12;//No
            if(OpcionElegida.equals("DetalleProveedor")) elegir = 13;//Saul
            if(OpcionElegida.equals("DetalleTicket")) elegir = 14;//No
            if(OpcionElegida.equals("Mesas")) elegir = 15;//Alex
            if(OpcionElegida.equals("MeseroAtiendeMesa")) elegir = 16;//Alex
            if(OpcionElegida.equals("TipoProducto")) elegir = 17;//aldo
            if(OpcionElegida.equals("Usuarios")) elegir = 18;//Gio
            //IdentificadorColumnas = ObtenerColumnas(elegir);
            switch(elegir){
            case 1: MostrarTabla(1);
            break;
            case 2: MostrarTabla(2);
            break;
            case 3: MostrarTabla(3);
            break;
            case 4: MostrarTabla(4);
            break;
            case 5: MostrarTabla(5);
            break;
            case 6: MostrarTabla(6);
            break;
            case 7: MostrarTabla(7);
            break;
            case 8: MostrarTabla(8);
            break;
            case 9: MostrarTabla(9);
            break;
            case 10: MostrarTabla(10);
            break;
            case 11: MostrarTabla(11);
            break;
            case 12: MostrarTabla(12);
            break;
            case 13: MostrarTabla(13);
            break;
            case 14: MostrarTabla(14);
            break;
            case 15: MostrarTabla(15);
            break;
            case 16: MostrarTabla(16);
            break;
            case 17: MostrarTabla(17);
            break;
            case 18: MostrarTabla(18);
            break;
            }
            } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
            }
      
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
                try {
                    new Catalogo().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonRegresoConsultas;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
