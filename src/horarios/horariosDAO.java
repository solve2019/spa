/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package horarios;

import conex.conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class horariosDAO {
    conexion con;
    private Statement st;
    private ResultSet resultado;
    
    public ResultSet obtenerHorarios() throws Exception{
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

    public void registrahorario(String nombre,String horaini, String horafin, int tolerancia) throws Exception{
        try{
            con = new conexion();
            st = con.getConnection().createStatement();
            String sentencia="insert into tc_horarios (nombre, hora_ini, hora_fin, tiempo_tolerancia)"
            + " values(UPPER('"+nombre+"'),'"+horaini+"','"+horafin+"','"+tolerancia+"')";
            st.executeUpdate(sentencia);            
            con.desconectar();
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"No se pudo registrar el horario: "+ex); throw ex;
        }
    }
    
     public void modificahorario(String idhorario,String nombre,String horaini, String horafin, int tolerancia) throws Exception{
        try{
            con = new conexion();
            st = con.getConnection().createStatement();
            String sentencia="update tc_horarios set nombre=UPPER('"+nombre+"'), hora_ini='"+horaini+"', hora_fin='"+horafin+"', tiempo_tolerancia='"+tolerancia+"' where id_horario="+idhorario;            
            st.executeUpdate(sentencia);            
            con.desconectar();
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"No se pudo registrar el horario: "+ex); throw ex;
        }
    }
    
    
}
