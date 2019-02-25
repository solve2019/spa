/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reportes;
import conex.conexion;
import empleados.empleadosDAO;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import movimientos.movimientosDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
/**
 *
 * @author jose
 */
public class reporteExcel extends javax.swing.JDialog {
        private  String bd = conexion.bd;   
	private  String login = conexion.login;   
    	private  String password = conexion.password;   
	private  String url = conexion.url; 
	Connection conn;
        private static TableRowSorter<TableModel> sorter;
    /**
     * Creates new form reportes
     */
    public reporteExcel(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/checador.png"));
        setIconImage(icon); 
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtbusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtmovimientos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte E/S");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(244, 244, 247));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Fecha Inicio:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fecha Fin:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BuscarIcon.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy/MM/d");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jDateChooser1.setName("jdateinicio"); // NOI18N

        jDateChooser2.setDateFormatString("yyyy/MM/d");
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jDateChooser2.setName("jdatefin"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Socio:");

        txtbusca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscaKeyPressed(evt);
            }
        });

        jtmovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Entrada", "Socio", "Tratamiento", "Usuario Atendio", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtmovimientos);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Excel.gif"))); // NOI18N
        jButton2.setText("Exportar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbusca)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbusca, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println("1."+jDateChooser1.getDate());
        System.out.println("2."+jDateChooser2.getDate());

        if(jDateChooser1.getDate()==null){
            JOptionPane.showMessageDialog(null,"Falta ingresar la fecha inicial.","Mensaje",JOptionPane.ERROR_MESSAGE);

        }else if(jDateChooser2.getDate()==null){
            JOptionPane.showMessageDialog(null,"Falta seleccionar la fecha final.","Mensaje",JOptionPane.ERROR_MESSAGE);
        }else{

            String fechaini=new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());
            String fechafin=new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser2.getDate());
            System.out.println("fecha1"+fechaini);
            System.out.println("fechafin"+fechafin);
            try {        
                llenarTablaEmp(fechaini,fechafin);
            } catch (Exception ex) {
                Logger.getLogger(reporteExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtbuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscaKeyPressed
        // TODO add your handling code here:
        filtrar();
    }//GEN-LAST:event_txtbuscaKeyPressed

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
            exportarjTable(jtmovimientos,archivo);
            JOptionPane.showMessageDialog(null, "El reporte se ha generado con exito", "Mensaje", JOptionPane.DEFAULT_OPTION);
            } 
            }catch (Exception ex){ 
                    JOptionPane.showMessageDialog(null, "No se ha podido generar el archivo:"+ex, "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); 
            }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(reporteExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reporteExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reporteExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reporteExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new reporteExcel().setVisible(true);
            }
        });
    }
    
    
    
     public void llenarTablaEmp(String fechaini, String fechafin) throws Exception{
       jtmovimientos.removeAll(); 
       movimientosDAO control=new movimientosDAO();
       ResultSet res= control.obtenerMovimientoFechas(fechaini,fechafin);
           String[] datosTabla={ "Fecha entrada", "Socio", "Tratamiento", "Usuario atendio","Comision"};
           DefaultTableModel datos = new DefaultTableModel(null, datosTabla);
           while(res.next()){               
                datos.addRow(new Object[]{res.getString("fecha_entrada"),res.getString("nombre"),res.getString("motivo"),res.getString("usuario"),res.getString("comision")});
           }
           res.close();
            jtmovimientos.setModel(datos);
           
           jtmovimientos.getTableHeader().setReorderingAllowed(false);          
          sorter = new TableRowSorter<TableModel>(datos);
          jtmovimientos.setRowSorter(sorter);
          //jtmovimientos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         
          //jtmovimientos.getColumnModel().getColumn(0).setMaxWidth(530);
           
    }
    
    private void filtrar() {
         RowFilter<TableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter("(?i)"+txtbusca.getText(),0);
        }catch (java.util.regex.PatternSyntaxException e) {
        }
        sorter.setRowFilter(rf);
        
    }
    
    
    public String obtenid(String opcion){
            String id = null, desc="";		
             StringTokenizer st = new StringTokenizer(opcion, "-");
             //id=st.nextToken();
                    while(st.hasMoreTokens()) {										
                            id=st.nextToken().trim();
                            desc=st.nextToken().trim();
                            }
                    return id;

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtmovimientos;
    private javax.swing.JTextField txtbusca;
    // End of variables declaration//GEN-END:variables


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