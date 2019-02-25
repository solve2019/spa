/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conex;
import java.sql.*;
/**
 *
 * @author JOSE
 */
public class conexion {
 public static String bd = "spa";
 public static String login = "root";
 public static String password = "root";
 public static String url = "jdbc:mysql://localhost:3306/"+bd;

   Connection conn = null;

   public conexion(){
       try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("Conección a base de datos "+bd+" OK");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
    
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
   }
}

