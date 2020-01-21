package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <title>Login</title>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link href=\"css/cssMio.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    \n");
      out.write("        <link rel=\"shortcut icon\" href=\"Assets/Images/front/simbolo0.ico\" type=\"image/x-icon\"/>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("        <!--Fontawesome CDN-->\n");
      out.write("       <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\n");
      out.write("       <link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">\n");
      out.write("    </head>\n");
      out.write("  \n");
      out.write("  <body style=\"\">\n");
      out.write("    <header>\n");
      out.write("        <nav id=\"nav\" class=\"navbar nav-transparent\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <div class=\"navbar-brand\">\n");
      out.write("                        <a href=\"https://www.frc.utn.edu.ar/\"> \n");
      out.write("                            <img class=\"logo\" src=\"Assets/Images/front/logoutn.png\" alt=\"logo\">\n");
      out.write("                            <img class=\"logo-alt\" src=\"Assets/Images/front/logoutn2.png\" alt=\"logo\">\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"nav-collapse\">\n");
      out.write("                        <span></span>\n");
      out.write("                    </div>\n");
      out.write("                 </div>\n");
      out.write("                \n");
      out.write("                <ul class=\"main-nav nav navbar-nav navbar-right tamañoMenu\">\n");
      out.write("                    <li class=\"\"><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                     <li class=\"has-dropdown active\"><a href=\"\">Catalogo</a>\n");
      out.write("                        <ul class=\"dropdown\">\n");
      out.write("                            <li><a href=\"/TPCAYUN/listaCatalogoServlet\">Vigentes</a></li>\n");
      out.write("                            <li><a href=\"/TPCAYUN/agregarCatalogoServlet\">Crear Nuevo</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                     <li class=\"has-dropdown\"><a href=\"\">Clientes</a>\n");
      out.write("                        <ul class=\"dropdown\">\n");
      out.write("                            <li><a href=\"/TPCAYUN/listaCienteServlet\">Lista</a></li>\n");
      out.write("                            <li><a href=\"/TPCAYUN/listaClienteDeudaServlet\">Lista con deuda</a></li>\n");
      out.write("                            <li><a href=\"/TPCAYUN/modificacionImporteServlet\">Actualizar Importe</a></li>\n");
      out.write("                            <li><a href=\"/TPCAYUN/agregarCliente\">Alta Cliente</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"has-dropdown\"><a href=\"\">Articulos</a>\n");
      out.write("                        <ul class=\"dropdown\">\n");
      out.write("                            <li><a href=\"/TPCAYUN/listarArticulosServlet\">Lista</a></li>\n");
      out.write("                            <li><a href=\"/TPCAYUN/agregarArticuloServlet\">Alta</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                     <li class=\"has-dropdown\"><a href=\"\">Rubro</a>\n");
      out.write("                        <ul class=\"dropdown\">\n");
      out.write("                            <li><a href=\"/TPCAYUN/listaRubrosServlet\">Lista</a></li>\n");
      out.write("                            <li><a href=\"/TPCAYUN/agregarRubroServlet\">Alta</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                     <li class=\"has-dropdown\"><a href=\"\">Ventas</a>\n");
      out.write("                        <ul class=\"dropdown\">\n");
      out.write("                            <li><a href=\"/TPCAYUN/listaVentasServlet\">Lista</a></li>\n");
      out.write("                            <li><a href=\"/TPCAYUN/listaVentasClienteServlet\">Lista por Cliente</a></li>\n");
      out.write("                            <li><a href=\"/TPCAYUN/AgregarVentaServlet\">Alta</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                     <li class=\"has-dropdown\"><a href=\"\">Reportes</a>\n");
      out.write("                        <ul class=\"dropdown\">\n");
      out.write("                            <li><a href=\"/TPCAYUN/listarReportes?r=1\">Reporte 1</a></li>\n");
      out.write("                            <li><a href=\"/TPCAYUN/listarReportes?r=2\">Reporte 2</a></li>\n");
      out.write("                            <li><a href=\"/TPCAYUN/listarReportes?r=3\">Reporte 3</a></li>\n");
      out.write("                            <li><a href=\"/TPCAYUN/listarReportes?r=4\">Reporte 4</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"/TPCAYUN/LoginServlet?accion=cerrar\">Cerrar Sesión</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("      \n");
      out.write("      \n");
      out.write("      \n");
      out.write("<!-------------------------------------------HOME---------------------------------------------------->      \n");
      out.write("    <div id=\"home\">\n");
      out.write("            <div class=\"bg-img\" style=\"background-image: url(&#39;Assets/Images/front/fondo.jpg&#39;);\">\n");
      out.write("                <div class=\"overlay\"></div>\n");
      out.write("            </div>  \n");
      out.write("\n");
      out.write("            <div class=\"principal\">\n");
      out.write("                <div class=\"container tarjetaLogueo\">\n");
      out.write("                    <div class=\"d-flex justify-content-center h-100\">\n");
      out.write("                            <div class=\"card \">\n");
      out.write("                                    <div class=\"card-header\">\n");
      out.write("                                        <h3>Sign In</h3>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                            <form method=\"POST\" action=\"/TPCAYUN/LoginServlet\">\n");
      out.write("                                                    <div class=\"input-group form-group\">\n");
      out.write("                                                            <div class=\"input-group-prepend\">\n");
      out.write("                                                                    <span class=\"input-group-text\"><i class=\"fas fa-user\"></i></span>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        \n");
      out.write("                                                            <input type=\"text\" id=\"txtUsuario\" class=\"form-control\" name=\"txtUsuario\" aria-describedby=\"emailHelp\" placeholder=\"username\"/>\n");
      out.write("\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"input-group form-group\">\n");
      out.write("                                                            <div class=\"input-group-prepend\">\n");
      out.write("                                                                    <span class=\"input-group-text\"><i class=\"fas fa-key\"></i></span>\n");
      out.write("                                                            </div>\n");
      out.write("                                                    \n");
      out.write("                                                            <input type=\"password\" id=\"txtPass\" class=\"form-control \" name=\"txtPass\" placeholder=\"password\" /> \n");
      out.write("                                                    </div>\n");
      out.write("                                                   \n");
      out.write("                                                    <div class=\"form-group\">\n");
      out.write("                                                            <input type=\"submit\" value=\"Login\" class=\"btn float-right login_btn\">\n");
      out.write("                                                    </div>\n");
      out.write("                                            </form>\n");
      out.write("                                    </div>   \n");
      out.write("                            </div>\n");
      out.write("                    </div>\n");
      out.write("                </div> \n");
      out.write("             </div>\n");
      out.write("    </div>\n");
      out.write("     \n");
      out.write(" <!-------------------------------------------FIN HOME------------------------------------------------>     \n");
      out.write("      \n");
      out.write("      \n");
      out.write("      \n");
      out.write("    <footer id=\"footer\" class=\"sm-padding bg-dark\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <div class=\"footer-logo\">\n");
      out.write("                    <a href=\"https://www.frc.utn.edu.ar/\"><img src=\"Assets/Images/front/logoutn2.png\" alt=\"logo\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"footer-copyright\">\n");
      out.write("                    <p>Copyright © 2019. All Rights Reserved. Designed by CAYUN DIEGO</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("    <div id=\"back-to-top\" style=\"display: none;\"></div>\n");
      out.write("    \n");
      out.write("    <script type=\"text/javascript\" src=\"Bootstrap/jquery.min.js.descarga\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"Bootstrap/bootstrap.min.js.descarga\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"Bootstrap/owl.carousel.min.js.descarga\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"Bootstrap/jquery.magnific-popup.js.descarga\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"Bootstrap/main.js.descarga\"></script>\n");
      out.write("</body>\n");
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
