package modelo;

import java.sql.*;
import controlador.Conexion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class UsuariosDAO {
   Conexion con=new Conexion();
   Connection cnn=con.conexionbd();
   PreparedStatement ps;
   ResultSet rs;
   UsuriosDTO usu;
   
   
   public boolean  insertarusuario(UsuriosDTO us){
       boolean dato=false;
        
       try {
           ps=cnn.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?)");
           
           ps.setLong(1, us.getCedula());
           ps.setString(2, us.getEmail());
           ps.setString(3, us.getNombre());
           ps.setString(4, us.getPassword());
           ps.setString(5, us.getUsuario());
           
         if(  ps.executeUpdate()>0){
             dato=true;
         }
           
           
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al insertar ususraio "+ex);
       }
       
       return  dato;
   }
   
   
   
   public boolean  Actualizarusuario(UsuriosDTO us){
       
     boolean dato=false;
        
       try {
           ps=cnn.prepareStatement("UPDATE usuarios SET email_usuario=?,"
                   + "nombre_usuario=?,password_usuario=?,usuario=? WHERE cedula_usuario=?");
           

           ps.setString(1, us.getEmail());
           ps.setString(2, us.getNombre());
           ps.setString(3, us.getPassword());
           ps.setString(4, us.getUsuario());
           ps.setLong(5, us.getCedula());
           
         if(  ps.executeUpdate()>0){
             dato=true;
         }
       
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al insertar ususraio "+ex);
       }
       
       return  dato;  
       
       
   }
    
   
       public boolean eliminarusuario(UsuriosDTO us){
       boolean dat=false;
       
       try {
           ps=cnn.prepareStatement("DELETE  FROM usuarios WHERE cedula_usuario=?");
           ps.setLong(1, us.getCedula());
           
          if( ps.executeUpdate()>0){
              dat=true;
          }
       } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Error al eliminar ususraios "+ex);

       }
       
       return  dat;
   }
      public UsuriosDTO  consultarusuario(UsuriosDTO us){
       try {
           ps=cnn.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
           ps.setLong(1, us.getCedula());
           rs=ps.executeQuery();
           if(rs.next()){
             usu=new UsuriosDTO(rs.getLong(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5));
               
           }
       } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al consultar ususraio "+ex);

       }
          return  usu;
       }
      
      
      
      public ArrayList<UsuriosDTO> consultar(){
        ArrayList<UsuriosDTO>  lista=new ArrayList<>();
       try {
           ps=cnn.prepareStatement("SELECT * FROM usuarios");
           rs=ps.executeQuery();
           while(rs.next()){
                usu=new UsuriosDTO(rs.getLong(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5));
                lista.add(usu);
                
           }
           
           
           
       } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al consultar ususraio general "+ex);
       }
          
         return lista;
      }
       
       
       
    
}
