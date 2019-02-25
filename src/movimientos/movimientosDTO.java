/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package movimientos;

/**
 *
 * @author JOSE
 */
public class movimientosDTO {
  String id_mov;
  String nombre;
  String fecha_entrada;
  String fecha_salida;
  String clave;
    public movimientosDTO() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    
    public String getId_mov() {
        return id_mov;
    }

    public void setId_mov(String id_mov) {
        this.id_mov = id_mov;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    
}
