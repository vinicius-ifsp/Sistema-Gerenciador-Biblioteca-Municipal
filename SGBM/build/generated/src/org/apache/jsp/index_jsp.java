package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Usuario;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    HttpSession sessao = request.getSession();
    if(sessao.getAttribute("usuario")!=null){
        request.getRequestDispatcher("inicio.jsp").forward(request, response);
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <link rel=\"icon\" href=\"dist/img/icon.png\" type=\"image/x-icon\"/>\n");
      out.write("  <title>Biblioteca Municipal</title>\n");
      out.write("  <script src=\"https://s.codepen.io/assets/libs/modernizr.js\" type=\"text/javascript\"></script>\n");
      out.write("  <link href='https://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://s3-us-west-2.amazonaws.com/s.cdpn.io/148866/reset.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"index/css/styles.css\" type='text/css' media=\"all\" >\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<header role=\"banner\">\n");
      out.write("\t\t<div id=\"cd-logo\"><a href=\"#0\"><img src=\"https://s3-us-west-2.amazonaws.com/s.cdpn.io/148866/cd-logo_1.svg\" alt=\"Logo\"></a></div>\n");
      out.write("\n");
      out.write("\t\t<nav class=\"main-nav\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<!-- inser more links here -->\n");
      out.write("\t\t\t\t<li><a class=\"cd-signin\" href=\"#0\">Entrar</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</nav>\n");
      out.write("\t</header>\n");
      out.write("\n");
      out.write("\t<div class=\"cd-user-modal\"> <!-- this is the entire modal form, including the background -->\n");
      out.write("\t\t<div class=\"cd-user-modal-container\"> <!-- this is the container wrapper -->\n");
      out.write("\t\t\t<ul class=\"cd-switcher\">\n");
      out.write("\t\t\t\t<li><a href=\"#0\">Entrar</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"cd-login\"> <!-- log in form -->\n");
      out.write("                            <form action=\"Authentication\" class=\"cd-form\" method=\"post\">\n");
      out.write("                                <input type=\"hidden\" name=\"tipoRequisicao\" value=\"Login\">\n");
      out.write("\t\t\t\t\t<p class=\"fieldset\">\n");
      out.write("\t\t\t\t\t\t<label class=\"image-replace cd-email\" for=\"signin-email\">Usuário</label>\n");
      out.write("                                                <input name=\"user\" class=\"full-width has-padding has-border\" id=\"signin-email\" type=\"text\" placeholder=\"Usuário\">\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<p class=\"fieldset\">\n");
      out.write("\t\t\t\t\t\t<label class=\"image-replace cd-password\" for=\"signin-password\">Senha</label>\n");
      out.write("                                                <input name=\"pswd\" class=\"full-width has-padding has-border\" id=\"signin-password\" type=\"password\"  placeholder=\"Senha\">\n");
      out.write("\t\t\t\t\t\t<a href=\"#0\" class=\"hide-password\">Mostrar</a>\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<p class=\"fieldset\">\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" id=\"remember-me\" checked>\n");
      out.write("\t\t\t\t\t\t<label for=\"remember-me\">Lembre-se de mim</label>\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<p class=\"fieldset\">\n");
      out.write("\t\t\t\t\t\t<input class=\"full-width\" type=\"submit\" value=\"Login\">\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div> <!-- cd-login -->\n");
      out.write("\n");
      out.write("\t\t</div> <!-- cd-user-modal-container -->\n");
      out.write("\t</div> <!-- cd-user-modal -->\n");
      out.write("\t<img src=\"index/video/biblioteca.png\" height=\"553px\" width=\"1370px\">\n");
      out.write("<!-- \t<video autoplay loop id=\"video-background\" poster=\"video/sparks.jpg\" muted>\n");
      out.write("  \t<source src=\"index/video/sparks.mp4\" type=\"video/mp4\">\n");
      out.write("\t</video> -->\n");
      out.write("\n");
      out.write("  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n");
      out.write("  <script  src=\"index/js/js.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
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
