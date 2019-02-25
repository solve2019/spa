/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbrirChapa;
import giovynet.nativelink.SerialPort;
import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author JOSE
 */
public class abrirchapaarduino {
    String puerto="COM4";
    
    public void abrirchapa(){
    //Definición de parametros
    
  /*  
        try {
            Parameters settings = null;
            settings = new Parameters();
            settings.setBaudRate(Baud._9600);
            //settings.setByteSize("8");
            //settings.setStopBits("1");  
            //settings.setParity("N");
            
            //definición del puerto que se va a utilizar
            settings.setPort(puerto);                        
            //asignamos los parametros al objeto com1
            Com com1 = new Com(settings);                        
            Thread.sleep(2000);
            System.out.println("ANTER DE ENVIAR EL COMANDO");
            //com1.sendSingleData("1");   
            System.out.println("DESPUES DE ENVIAR EL COMANDO");
            Thread.sleep(500);            
            com1.close();            
            System.out.println("salir puerto COM");
        } catch (Exception ex) {
            //Logger.getLogger(enviardato.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("REVISAR CONEXION PUERTO DEL ARDUINO COM6 "+ex);
            JOptionPane.showMessageDialog(null,"CIERRA EL SISTEMA Y DESCONECTA EL CABLE USB AZUL Y VUELVE A CONECTARLO "+ex, "Error modulo para abrir puerta", JOptionPane.ERROR_MESSAGE);
        }

*/
    
    }
    
    
    
    
    public void abrirchapamanual(){
    //Definición de parametros
    
        try {
            Parameters settings = null;
            Com com1 =null;
            settings = new Parameters();
            settings.setBaudRate(Baud._9600);
            //settings.setByteSize("8");
            //settings.setStopBits("1");  
            //settings.setParity("N");
            
            //definición del puerto que se va a utilizar
            settings.setPort(puerto);
            //settings.setMinDelayWrite(10);

            //asignamos los parametros al objeto com1
            com1 = new Com(settings);
            System.out.println("antes del sleep");
            Thread.sleep(2000);
            System.out.println("ANTER DE ENVIAR EL COMANDO"); 
            char a='a';            
            /*com1.sendSingleData(a);   
            com1.sendSingleData(a);   
            com1.sendSingleData(a);   
            com1.sendSingleData(a);   
            com1.sendSingleData(a);   
            com1.sendSingleData(a);   */
            
            System.out.println("DESPUES DE ENVIAR EL COMANDO");
            Thread.sleep(500);                                              
            com1.close();
            System.out.println("salir puerto COM");
        } catch (Exception ex) {
            System.out.println("REVISAR CONEXION PUERTO DEL ARDUINO COM6 "+ex);
            JOptionPane.showMessageDialog(null,"CIERRA EL SISTEMA Y DESCONECTA EL CABLE USB AZUL Y VUELVE A CONECTARLO "+ex, "Error modulo para abrir puerta", JOptionPane.ERROR_MESSAGE);            
        }


    
    }
}
