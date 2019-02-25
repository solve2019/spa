/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package checador;

import conex.conexion;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author desarrollo8
 */
public class ValidadorLicencia {
    
    public boolean validasoftware(){
        boolean activo=false;
        String mac="";//obtenmac();
        String maclicencia=""; //direccionmaclicencia();   
        mac="";
        maclicencia="";
        
        String estatus="",idestatus="";
        int fechafinal=0;
        conexion con=new conexion();  
        try {
            ResultSet rsR = null; 
            String myQuery = "select estatus,idestatus, datediff(fecha_fin, now()) as diferencia from to_activacion where id_activacion='1'";                                        
            Statement st = con.getConnection().createStatement();  
            rsR = st.executeQuery(myQuery);
            while(rsR.next()) {
                estatus=rsR.getString("estatus");
                idestatus=rsR.getString("idestatus");
                fechafinal=rsR.getInt("diferencia");
            }
            rsR.close();
            st.close();
            con.desconectar();                                                                    
        } catch (SQLException ex) {                               
        }
        
        
        if(mac.equals(maclicencia) && estatus.equals("ACTIVADO") && idestatus.equals("5") && fechafinal>=0){
            activo=true;
        }
        return activo;
    }
    
    
    
    
    public String obtenmac(){  
        String macadress="";
        InetAddress ip;
	try {	
		ip = InetAddress.getLocalHost();
		//System.out.println("Current IP address : " + ip.getHostAddress());
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);			
		byte[] mac = network.getHardwareAddress();			
		//System.out.print("Current MAC address : ");			
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
                macadress=sb.toString();
		//System.out.println(sb.toString());
			
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}
        
        return macadress;
    }
    
    
    
    public String direccionmaclicencia(){  
      String mac="";
      String archivo="";  //ruta del sistema
      archivo = new File ("").getAbsolutePath ()+"/licencia.txt";   
      File archi = new File(archivo);
      if(archi.exists()) {
        //System.out.println("existe el archivo");
        String cadena;
        FileReader f;
          try {
              f = new FileReader(archivo);
              BufferedReader b = new BufferedReader(f);
              try {
                  while((cadena = b.readLine())!=null) {
                      mac=cadena;
                      //System.out.println(cadena);
                  }
                  b.close();
              } catch (IOException ex) {
                  Logger.getLogger(ValidadorLicencia.class.getName()).log(Level.SEVERE, null, ex);
              }            
          } catch (FileNotFoundException ex) {
              //JOptionPane.showMessageDialog(null, "La lic.","Alerta",JOptionPane.ERROR_MESSAGE);
              Logger.getLogger(ValidadorLicencia.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
        
      if(mac.length()<59){    
      }else{//posicion de serial 43-60
          mac=mac.substring(42,59);
      }
      
    return mac;
    }
    
    
}
