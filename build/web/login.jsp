<%@page import="uml.Usuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center><br><br><br><br><br><br><br> 
        <h1>Formulario de Acceso</h1>
        <hr>
        <form name="frmLogin" action="servUsuarios" method="POST">
            <input type="text" name="txtUsuario" value="" size="30" placeholder="Usuario...."/><br>
            <input type="password" name="txtContra" value="" size="30" placeholder="Contraseña..." />
            <br><br>
            <input type="submit" value="Iniciar Sesion" name="btnIniciar" />
            <input type="submit" value="Cancelar" name="btnCancelar" />
            
            
        </form>
        
        <%  
            HttpSession sesion = request.getSession();
            
            
             List<Usuarios> datos = new ArrayList<Usuarios>();
                if(request.getAttribute("fail")!=null){
                    out.print("<script>alert('Ususario o contra erroneos!');</script>   ");
                }
                if(request.getAttribute("datos")!=null){
                    datos = (List<Usuarios>)request.getAttribute("datos");
                    String nombrecompleto="";
                    int nivel=0;
                    for(Usuarios u : datos){
                        nombrecompleto = u.getNombrecompleto();
                        nivel = u.getNivel();
                    }
                    sesion.setAttribute("usuario", nombrecompleto);
                    sesion.setAttribute("nivel",nivel);
                    response.sendRedirect("vistaPersona.jsp"); 
                }
                if(request.getParameter("cerrar")!=null){
                    sesion.invalidate();
                    response.sendRedirect("login.jsp");
                }

        %>
        
        </center>
    </body>
</html>
