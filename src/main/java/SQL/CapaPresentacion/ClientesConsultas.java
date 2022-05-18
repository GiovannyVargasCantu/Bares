/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL.CapaPresentacion;

import SQL.Conexion;
import SQL.Valores;
import com.sun.jdi.Value;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ClientesConsultas extends JFrame{
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel(new Object[][][][][]{},new String[]{"First column","Second column","b","c","d"});

    public ClientesConsultas(){
        table.setModel(model);
        add(new JScrollPane(table));

        //Populate table
        Conexion bd = new Conexion();
        List<Value> values = bd.ConsultaClientes();
        for(Valores v : values){
            model.addRow(new Object[]{v.getClienteID(),v.getNombre(),v.getApellidos()});
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                ClientesConsultas ms = new ClientesConsultas();
                ms.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ms.pack();
                ms.setVisible(true);
            }});
    }
}
