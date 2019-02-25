/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package movimientos;

import conex.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSE
 */
public class movimientosDAO {
    conexion con;
    private Statement st;
    private ResultSet resultado;
    
    
    public ResultSet obtenerUltimoComent(String id) throws Exception{
        java.util.Date utilDate = new java.util.Date(); //fecha actual
        long lnMilisegundos = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos); //fecha actual
        try{
            con = new conexion();
            st = con.getConnection().createStatement();
            String sentencia="SELECT comentario from to_pagos where idr_empleado='"+id+"'";
            resultado = st.executeQuery(sentencia);                        
            con.desconectar();
            return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener el comentario: "+ex); throw ex;
        }
    }
    
    
    public ResultSet obtenerMovimiento() throws Exception{
        java.util.Date utilDate = new java.util.Date(); //fecha actual
        long lnMilisegundos = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos); //fecha actual
        try{
            con = new conexion();
            st = con.getConnection().createStatement();
            String sentencia="SELECT * from to_movimientos where fecha_movimiento='"+sqlDate+"' and fecha_salida is null";
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
    
    
    
    public ResultSet obtenerMovimientoFechas(String fechaini, String fechafin) throws Exception{
        java.util.Date utilDate = new java.util.Date(); //fecha actual
        long lnMilisegundos = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos); //fecha actual
        try{
            con = new conexion();
            st = con.getConnection().createStatement();
            String sentencia="SELECT fecha_entrada, to_movimientos.nombre, motivo, tc_usuarios.nombre as usuario,comision from to_movimientos, tc_usuarios where idusuario=idrusuario and fecha_entrada>='"+fechaini+" 00:00:00' and fecha_entrada<='"+fechafin+" 23:59:59'";
            System.out.println(sentencia);
            resultado = st.executeQuery(sentencia);            
            
                con.desconectar();
                return resultado;
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"problemas en el metodo Obtener movimientos: "+ex); throw ex;
        }
    }
    
    
    public ResultSet obtenerSalidas() throws Exception{
        java.util.Date utilDate = new java.util.Date(); //fecha actual
        long lnMilisegundos = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos); //fecha actual
        try{
            con = new conexion();
            st = con.getConnection().createStatement();
            String sentencia="SELECT * from to_movimientos where fecha_movimiento='"+sqlDate+"' and fecha_salida is not null";
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
}
