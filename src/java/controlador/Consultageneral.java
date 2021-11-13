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
import modelo.UsuariosDAO;
import modelo.UsuriosDTO;

/**
 *
 * @author nyral
 */
@WebServlet(name = "Consultageneral", urlPatterns = {"/Consultageneral"})
public class Consultageneral extends HttpServlet {

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
        if(request.getParameter("btnconsulta")!=null){
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Consultageneral</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Uusraio</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Cedula</th>");
              out.println("<th>Email</th>");
              out.println("<th>nombre</th>");
              out.println("<th>Password</th>");
              out.println("<th>Uusraio</th>");
              out.println("</tr>");
              
                ArrayList<UsuriosDTO> lista=new ArrayList<>();
                UsuriosDTO usu=new UsuriosDTO();
                UsuariosDAO usdao=new UsuariosDAO();
                lista=usdao.consultar();
                for(int i=0; i<lista.size();i++){
                usu=lista.get(i);
                    
                    
               
              
              out.println("<tr>");
              out.println("<td>"+usu.getCedula()+"</td>");
              out.println("<td>"+usu.getEmail()+"</td>");
              out.println("<td>"+usu.getNombre()+"</td>"); 
              out.println("<td>"+usu.getPassword()+"</td>");
              out.println("<td>"+usu.getUsuario()+"</td>");
                    
             
              out.println("</tr>");  
              
               }
              out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
        }
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
