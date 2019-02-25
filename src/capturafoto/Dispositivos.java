/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package capturafoto;

import conex.conexion;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import javax.media.Buffer;
import javax.media.CannotRealizeException;
import javax.media.CaptureDeviceInfo;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.cdm.CaptureDeviceManager;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.RGBFormat;
import javax.media.format.VideoFormat;
import javax.media.format.YUVFormat;
import javax.media.util.BufferToImage;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Cmop
 */
public class Dispositivos {

    private frmPrincipal padre;
    private Player player;

    public Dispositivos(frmPrincipal padre)
    {
        this.padre=padre;
    }

    public String verInfoDispositivos()
    {
      String rpta="";
      Vector listaDispositivos = null;
      //Buscamos los dispositivos instalados
      listaDispositivos = CaptureDeviceManager.getDeviceList();
      Iterator it = listaDispositivos.iterator();
      while (it.hasNext())
      {
        CaptureDeviceInfo cdi = (CaptureDeviceInfo)it.next();
        rpta+=cdi.getName()+"\n";
        //cdi.getName() --> Obtiene el nombre del Dispositivo Detectado
      }
      if(rpta.compareTo("")!=0)
          rpta="Dispositivos detectados:\n\n"+rpta;
      else
          rpta="Sin Dispositivos Detectados";
      
      return rpta;
    }

    public void detectarDispositivos(JMenu dispositivos)
    {
      Vector listaDispositivos = null;
      //Buscamos los dispositivos instalados
      listaDispositivos = CaptureDeviceManager.getDeviceList();
      Iterator it = listaDispositivos.iterator();

      String nombre="";
      while (it.hasNext())
      {
          CaptureDeviceInfo cdi = (CaptureDeviceInfo)it.next();
          nombre=cdi.getName(); //cdi.getName() --> Obtiene el nombre del Dispositivo Detectado
          
          if(nombre.indexOf("Image")!=-1)
          {
              JMenu menuFormato=new JMenu(nombre);
              JMenuFormato tamanios=null;
              CaptureDeviceInfo dev = CaptureDeviceManager.getDevice(nombre);
              Format[] cfmts = dev.getFormats();

              for(int i=0; i<cfmts.length;i++)
              {
                  if(cfmts[i].getEncoding().compareTo("yuv")==0)
                  {tamanios=new JMenuFormato(cfmts[i].getEncoding()+" "+
                          ((YUVFormat)cfmts[i]).getSize().width+"x"+
                          ((YUVFormat)cfmts[i]).getSize().height,
                          ((YUVFormat)cfmts[i]).getSize().width,
                          ((YUVFormat)cfmts[i]).getSize().height,
                          padre,
                          padre.jPWebCam);
                  }
                  else if(cfmts[i].getEncoding().compareTo("rgb")==0)
                  {tamanios=new JMenuFormato(cfmts[i].getEncoding()+" "+
                          ((RGBFormat)cfmts[i]).getSize().width+"x"+
                          ((RGBFormat)cfmts[i]).getSize().height,
                          ((RGBFormat)cfmts[i]).getSize().width,
                          ((RGBFormat)cfmts[i]).getSize().height,
                          padre,
                          padre.jPWebCam);
                  }
                  menuFormato.add(tamanios);
              }
              dispositivos.add(menuFormato);
          }
      }
    }

    public void MuestraWebCam(JPanel panelCam,String dispositivo,String FormatoColor)
    {
        if(player != null)
            return;
        
        CaptureDeviceInfo dev = CaptureDeviceManager.getDevice(dispositivo);
        //obtengo el locator del dispositivo
        MediaLocator loc = dev.getLocator();
        
            try {
                player = Manager.createRealizedPlayer(loc);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoPlayerException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CannotRealizeException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        player.start();

        try {
            // esto lo saqué del foro jmf de Sun, hay que "parar un poco la aplicacion"
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        Component comp;

        if ((comp = player.getVisualComponent())!= null)
        {
          // mostramos visualmente el reproductor          
          panelCam.add(comp,BorderLayout.CENTER);
          padre.pack();
        }
    }

    public void CapturaFoto(String id_emp)
    {
        System.out.println("1");     
        Image img=null;
        FrameGrabbingControl fgc = (FrameGrabbingControl)
        player.getControl("javax.media.control.FrameGrabbingControl");
        Buffer buf = fgc.grabFrame();
        System.out.println("2");
        // creamos la imagen awt
        BufferToImage btoi = new BufferToImage((VideoFormat)buf.getFormat());
        img = btoi.createImage(buf);
        System.out.println("3");
        if (img != null)
        {
            
                
                String formato = "JPEG";
                 
                     
                     ByteArrayOutputStream out=new ByteArrayOutputStream();
                    try {
                        ImageIO.write((RenderedImage) img, formato, out);
                    } catch (IOException ex) {
                        if(!id_emp.equals("0")){
                        JOptionPane.showMessageDialog(null,"Error al obtener la foto de la camara "+ex,"Alerta",JOptionPane.ERROR_MESSAGE);
                        }
                        Logger.getLogger(Dispositivos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     InputStream in=new ByteArrayInputStream(out.toByteArray());
                     conexion con=new conexion();                      String sql = "update tc_empleados set Imagen = (?) where id_empleado="+id_emp;
                     PreparedStatement stmt = null;
                        try {
                            stmt = con.getConnection().prepareStatement(sql);
                        } catch (SQLException ex) {
                            Logger.getLogger(Dispositivos.class.getName()).log(Level.SEVERE, null, ex);
                            if(!id_emp.equals("0")){
                            JOptionPane.showMessageDialog(null,"Error al registrar la foto "+ex,"Alerta",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        try {
                            stmt.setBinaryStream(1,in);
                        } catch (SQLException ex) {
                            Logger.getLogger(Dispositivos.class.getName()).log(Level.SEVERE, null, ex);
                            if(!id_emp.equals("0")){
                            JOptionPane.showMessageDialog(null,"Error al registrar la foto "+ex,"Alerta",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        try {
                            stmt.execute();
                            if(!id_emp.equals("0")){
                            JOptionPane.showMessageDialog(null,"Se registro la foto correctamente","Ok",JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Dispositivos.class.getName()).log(Level.SEVERE, null, ex);
                            if(!id_emp.equals("0")){
                            JOptionPane.showMessageDialog(null,"Error al registrar la foto "+ex,"Alerta",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                     con.desconectar();
                     System.out.println("SALIDA DE IMAGEN");
                     
                     player.close();
                     //player.deallocate();
                     //player=null;
                //try{ 
                   //ImageIO.write((RenderedImage) img,formato,imagenArch);
                //}catch (IOException ioe){System.out.println("Error al guardar la imagen");}
            
        }
        else
        {
            javax.swing.JOptionPane.showMessageDialog(padre, "A ocurrido un error!!");
        }
        img=null;
        player.close();
        //player.deallocate();
     }
    
    
}