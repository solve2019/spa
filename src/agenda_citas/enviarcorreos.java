/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda_citas;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
/**
 *
 * @author desarrollo8
 */
public class enviarcorreos {
    
    public void correo(){
        Date fecha = new Date();
        SimpleDateFormat formatear=new SimpleDateFormat("yyyy-MM-dd");
        String hoy=formatear.format(fecha);
        Date diasig=sumarRestarDiasFecha(fecha,1);
        String manana=formatear.format(diasig);
        
        ConexionBD con=new ConexionBD();
        ResultSet rs=null;
        try {     
            Connection c=con.conectar(); //establece la conexion con la BD
            PreparedStatement guardarStmt = c.prepareStatement("select * from to_notificaciones where fecha='"+hoy+"'");       
            rs=guardarStmt.executeQuery();
            boolean enviar=false;
            if(rs.next()){
                enviar=true;
            }            
            if(enviar==false){//se envia el correo con las notificaciones de citas                
                guardarStmt = c.prepareStatement("select concat(nombre,' ', apaterno,' ',amaterno) as nombre, correo,nota,fecha_inicia from to_agenda,tc_empleados where id_empleado=idr_cliente and to_agenda.estatus=1 and fecha='"+manana+"'");       
                rs=guardarStmt.executeQuery();
                while(rs.next()){
                    Date fechaini=rs.getDate("fecha_inicia");
                    SimpleDateFormat formatearanio=new SimpleDateFormat("yyyy");
                    String anio=formatearanio.format(fechaini);
                    SimpleDateFormat formatearmes=new SimpleDateFormat("MM");
                    String mes=formatearmes.format(fechaini);
                    if(mes.equals("1")){
                        mes="Enero";
                    }
                    if(mes.equals("2")){
                        mes="Febrero";
                    }
                    if(mes.equals("3")){
                        mes="Marzo";
                    }
                    if(mes.equals("4")){
                        mes="Abril";
                    }
                    if(mes.equals("5")){
                        mes="Mayo";
                    }
                    if(mes.equals("6")){
                        mes="Junio";
                    }
                    if(mes.equals("7")){
                        mes="Julio";
                    }
                    if(mes.equals("8")){
                        mes="Agosto";
                    }
                    if(mes.equals("9")){
                        mes="Septiembre";
                    }
                    if(mes.equals("10")){
                        mes="Octubre";
                    }
                    if(mes.equals("11")){
                        mes="Noviembre";
                    }
                    if(mes.equals("12")){
                        mes="Diciembre";
                    }
                    
                    SimpleDateFormat formateardia=new SimpleDateFormat("dd");
                    String dia=formateardia.format(fechaini);
                    String fecd=dia+" de "+mes+" del "+anio;
                    
                    System.out.println(""+fecd);
                    SimpleDateFormat formatearhora=new SimpleDateFormat("hh:mm");
                    String hora=formatearhora.format(fechaini);
                    notifica(rs.getString("nombre"),rs.getString("correo"),rs.getString("nota"),fecd,hora);
                    PreparedStatement guardarStmt2 = c.prepareStatement("insert into to_notificaciones (fecha,fecha_envio) values(now(),now())");       
                    guardarStmt2.executeUpdate();
                }
            }
            //System.out.println(""+enviar);
            guardarStmt.close();          
            con.desconectar();
        } catch (SQLException ex) {     
        System.err.println("Error al guardar los datos de la huella.");
        }finally{
        con.desconectar();
        }
                
    }
    
// Suma los días recibidos a la fecha  
 public Date sumarRestarDiasFecha(Date fecha, int dias){
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha); // Configuramos la fecha que se recibe
      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
 }

 
 public void notifica(String nombre,String correo,String nota, String fecha,String hora){
     ConexionBD con=new ConexionBD();
        ResultSet rs=null;
        String footer="";
        try {     
            Connection c=con.conectar(); //establece la conexion con la BD
            PreparedStatement guardarStmt = c.prepareStatement("select parametro from to_parametros where clave='FOTTERNOTIFICACION'");       
            rs=guardarStmt.executeQuery();            
            if(rs.next()){
                footer=rs.getString("parametro");
            }                        
            guardarStmt.close();          
            con.desconectar();
        } catch (SQLException ex) {     
        System.err.println("Error al guardar los datos de la huella.");
        }finally{
        con.desconectar();
        }
     
     
     nota="<center><h1 style='color: #5e9ca0;'>"+nombre.toUpperCase()+"</h1><center><p><font size='3'>Te esperamos este "+fecha+" a las "+hora+"hrs. para realizar <b>"+nota.toUpperCase()+"</b></font></p>"
        + ""+footer;
        String usuarioEmisorMensaje = "facturacion@solvemorelos.com.mx";        
        String passwordEmisorMensaje = "Solve_1234";        
        String smtpHost = "mail.solvemorelos.com.mx";        
        String smtpPuerto = "26";  //25        
        String smtpAuth = "true";
        Properties props = new Properties();
         //Asiganamos algunas propiedades
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.port", smtpPuerto);
            props.put("mail.smtp.auth", smtpAuth);
            props.put("mail.smtp.starttls.enable", "true");

            //Se obtiene una sesión con las propiedades anteriormente que hemos
            //guardado en -props-
            Session sesion = Session.getDefaultInstance(props, null);

            try {
                //Empezamos a crear el e-mail
                Message mensaje = new MimeMessage(sesion);
                //Rellenamos los campos necesarios de un e-mail
                
                //El asunto
                mensaje.setSubject("Recordatorio de Cita");
                // Emisor del mensaje
                mensaje.setFrom(new InternetAddress("facturacion@solvemorelos.com.mx"));



                String[] corre=correo.split(",");
                System.out.println("numero de correos: "+corre.length);

                Address [] receptores = new Address [corre.length];
                for(int i=0;i<receptores.length;i++){
                    receptores[i]=new InternetAddress(corre[i].trim());
                }
              



                //Agregamos la lista de los receptores.
                mensaje.addRecipients(Message.RecipientType.TO, receptores);
                //Aquí va el contenido del mensaje
                mensaje.setText(nota);
                mensaje.setContent(nota, "text/html; charset=utf-8");
                //Ahora vamos a enviar el mensaje
                Transport t = sesion.getTransport("smtp");
                //Pero antes tenemos que auntenticarnos con una cuenta real de
                
                t.connect(usuarioEmisorMensaje, passwordEmisorMensaje);
                if(corre.length>0){
                    t.sendMessage(mensaje, mensaje.getRecipients(Message.RecipientType.TO));
                }
            }catch(MessagingException e) {
                System.err.println(e.getMessage());
            }
        
 }
 
}
