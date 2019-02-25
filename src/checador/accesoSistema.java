/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checador;

import conex.conexion;
import java.security.MessageDigest;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author desarrollo8
 */
public class accesoSistema {
    public static String nombreuser="";
    public static String iduser;  
    public static String privilegio="";  
    public static double monto_caja_inicial=0.00;
    public static String licencia="DEMO";  
    public accesoSistema() {
    }
    
    public boolean validaAcceso(String user,String password){
        ValidadorLicencia lic=new ValidadorLicencia();       
        //valida software
        if(lic.validasoftware()){
        licencia="ACTIVADO";
            //JOptionPane.showMessageDialog(null, "El software esta activo.","Test licencia",JOptionPane.INFORMATION_MESSAGE);  
        }  
        //licencia="ACTIVADO";
        boolean validauser=false;
        //validauser=true;
        
        
       
        conexion con=new conexion();   
        String pass=GeneraClaveMD5(password);
        
        ResultSet rs = null;       
        String myQuery = "SELECT * FROM tc_usuarios WHERE usuario ='"+user+"' and password='"+pass+"' and estatus=1";
        System.out.println(""+myQuery);
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);
            if(rs.next()) { 
                iduser=rs.getString("idusuario");
                nombreuser=rs.getString("nombre");
                privilegio=rs.getString("perfil");
                validauser=true;
            }
            rs.close(); 
            con.desconectar(); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en base de datos: "+ex, "Alerta BD", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(accesoSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    return validauser;
   } 
    
     public String GeneraClaveMD5(String passs){
        //Transformanos el password a MD
        String contra = null;
        StringBuffer sb = new StringBuffer();
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(passs.getBytes());
            byte[] digest = md.digest();
            String hex;
            for (int i=0;i<digest.length;i++){
                hex =  Integer.toHexString(0xFF & digest[i]);
                if(hex.length() == 1){hex = "0" + hex;}
                sb.append(hex);            
            }
        } catch(Exception ee) {

        }
        contra = sb.toString();

        return contra;
    }
}
