/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalogoProveedores;

import empleados.empleadosDAO;
import java.awt.Frame;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author JOSE
 */
public class CatProveedor extends javax.swing.JDialog {
private static TableRowSorter<TableModel> sorter;
private static TableRowSorter<TableModel> sorter2;
    /**
     * Creates new form CatProveedor
     */
    public CatProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
         try {
        llenarTablaEmp();
        llenarTablapagos();
        }catch (Exception ex) {        
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtproveedor = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtpagosproveedor = new javax.swing.JTable();
        txtbusca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtbusca1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtproveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtproveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Comentario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtproveedor.setRowHeight(24);
        jScrollPane1.setViewportView(jtproveedor);

        jtpagosproveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha Pago", "Proveedor", "Monto", "Observacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtpagosproveedor.setRowHeight(24);
        jScrollPane2.setViewportView(jtpagosproveedor);

        txtbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscaKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Pagos realizados");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AddSmall.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Excel.gif"))); // NOI18N
        jButton2.setText("Exportar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Pagar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtbusca1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbusca1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbusca1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2)
                    .addComponent(txtbusca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscaKeyPressed
        // TODO add your handling code here:
           
                filtrar();           

            
    }//GEN-LAST:event_txtbuscaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         Frame f = JOptionPane.getFrameForComponent(this);
        NuevoProveedor dialog = new NuevoProveedor(f, true);
        dialog.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        Date fecha1=new Date();
            SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy hh-MM-ss");
            //formateador.format(fecha1);
            System.out.println(formateador.format(fecha1));  
            System.out.println(fecha1.toLocaleString());
            File archivo;


            javax.swing.JFileChooser jF1= new javax.swing.JFileChooser(); 
            String ruta = ""; 
            try{ 
            if(jF1.showSaveDialog(null)==jF1.APPROVE_OPTION){ 
            ruta = jF1.getSelectedFile().getAbsolutePath();
            //archivo = new File(ruta+""+formateador.format(fecha1)+".xls");
            archivo = new File(ruta+".xls");
            System.out.println(archivo);
            //Aqui ya tiens la ruta,,,ahora puedes crear un fichero n esa ruta y escribir lo k kieras...
            exportarjTable(jtpagosproveedor,archivo);
            JOptionPane.showMessageDialog(null, "El reporte se ha generado con exito", "Mensaje", JOptionPane.DEFAULT_OPTION);
            } 
            }catch (Exception ex){ 
                    JOptionPane.showMessageDialog(null, "No se ha podido generar el archivo:"+ex, "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); 
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtbusca1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusca1KeyPressed
        // TODO add your handling code here:
        filtrar2();
    }//GEN-LAST:event_txtbusca1KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
                int fila=-1;
	fila=jtproveedor.getSelectedRow();
	if(fila!=-1){
            String id=jtproveedor.getValueAt(jtproveedor.getSelectedRow(), 0).toString();
            System.out.println(""+id);
            Frame f = JOptionPane.getFrameForComponent(this);
            Pagar dialog = new Pagar(f, true,id);
            dialog.show();
            
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione un proveedor de la tabla","Alerta",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CatProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CatProveedor dialog = new CatProveedor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable jtpagosproveedor;
    private static javax.swing.JTable jtproveedor;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JTextField txtbusca1;
    // End of variables declaration//GEN-END:variables

    
    public static void llenarTablaEmp() throws Exception{
       jtproveedor.removeAll(); 
       empleadosDAO control=new empleadosDAO();
       ResultSet res= control.obtenproveedor();
           String[] datosTabla={"Id", "Nombre", "Comentario"};
           DefaultTableModel datos = new DefaultTableModel(null, datosTabla);
           while(res.next()){                             
                datos.addRow(new Object[]{res.getString("Idproveedor"),res.getString("nombre"),res.getString("comentario")});
           }
           res.close();           
          jtproveedor.setModel(datos);           
          jtproveedor.getTableHeader().setReorderingAllowed(false);          
          sorter = new TableRowSorter<TableModel>(datos);
          jtproveedor.setRowSorter(sorter);
          jtproveedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         
          
    }

    private void filtrar() {
         RowFilter<TableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter("(?i)"+txtbusca.getText(),1,2);
        }catch (java.util.regex.PatternSyntaxException e) {
        }
        sorter.setRowFilter(rf);
        
    }
    
     private void filtrar2() {
         RowFilter<TableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter("(?i)"+txtbusca1.getText(),1,2);
        }catch (java.util.regex.PatternSyntaxException e) {
        }
        sorter2.setRowFilter(rf);
        
    }


    public static void llenarTablapagos() throws Exception{
       jtpagosproveedor.removeAll(); 
       empleadosDAO control=new empleadosDAO();
       ResultSet res= control.obtenpagos();
           String[] datosTabla={"Id", "Fecha Pago", "Proveedor", "Monto", "Observacion"};
           DefaultTableModel datos = new DefaultTableModel(null, datosTabla);
           while(res.next()){                             
                datos.addRow(new Object[]{res.getString("Idpagoprovedor"),res.getString("Fechapago"),res.getString("nombre"),res.getString("montoPago"),res.getString("observacion")});
           }
           res.close();           
          jtpagosproveedor.setModel(datos);           
          jtpagosproveedor.getTableHeader().setReorderingAllowed(false);          
          sorter2 = new TableRowSorter<TableModel>(datos);
          jtpagosproveedor.setRowSorter(sorter2);
          jtpagosproveedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         
          
    }
    
    public void exportarjTable(JTable tabla, File ficheroXLS) throws IOException {
        TableModel modelo = tabla.getModel();
        FileWriter fichero = new FileWriter(ficheroXLS);
        
        for(int i=0; i < modelo.getColumnCount(); i++) {
            fichero.write(modelo.getColumnName(i) + "\t");
        }
        fichero.write("\n");
        for(int i=0; i< modelo.getRowCount(); i++) {
            for(int j=0; j < modelo.getColumnCount(); j++) {
                fichero.write(modelo.getValueAt(i,j).toString()+"\t");
            }
            fichero.write("\n");
        }
        fichero.close();
    }

}
