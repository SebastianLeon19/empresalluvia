package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import uml.Usuarios;
import java.util.ArrayList;
import java.util.List;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center><br><br><br><br><br><br><br> \n");
      out.write("        <h1>Formulario de Acceso</h1>\n");
      out.write("        <hr>\n");
      out.write("        <form name=\"frmLogin\" action=\"servUsuarios\" method=\"POST\">\n");
      out.write("            <input type=\"text\" name=\"txtUsuario\" value=\"\" size=\"30\" placeholder=\"Usuario....\"/><br>\n");
      out.write("            <input type=\"password\" name=\"txtContra\" value=\"\" size=\"30\" placeholder=\"Contraseña...\" />\n");
      out.write("            <br><br>\n");
      out.write("            <input type=\"submit\" value=\"Iniciar Sesion\" name=\"btnIniciar\" />\n");
      out.write("            <input type=\"submit\" value=\"Cancelar\" name=\"btnCancelar\" />\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        ");
  
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

        
      out.write("\n");
      out.write("        \n");
      out.write("        </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
