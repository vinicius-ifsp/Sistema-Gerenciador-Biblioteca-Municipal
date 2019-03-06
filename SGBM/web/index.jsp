<%-- 
    Document   : index
    Created on : 29/11/2017, 23:45:39
    Author     : Vinicius Silva
--%>
<%@page import="models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String aviso= "";
    HttpSession sessao = request.getSession();
    if(sessao.getAttribute("usuario")!=null){
        request.getRequestDispatcher("inicio.jsp").forward(request, response);
    }else if(request.getAttribute("aviso")!=null){
        aviso = (String) request.getAttribute("aviso");
    }else{
        aviso = "";
    }
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="icon" href="dist/img/icon.png" type="image/x-icon"/>
  <title>Biblioteca Municipal</title>
  <script src="https://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>
  <link href='https://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/148866/reset.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="index/css/styles.css" type='text/css' media="all" >
</head>

<body>
	<header role="banner">
		<div id="cd-logo"><a href="#0"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/148866/cd-logo_1.svg" alt="Logo"></a></div>

		<nav class="main-nav">
			<ul>
				<!-- inser more links here -->
				<li><a class="cd-signin" href="#0">Entrar</a></li>
			</ul>
		</nav>
	</header>

	<div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->
		<div class="cd-user-modal-container"> <!-- this is the container wrapper -->
			<ul class="cd-switcher">
				<li><a href="#0">Entrar</a></li>
			</ul>
			<div id="cd-login"> <!-- log in form -->
                            <form action="Authentication" class="cd-form" method="post">
                                <input type="hidden" name="tipoRequisicao" value="Login">
					<p class="fieldset">
						<label class="image-replace cd-email" for="signin-email">Usuário</label>
                                                <input name="user" class="full-width has-padding has-border" id="signin-email" type="text" placeholder="Usuário">
					</p>

					<p class="fieldset">
						<label class="image-replace cd-password" for="signin-password">Senha</label>
                                                <input name="pswd" class="full-width has-padding has-border" id="signin-password" type="password"  placeholder="Senha">
						<a href="#0" class="hide-password">Mostrar</a>
					</p>

					<p class="fieldset">
						<input type="checkbox" id="remember-me" checked>
						<label for="remember-me">Lembre-se de mim</label>
					</p>

					<p class="fieldset">
						<input class="full-width" type="submit" value="Login">
					</p>
				</form>
			</div> <!-- cd-login -->

		</div> <!-- cd-user-modal-container -->
	</div> <!-- cd-user-modal -->
	<img src="index/video/biblioteca.png" height="553px" width="1370px">
<!-- 	<video autoplay loop id="video-background" poster="video/sparks.jpg" muted>
  	<source src="index/video/sparks.mp4" type="video/mp4">
	</video> -->

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="index/js/js.js"></script>
  <% if(aviso != ""){ %>
  <script>
      alert("<%=aviso%>");
  </script>
  <%}%>
</body>
</html>
