/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empleados;
import checador.accesoSistema;
import conex.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author JOSE
 */
public class empleadosDAO {
    conexion con;
    private Statement st;
    private ResultSet resultado;
    
    
    
    public void eliminarprecios(String id) throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="update tc_costos_gym  set estatus=0 where Id="+id;
            System.out.println(sentencia);
            st.executeUpdate(sentencia);  
            JOptionPane.showMessageDialog(null,"El registro se elimino correctamente.","Alerta",JOptionPane.INFORMATION_MESSAGE);
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();          
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas al registrar: "+ex); throw ex;
        }
    }
    
    public void guardarcita(String idusuario, String idcliente,String fechaini,String fechafin,String nota) throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="insert into to_agenda (fecha,nota,fecha_inicia,idr_cliente,fecha_finaliza,idruser) values ('"+fechaini+"','"+nota+"','"+fechaini+"','"+idcliente+"','"+fechafin+"','"+idusuario+"')";
            System.out.println(sentencia);
            st.executeUpdate(sentencia);  
            JOptionPane.showMessageDialog(null,"Se registro la cita correctamente.","Alerta",JOptionPane.INFORMATION_MESSAGE);
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();          
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas al registrar: "+ex); throw ex;
        }
    }
    
    
    public void borrarcita(String idcita) throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="update to_agenda set estatus=0, fechaelimino=now(), usuarioelimino='"+accesoSistema.nombreuser+"' where id_agenda='"+idcita+"'";
            System.out.println(sentencia);
            st.executeUpdate(sentencia);  
            JOptionPane.showMessageDialog(null,"Se elimino la cita correctamente.","Alerta",JOptionPane.INFORMATION_MESSAGE);
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();          
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas al eliminar citas: "+ex); throw ex;
        }
    }
    
    public void gurdarprecios(String nombre, String costo,String tipocobro,String diames,String comision) throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="insert into tc_costos_gym (nombre,costo,estatus,numeromeses,tipo,comision) values ('"+nombre+"','"+costo+"',1,'"+diames+"','"+tipocobro+"','"+comision+"')";
            System.out.println(sentencia);
            st.executeUpdate(sentencia);  
            JOptionPane.showMessageDialog(null,"Se inserto el monto a cobrar.","Alerta",JOptionPane.INFORMATION_MESSAGE);
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();          
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas al registrar: "+ex); throw ex;
        }
    }
    
    public void modificarprecio(String costo,String comision,String id) throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="update tc_costos_gym  set costo='"+costo+"',comision='"+comision+"' where Id='"+id+"'";
            System.out.println(sentencia);
            st.executeUpdate(sentencia);  
            JOptionPane.showMessageDialog(null,"Se modifico el monto a cobrar.","Alerta",JOptionPane.INFORMATION_MESSAGE);            
                con.desconectar();          
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas al modificar: "+ex); throw ex;
        }
    }
    
    public void gurdarpagos(String nombre, String costo,String comentario) throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="insert into tc_pago_proveedor (montoPago,Fechapago,usuarioregistro,observacion,idrproveedor) values ('"+costo+"',now(),'"+accesoSistema.nombreuser+"','"+comentario+"',"+nombre+")";
            System.out.println(sentencia);
            st.executeUpdate(sentencia);  
            JOptionPane.showMessageDialog(null,"Se agrego el pago.","Alerta",JOptionPane.INFORMATION_MESSAGE);
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();          
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas al registrar: "+ex); throw ex;
        }
    }
    
    
    public void gurdarproveedor(String nombre, String costo) throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="insert into tc_proveedores (nombre,fechaalta,comentario) values ('"+nombre+"',now(),'"+costo+"')";
            System.out.println(sentencia);
            st.executeUpdate(sentencia);  
            JOptionPane.showMessageDialog(null,"Se inserto el proveedor.","Alerta",JOptionPane.INFORMATION_MESSAGE);
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();          
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas al registrar: "+ex); throw ex;
        }
    }
    public ResultSet obtenzonaspaquete(String idpaquete) throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="SELECT to_paquetes.Id, tc_costos_gym.nombre from to_paquetes, tc_costos_gym where id_zona=tc_costos_gym.Id and idpago='"+idpaquete+"'";
            System.out.println(sentencia);
            resultado = st.executeQuery(sentencia);            
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener movimientos: "+ex); throw ex;
        }
    }
    
    public ResultSet obtenprecios() throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="SELECT * from tc_costos_gym where estatus=1";
            System.out.println(sentencia);
            resultado = st.executeQuery(sentencia);            
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener movimientos: "+ex); throw ex;
        }
    }
    
     public ResultSet obtencitasuser(String fechaini, String iduser, String fechafin) throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            //String sentencia="SELECT fecha_inicia,fecha_finaliza,nota,id_agenda, concat(nombre,' ',apaterno,' ',amaterno) as cliente from to_agenda,tc_empleados where to_agenda.estatus=1 and id_empleado=idr_cliente and fecha_inicia>='"+fechaini+"' and fecha_finaliza<='"+fechafin+"' and idruser='"+iduser+"'";
            String sentencia="SELECT fecha_inicia,fecha_finaliza,nota,id_agenda, concat(nombre,' ',apaterno,' ',amaterno) as cliente from to_agenda,tc_empleados where to_agenda.estatus=1 and id_empleado=idr_cliente and fecha_inicia>='"+fechaini+"' and fecha_finaliza<='"+fechafin+"'";
            System.out.println(sentencia);
            resultado = st.executeQuery(sentencia);                       
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener movimientos: "+ex); throw ex;
        }
    }
    public ResultSet obtencitas(String fechaini, String iduser, String fechafin) throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="SELECT concat(nombre,' ',apaterno,' ',amaterno,' ',nota,' -',id_agenda) as cliente from to_agenda,tc_empleados where id_empleado=idr_cliente and fecha_inicia>='"+fechaini+"' and fecha_finaliza<='"+fechafin+"' and idruser='"+iduser+"'";
            System.out.println(sentencia);
            resultado = st.executeQuery(sentencia);                       
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener movimientos: "+ex); throw ex;
        }
    }
    
    public ResultSet obtenusuarioagenda() throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="SELECT idusuario,nombre from tc_usuarios where estatus=1";
            System.out.println(sentencia);
            resultado = st.executeQuery(sentencia);            
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener movimientos: "+ex); throw ex;
        }
    }
    
    
    public ResultSet obtenclientes() throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="SELECT id_empleado,concat(nombre,' ',apaterno,' ',amaterno) as cliente from tc_empleados where estatus=1";
            System.out.println(sentencia);
            resultado = st.executeQuery(sentencia);            
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener movimientos: "+ex); throw ex;
        }
    }
    
    
    public ResultSet obtenproveedor() throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="SELECT * from tc_proveedores";
            System.out.println(sentencia);
            resultado = st.executeQuery(sentencia);            
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener movimientos: "+ex); throw ex;
        }
    }
    
    
    public ResultSet obtenpagos() throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="SELECT Idpagoprovedor,Fechapago,nombre,montoPago,observacion from tc_pago_proveedor,tc_proveedores where Idproveedor=idrproveedor order by Fechapago desc";
            System.out.println(sentencia);
            resultado = st.executeQuery(sentencia);            
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener movimientos: "+ex); throw ex;
        }
    }
    
    public ResultSet obtensesiones(String idcliente) throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="SELECT Idpago, sesiones_realizadas, tratamiento,comision from to_pagos, tc_costos_gym where Id=idr_costo and sesiones_realizadas>0 and idr_empleado='"+idcliente+"'";
            System.out.println(sentencia);
            resultado = st.executeQuery(sentencia);            
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener movimientos: "+ex); throw ex;
        }
    }
    
    public ResultSet obtenerEmpleados() throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="SELECT id_empleado,nombre,apaterno,amaterno,TIMESTAMPDIFF(YEAR,fecha_nacimiento,CURDATE()) AS edad,telefono,correo,fecha_registro,fecha_vencimiento, datediff(fecha_vencimiento,now()) as fecha from tc_empleados where estatus=1";
            System.out.println(sentencia);
            resultado = st.executeQuery(sentencia);            
            /*ArrayList<movimientosDTO> lista = new ArrayList<movimientosDTO>() {};
                while (resultado.next())
                {
                   movimientosDTO ope=new movimientosDTO();
                   ope.setId_mov(resultado.getString("id_mov"));
                   ope.setNombre(resultado.getString("nombre"));
                   ope.setFecha_entrada(resultado.getString("fecha_entrada"));
                   ope.setFecha_salida(resultado.getString("fecha_salida"));
                   ope.setClave(resultado.getString("clave"));
                   
                   lista.add(ope);
                }
               */
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener movimientos: "+ex); throw ex;
        }
    }
    
    public ResultSet obtenempleados() throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="SELECT * from tc_empleados";
            resultado = st.executeQuery(sentencia);            
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener horarios: "+ex); throw ex;
        }
    }
    
    public ResultSet obtenhorarios() throws Exception{
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
            String sentencia="SELECT * from tc_horarios";
            resultado = st.executeQuery(sentencia);            
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener horarios: "+ex); throw ex;
        }
    }
    
    public boolean registraemp(String nombre,String paterno, String materno,String clave,String horaini,String horafin,int tolerancia, int rmenor, int rmayor, String plaza,String codigo,String telefono,String correo,String fechanacimiento) throws Exception{
        boolean registro=false;
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
             
        boolean valida=false;
        ResultSet res;
        try{
            con = new conexion();
            st = con.getConnection().createStatement();
            String sentencia="SELECT * from tc_empleados where clave='"+clave+"'";
            res = st.executeQuery(sentencia);
            while(res.next()){
                valida=true;                             
            }
            res.close();
            con.desconectar();
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener horarios: "+ex);
        }
             
              valida=false;     
            if(valida==false){  //no existe la clave          
                String sentencia="insert into tc_empleados (nombre, apaterno, amaterno, fecha_registro, estatus, clave, hora_ini, hora_fin, tiempo_tolerancia,retardo_menor,retardo_mayor,plaza,codigo,telefono,correo,fecha_nacimiento,fecha_vencimiento)"
                + " values(UPPER('"+nombre+"'),UPPER('"+paterno+"'),UPPER('"+materno+"'),now(),1,'"+clave+"','"+horaini+"','"+horafin+"','"+tolerancia+"','"+rmenor+"','"+rmayor+"',UPPER('"+plaza+"'),UPPER('"+codigo+"'),'"+telefono+"','"+correo+"','"+fechanacimiento+"',now())";
                st.executeUpdate(sentencia);            
                con.desconectar();
                JOptionPane.showMessageDialog(null,"Socio registrado correctamente ");
                registro=true;
            }else{                
                JOptionPane.showMessageDialog(null,"Ya existe la clave en otro socio favor de verificar","Alerta",JOptionPane.ERROR_MESSAGE);
                registro=false;
            }
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"No se pudo registrar el socio: "+ex,"Error",JOptionPane.ERROR_MESSAGE);                
                registro=false;
        }
        return registro;
    }
    
    public boolean registraentrada(String id,Date fecha, String motivo, String observaciones,String nombre, String rfc) throws Exception{
        boolean registro=false;
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
             SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
          
                String horaini="",horafin="";
                String sentencia="SELECT * from tc_empleados where id_empleado='"+id+"'";
                ResultSet res = st.executeQuery(sentencia);
                while(res.next()){
                        horaini=res.getString("hora_ini");
                        horafin=res.getString("hora_fin");
                }
                res.close();
             
                sentencia="insert into to_movimientos (id_emp,nombre,fecha_entrada,clave,fecha_movimiento,hora_entrada,tiempo_retarno,retardo,semanal,fecha_salida,hora_salida,motivo,observaciones) values('"+id+"','"+nombre+"','"+formato.format(fecha)+" "+horaini+"','"+rfc+"',now(),'"+formato.format(fecha)+" "+horaini+"','0','0','0','"+formato.format(fecha)+" "+horafin+"','"+formato.format(fecha)+" "+horafin+"','"+motivo+"','"+observaciones+"')";
                System.out.println(""+sentencia);
                st.executeUpdate(sentencia);            
                con.desconectar();
                JOptionPane.showMessageDialog(null,"Entrada registrada correctamente ");
                registro=true;
            
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"No se pudo registrar la entrada: "+ex,"Error",JOptionPane.ERROR_MESSAGE);                
                registro=false;
        }
        return registro;
    }
    
    public boolean editaemp(String idemp,String nombre,String paterno, String materno,String clave,String horaini, String horafin, int tolerancia, int rmenor, int rmayor,String plaza,String codigo,String telefono,String correo,String fechanacimiento) throws Exception{
        boolean registro=false;
        try{
             con = new conexion();
             st = con.getConnection().createStatement();
             
        boolean valida=false;
        ResultSet res;
        try{
            con = new conexion();
            st = con.getConnection().createStatement();
            String sentencia="SELECT * from tc_empleados where clave='"+clave+"' and id_empleado!="+idemp;
            res = st.executeQuery(sentencia);
            while(res.next()){
                valida=true;                             
            }
            res.close();
            con.desconectar();
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener daros: "+ex);
        }
             
            valida=false;   
            if(valida==false){  //no existe la clave          
                String sentencia="update tc_empleados set fecha_nacimiento='"+fechanacimiento+"', correo='"+correo+"', telefono='"+telefono+"', codigo=UPPER('"+codigo+"'), plaza=UPPER('"+plaza+"'), nombre=UPPER('"+nombre+"'), apaterno=UPPER('"+paterno+"'), amaterno=UPPER('"+materno+"'), clave='"+clave+"', hora_ini='"+horaini+"', hora_fin='"+horafin+"', tiempo_tolerancia='"+tolerancia+"', retardo_menor='"+rmenor+"', retardo_mayor='"+rmayor+"' where id_empleado="+idemp;                
                st.executeUpdate(sentencia);            
                con.desconectar();
                JOptionPane.showMessageDialog(null,"Socio modificado correctamente ");
                registro=true;
            }else{                
                JOptionPane.showMessageDialog(null,"Ya existe la clave del socio favor de verificar","Alerta",JOptionPane.ERROR_MESSAGE);
                registro=false;
            }
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"No se pudo modificar al socio: "+ex,"Error",JOptionPane.ERROR_MESSAGE);                
                registro=false;
        }
        return registro;
    }
    
}
