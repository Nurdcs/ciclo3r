package controlador;
import com.mysql.cj.x.protobuf.MysqlxExpect;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Conexion {
 Connection cnn;
 
 public Connection conexionbd(){
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         try {
             cnn=DriverManager.getConnection("jdbc:mysql://localhost/tiendagenerica","root","");
             JOptionPane.showMessageDialog(null, "Conexion ok");
         
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error en la url" +ex);
         }
         
    } 
     catch (ClassNotFoundException ex) {
         JOptionPane.showMessageDialog(null,"error por driver"+ ex);
     }
  
     
     return cnn;
 }
 
 /*public static void main(String[]arg){
     Conexion con=new Conexion();
     con.conexionbd();
 }*/
 
}
  
    
    

