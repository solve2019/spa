/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados;
import com.mysql.jdbc.PreparedStatement;
import conex.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc; 
import javax.print.DocFlavor; 
import javax.print.DocPrintJob; 
import javax.print.PrintService; 
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc; 
import javax.swing.JOptionPane; 


import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author desarrollo8
 */
public class Ticket{
	
static ArrayList<String> CabezaLineas=new ArrayList<String>(); 
static ArrayList<String> subCabezaLineas=new ArrayList<String>(); 
static ArrayList<String> items=new ArrayList<String>(); 
static ArrayList<String> totales=new ArrayList<String>(); 
static ArrayList<String> LineasPie=new ArrayList<String>(); 
public static void AddCabecera(String line){CabezaLineas.add(line);} 
public static void AddSubCabecera(String line){subCabezaLineas.add(line);} 
public static void AddItem(String cantidad,String item,String price){  
} 


public void ReImprimirDocumento(String socio,String monto,String fechavence,String descripcionservicio){
	String encabezado="",footer="";
        
        
        
	conexion cn = new conexion();
	String sql="SELECT parametro from to_parametros where clave='ENCABEZADO'";
	System.out.println(sql);
	PreparedStatement pstm100;
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {
	    	
	    	encabezado=rs100.getString("parametro");	    		    			   
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	sql="SELECT parametro from to_parametros where clave='FOOTER'";
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {
	    	
	    	footer=rs100.getString("parametro");	    		    			   
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        cn.desconectar();
	
	
        
        encabezado=encabezado+"\n  PAGO DE SPA";
	//footer="\n   Gracias por su preferencia";
	
char as=29;  //gs
char ew1=66;
char w=80;

Date date = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
System.out.println("Fecha: "+dateFormat.format(date));

String a=encabezado;	   
	   a=a+"\n\n ===============================\n";
           a=a+"   Fecha:  "+dateFormat.format(date)+"\n\n";
	   a=a+"   Cliente:  "+socio+"\n";           
           a=a+"   Session:  "+descripcionservicio+"\n"; 
           a=a+"   Monto:  "+monto+"\n\n\n";
           
	   		   
	   
	   

	   char esc=27;
	   char b=20;
	   char c=1;
	   char d=226;
	   char e1=0;
	   char f=70;
	   char g=56;
	   char h=29;
	   char i=1;
	   char j=120;
	   char k=0;
	   char l=4;
	   char m=28;

	   
	   
/*	   
char ss=15;
a=a+h+"h"+j;
a=a+h+"w"+i;
a=a+h+"k"+l+"2345345345"+k;
a=a+esc+m;
//fin codigo barras
*/
           
a=a+"\n ===============================\n"+footer+"\n";
a=a+as+"V"+ew1+w;//corta el papel
a=a+(char)27+(char)112+(char)0+(char)25+(char)250;  //abre cajon dinero por rj11


System.out.println(a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 
}



public void imprimirentrada(String socio,String tratamiento){
	String encabezado="",footer="";
        
        
        
	conexion cn = new conexion();
	String sql="SELECT parametro from to_parametros where clave='ENCABEZADO'";
	System.out.println(sql);
	PreparedStatement pstm100;
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {
	    	
	    	encabezado=rs100.getString("parametro");	    		    			   
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	sql="SELECT parametro from to_parametros where clave='FOOTER'";
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {
	    	
	    	footer=rs100.getString("parametro");	    		    			   
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        cn.desconectar();
	
	
        
        encabezado="\n\n\n  INGRESO AL SPA";
	//footer="\n   Gracias por su preferencia";
	
char as=29;  //gs
char ew1=66;
char w=80;

Date date = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
System.out.println("Fecha: "+dateFormat.format(date));

String a=encabezado;	   
	   a=a+"\n\n ===============================\n";
           a=a+"   Fecha:  "+dateFormat.format(date)+"\n\n";
	   a=a+"   Cliente:  "+socio+"\n";           
           a=a+"   Session:  "+tratamiento+"\n\n";            
           
	   		   
	   	 
	   char esc=27;
	   char b=20;
	   char c=1;
	   char d=226;
	   char e1=0;
	   char f=70;
	   char g=56;
	   char h=29;
	   char i=1;
	   char j=120;
	   char k=0;
	   char l=4;
	   char m=28;

	   
	   
/*	   
char ss=15;
a=a+h+"h"+j;
a=a+h+"w"+i;
a=a+h+"k"+l+"2345345345"+k;
a=a+esc+m;
//fin codigo barras
*/
           
a=a+"\n ===============================\n"+footer+"\n\n";
a=a+as+"V"+ew1+w;//corta el papel
a=a+(char)27+(char)112+(char)0+(char)25+(char)250;  //abre cajon dinero por rj11


System.out.println(a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 
}



} 

