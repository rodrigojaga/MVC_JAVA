
package EjercicioVistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class Menu_principal extends javax.swing.JFrame {
    
    vistasDAO cl = new vistasDAO();
    DefaultTableModel tabla_modelo;
    Crear cv = new Crear();
    ArrayList <producto> datos;

    public Menu_principal() {
        initComponents();
        Tabla();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_general = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(tabla_general);

        jButton1.setText("Crear Nuevo Producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar Producto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar Producto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(51, 51, 51)
                .addComponent(jButton3)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        cv.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        mostrar();
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       cl.buscar_eliminar(Integer.parseInt(tabla_general.getValueAt(tabla_general.getSelectedRow(), 0).toString())); 
    }//GEN-LAST:event_jButton3ActionPerformed

   public void Tabla(){
       
       datos = cl.listar();
       String titulos[] = {"Codigo", "Nombre Producto", "Cantidad Existente", "Lugar de fabricacion","Fecha de ingreso"};
       tabla_modelo = new DefaultTableModel(null, titulos);
       
       for (producto general : datos) {
            Object informacion[] = new Object[5];
            informacion[0] = general.getCodigo();
            informacion[1] = general.getNombre();
            informacion[2] = general.getCantidad();
            informacion[3] = general.getFabricacion();
            informacion[4] = general.getFecha();
            tabla_modelo.addRow(informacion);
        }

       tabla_general.setModel(tabla_modelo);
       
   }
   
   public void mostrar(){
       
       //int fila = tabla_general.getSelectedRow();
        //System.out.println(datos.get(fila).getNombre());
        cl.buscar(Integer.parseInt(tabla_general.getValueAt(tabla_general.getSelectedRow(), 0).toString())); 
        dispose();
       
   }
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Menu_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_general;
    // End of variables declaration//GEN-END:variables
}
