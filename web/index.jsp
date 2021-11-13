
<%@page import="java.sql.*"%>
<%@page import="controlador.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <%
    String c="",e="",n="",p="",u="";    
     if(request.getParameter("cedu")!=null){    
  
      
        c=request.getParameter("cedu");
        e=request.getParameter("em");
        n=request.getParameter("no");
        p=request.getParameter("pa");
        u=request.getParameter("us");
      
          }
      
      
      
      %>  
        
        
        
        
        
        <h1>Gestión Usuario</h1>
        <form action="Uusuario" method="post">
            <input type="text" name="ced"  value="<%=c%>">
            <input type="text" name="emi" value="<%=e%>">
            <input type="text" name="nom" value="<%=n%>" >
            <input type="text" name="pas"  value="<%=p%>">
            <input type="text" name="usu" value="<%=u%>" >
            <input type="submit" name="btnins" value="Registrar">
            <input type="submit" name="btnact" value="Actualizar">
            <input type="submit" name="btneli" value="Eliminar">
            <input type="submit" name="btncon" value="Consultar">
            </form>
            
            
            <form action="Consultageneral">
            <input type="submit" name="btnconsulta" value="Consultar General">  
                
            </form>


        <% 
          Conexion con=new Conexion();
          Connection cnn=con.conexionbd();
          
        
        
        
        
        %>
        
    </body>
</html>
