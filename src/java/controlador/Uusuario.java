/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.UsuariosDAO;
import modelo.UsuriosDTO;

/**
 *
 * @author nyral
 */
@WebServlet(name = "Uusuario", urlPatterns = {"/Uusuario"})
public class Uusuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
      
         if(request.getParameter("btnins")!=null){
             this.insertar(request, response);
         }
         
          if(request.getParameter("btnact")!=null){
             this.actualizar(request, response);
         }
          
           if(request.getParameter("btneli")!=null){
             this.eliminar(request, response);
         }
           
            if(request.getParameter("btncon")!=null){
             this.consultarusuario(request, response);
         }
           
         
             
    }
    
    
   protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         
         String e,n,p,u;
         long c;
         boolean x;
         c=Long.parseLong( request.getParameter("ced"));
         e=request.getParameter("emi");
         n=request.getParameter("nom");
         p=request.getParameter("pas");
         u=request.getParameter("usu");
         
         UsuriosDTO usu=new UsuriosDTO(c, e, n, p, u);
         UsuariosDAO usdao=new UsuariosDAO();
         x=usdao.insertarusuario(usu);
         if(x==true){
             JOptionPane.showMessageDialog(null, "Dataos guardados");
             response.sendRedirect("menuprincipal.jsp");
         }
         
         else{
                JOptionPane.showMessageDialog(null, "Dataos NO guardados");
                 response.sendRedirect("index.jsp");
            }
                 
  
    }
 
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         
         
         long c;
         boolean x;
         c=Long.parseLong( request.getParameter("ced"));
         
         
         UsuriosDTO usu=new UsuriosDTO(c);
         UsuariosDAO usdao=new UsuariosDAO();
         x=usdao.eliminarusuario(usu);
         if(x==true){
             JOptionPane.showMessageDialog(null, "Dataos Eliminadi");
              response.sendRedirect("menuprincipal.jsp");
         }
         
         else{
                JOptionPane.showMessageDialog(null, "Dataos NO Eliminado");
                   response.sendRedirect("index.jsp");
            }
                 
  
    }
 
 protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         
         String e,n,p,u;
         long c;
         boolean x;
         c=Long.parseLong( request.getParameter("ced"));
         e=request.getParameter("emi");
         n=request.getParameter("nom");
         p=request.getParameter("pas");
         u=request.getParameter("usu");
         
         UsuriosDTO usu=new UsuriosDTO(c, e, n, p, u);
         UsuariosDAO usdao=new UsuariosDAO();
         x=usdao.Actualizarusuario(usu);
         if(x==true){
             JOptionPane.showMessageDialog(null, "Dataos actualizar");
             
              response.sendRedirect("menuprincipal.jsp");
         }
         
         else{
                JOptionPane.showMessageDialog(null, "Dataos NO actualizado");
            }
                 
  
    }
 
 
 
 
 protected void consultarusuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         String e,n,p,u;
         long ced;
        
         long c;
         
        
         c=Long.parseLong( request.getParameter("ced"));
         
         JOptionPane.showMessageDialog(null,c);
         UsuriosDTO usdto;
         
         UsuriosDTO usu=new UsuriosDTO(c);
         UsuariosDAO usdao=new UsuariosDAO();
         usdto=usdao.consultarusuario(usu);
         ced=usdto.getCedula();
         e=usdto.getEmail();
         n=usdto.getNombre();
         p=usdto.getPassword();
         u=usdto.getUsuario();
         
         
         response.sendRedirect("index.jsp?em="+e+"&&no="+n+"&&pa="+p+"&&us="+u+"&&cedu="+ced);
         
         
                 
  
    }
 
    
  protected void consulta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         
     
         ArrayList<UsuriosDTO> lista=new ArrayList<>();
         UsuriosDTO usu=new UsuriosDTO();
         UsuariosDAO usdao=new UsuariosDAO();
         lista=usdao.consultar();
         
                 
  
    }  
    
    
    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
