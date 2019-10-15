<%@page import="modelado.DAOPersona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uml.Persona"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<% 

HttpSession ses = request.getSession();
String usuario="";
int nivel=0;

if(ses.getAttribute("usuario")!=null && ses !=null && ses.getAttribute("nivel")!=null){
    usuario = ses.getAttribute("usuario").toString();
    nivel = Integer.parseInt(ses.getAttribute("nivel").toString()); 
    
    if(nivel!=1){
        response.sendRedirect("login.jsp");
    }  
}else{
    response.sendRedirect("login.jsp");
}


%>







<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista Pesona</title>
        <!--ESTE JAVASCRIPT ES PARA CARGAR DE LA TABLA A LOS TEXTOS DEL FORMULARIO -->
        <script lang="JavaScript">
            function cargar(id, nombres, apellidos, edad){
                document.formPersona.txtId.value=id;
                document.formPersona.txtNombres.value=nombres;
                document.formPersona.txtApellidos.value=apellidos;
                document.formPersona.txtEdad.value=edad;
            }
        </script>
        <link rel="stylesheet" type="text/css" href="librerias/bootstrap/css/bootstrap.css">
	<script src="librerias/jquery-3.2.1.min.js"></script>
    </head>
    
     <%
        DAOPersona dao = new DAOPersona();
        List<Persona> datos= new ArrayList();         
    %>
     
    <body>
        
        <pre>Bienvenido <%= usuario %> | nivel Administrador R.R.H.H | <img src="iconos/man.png"> <a href="login.jsp?cerrar=true">Cerrar Sesion</a></pre>
        <hr>
        
        
        
    <center>
        <!-- EL FORMULARIO PARA INGRESO DE DADTOS -->
        <h1>Registro Empleados</h1>
        <form  name="formPersona" method="POST" action="SERVPersona">
            <input type="text" name="txtId" placeholder=" Id de persona" size="30" class="form.control input-sm"><br>
            <input type="text" name="txtNombres" placeholder=" nombres ..." size="30" class="form.control input-sm"><br>
            <input type="text" name="txtApellidos" placeholder="apellidos..." size="30" class="form.control input-sm"><br>
            <input type="text" name="txtEdad" placeholder=" edad ..." size="30" class="form.control input-sm"><br><br>
            <input type="submit" name="btnInsertar" value="Insertar"class="btn btn-primary btn-sm">
            <input type="submit" name="btnModificar" value="Modificar" class="btn btn-success btn-sm">
            <input type="submit" name="btnEliminar" value="Eliminar" class="btn btn-danger btn-sm">   
            <hr>
            <hr>
            Buscar: <input type="text" name="txtCriterio">
            En base a:<input type="text" name="txtCampo" placeholder="nombre,cargo,etc..">
            <input type="submit" name="btnFiltrar" value="Filtrar"> 
             <input type="submit" name="btnReiniciar" value="Reiniciar"> 
        </form>
    <hr>  
        <!-- DISEÑAMOS LA TABLA EN HTML Y LE METEMOS CODIGO JSP -->
        <table border="1px">
             <!-- PRIMERO LOS ENCABEZADOS-->
            <tr>
            <td>ID </td>  <td>NOMBRES</td>  <td>APELLIDOS </td>  <td> EDAD</td><td> ACCION</td>
            </tr>
            <!-- AHORA TODO EL CONTENIDO DE LA TABLA-->
        <% 
          //ESTOS IF SON PAR VER SI SE RECIBEN ATRIBUTOS DEL SERVLET
        //SE ESPERA EL ATRIBUTO FILTRO SI ACASO SE HA FILTRADO
        //SE ESPERA EL ATRIBUTO REINICIO SI ACASO DE REINICIO EL FILTRO
        //DE NO RECIBIR ATRIBUTOS, SOLO CARGA LA TABLA(LLAMA A CONSULTAR)
          if(request.getAttribute("filtro")!=null){
              datos = (List<Persona>) request.getAttribute("filtro");
          }else  if(request.getAttribute("reinicio")!=null){
                  datos = dao.consultar();
          }else{
              datos = dao.consultar();
          }
          
          //ESTE BUCLE ES PARA RECORRER EL RESULTADO DE LLAMAR A CONSULTAR          
            for(Persona p : datos){
       %>   
             <tr>
                 <td> <%=p.getId()%>      </td>
                 <td> <%=p.getNombres()%> </td>
                 <td> <%=p.getApellidos()%></td>
                 <td> <%=p.getEdad()%>    </td>
                 <!--EN ESTA ULTIMA COLUMNA LLAMO AL SCRIPT A LA FUNCION CARGAR Y
                 LE PASO COMO PARAMETROS LO QUE SE IMPRIME EN CADA FILA, EN OTRAS PALABRAS
                 CARA HREF VA QUEDAR ASI: cargar('1','juan','perez','25'), etc-->
                 <td> <a href="javascript:cargar('<%=p.getId()%>',
                         '<%=p.getNombres()%>','<%= p.getApellidos()%>',
                         '<%= p.getEdad()%>')">cargar</a>  </td>
             </tr>
       <% 
            }   
       %>
        </table>
    </center>     
    </body>
<!-- que chivo va vo-->
</html>

