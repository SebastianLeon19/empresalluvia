package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelado.DAOPersona;
import java.util.ArrayList;
import uml.Persona;
import java.util.List;

public final class vistaPersona_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 

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



      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("CODIGO ELABORADO POR: Ing. Héctor Edmundo González Magaña, ing.edmundogm@gmail.com \n");
      out.write("EMPRESA: Itca-Fepade, Santa Tecla, La Libertar, El Salvador, CA\n");
      out.write("ESTE CODIGO DEBE USARSE SIN FINES LUCRATIVOS Y HACER REFERENCIA AL AUTOR\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Vista Pesona</title>\n");
      out.write("        <!--ESTE JAVASCRIPT ES PARA CARGAR DE LA TABLA A LOS TEXTOS DEL FORMULARIO -->\n");
      out.write("        <script lang=\"JavaScript\">\n");
      out.write("            function cargar(id, nombres, apellidos, edad){\n");
      out.write("                document.formPersona.txtId.value=id;\n");
      out.write("                document.formPersona.txtNombres.value=nombres;\n");
      out.write("                document.formPersona.txtApellidos.value=apellidos;\n");
      out.write("                document.formPersona.txtEdad.value=edad;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("     ");

        DAOPersona dao = new DAOPersona();
        List<Persona> datos= new ArrayList();         
    
      out.write("\n");
      out.write("     \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <pre>Bienvenido ");
      out.print( usuario );
      out.write(" | nivel Administrador |  <a href=\"login.jsp?cerrar=true\">Cerrar Sesion</a></pre>\n");
      out.write("        <hr>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <center>\n");
      out.write("        <!-- EL FORMULARIO PARA INGRESO DE DADTOS -->\n");
      out.write("        <h2>Formulario de Registro</h2>\n");
      out.write("        <form  name=\"formPersona\" method=\"POST\" action=\"SERVPersona\">\n");
      out.write("            <input type=\"text\" name=\"txtId\" placeholder=\" Id de persona\" size=\"30\"><br>\n");
      out.write("            <input type=\"text\" name=\"txtNombres\" placeholder=\" nombres ...\" size=\"30\"><br>\n");
      out.write("            <input type=\"text\" name=\"txtApellidos\" placeholder=\"apellidos...\" size=\"30\"><br>\n");
      out.write("            <input type=\"text\" name=\"txtEdad\" placeholder=\" edad ...\" size=\"30\"><br><br>\n");
      out.write("            <input type=\"submit\" name=\"btnInsertar\" value=\"Insertar\">\n");
      out.write("            <input type=\"submit\" name=\"btnModificar\" value=\"Modificar\">\n");
      out.write("            <input type=\"submit\" name=\"btnEliminar\" value=\"Eliminar\">   \n");
      out.write("            <hr>\n");
      out.write("            Buscar: <input type=\"text\" name=\"txtCriterio\">\n");
      out.write("            En base a:<input type=\"text\" name=\"txtCampo\" placeholder=\"podria ser un select jeje\">\n");
      out.write("            <input type=\"submit\" name=\"btnFiltrar\" value=\"Filtrar\"> \n");
      out.write("             <input type=\"submit\" name=\"btnReiniciar\" value=\"Reiniciar\"> \n");
      out.write("        </form>\n");
      out.write("    <hr>  \n");
      out.write("        <!-- DISEÑAMOS LA TABLA EN HTML Y LE METEMOS CODIGO JSP -->\n");
      out.write("        <table border=\"1px\">\n");
      out.write("             <!-- PRIMERO LOS ENCABEZADOS-->\n");
      out.write("            <tr>\n");
      out.write("            <td>ID </td>  <td>NOMBRES</td>  <td>APELLIDOS </td>  <td> EDAD</td><td> ACCION</td>\n");
      out.write("            </tr>\n");
      out.write("            <!-- AHORA TODO EL CONTENIDO DE LA TABLA-->\n");
      out.write("        ");
 
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
       
      out.write("   \n");
      out.write("             <tr>\n");
      out.write("                 <td> ");
      out.print(p.getId());
      out.write("      </td>\n");
      out.write("                 <td> ");
      out.print(p.getNombres());
      out.write(" </td>\n");
      out.write("                 <td> ");
      out.print(p.getApellidos());
      out.write("</td>\n");
      out.write("                 <td> ");
      out.print(p.getEdad());
      out.write("    </td>\n");
      out.write("                 <!--EN ESTA ULTIMA COLUMNA LLAMO AL SCRIPT A LA FUNCION CARGAR Y\n");
      out.write("                 LE PASO COMO PARAMETROS LO QUE SE IMPRIME EN CADA FILA, EN OTRAS PALABRAS\n");
      out.write("                 CARA HREF VA QUEDAR ASI: cargar('1','juan','perez','25'), etc-->\n");
      out.write("                 <td> <a href=\"javascript:cargar('");
      out.print(p.getId());
      out.write("',\n");
      out.write("                         '");
      out.print(p.getNombres());
      out.write("','");
      out.print( p.getApellidos());
      out.write("',\n");
      out.write("                         '");
      out.print( p.getEdad());
      out.write("')\">cargar</a>  </td>\n");
      out.write("             </tr>\n");
      out.write("       ");
 
            }   
       
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </center>     \n");
      out.write("    </body>\n");
      out.write("<!-- que chivo va vo-->\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
