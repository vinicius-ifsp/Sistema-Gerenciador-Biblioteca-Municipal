<%-- 
    Document   : inicio
    Created on : 29/11/2017, 23:47:47
    Author     : Vinicius Silva
--%>
<%@page import="models.Usuario"%>
<% 
    HttpSession sessao = request.getSession();
    Usuario usuario = new Usuario();
    if(sessao.getAttribute("usuario")==null){
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }else{
        usuario =  (Usuario) sessao.getAttribute("usuario");
    }

    // Declaração das Váriaveis que contens as url 
    //Logout
    String urlLogout = "../../Authentication?tipoRequisicao=Logout";
    //Menu - Itens - Listar
    String urlListEmprestimos = "../../Listar?tipoListagem=Emprestimo"; 
    String urlListLivros = "../../Listar?tipoListagem=Livro"; 
    String urlListLeitores = "../../Listar?tipoListagem=Leitor"; 
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">  
  <link rel="icon" href="../../dist/img/icon.png" type="image/x-icon"/>
  <title>Biblioteca Municipal</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
   <!-- Logo -->
    <a href="../../inicio.jsp" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><i class="fa fa-book"></i> </span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Gestão </b><i class="fa fa-book"></i></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="../../dist/img/admin.png" class="user-image" alt="User Image">
              <span class="hidden-xs">Admin</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="../../dist/img/admin.png" class="img-circle" alt="User Image">

                <p>
                  <%=usuario.getNome() %>
                  <small>Bibliotecário</small>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="../examples/profile.jsp" class="btn btn-default btn-flat">Perfil</a>
                </div>
                <div class="pull-right">
                  <a href="<%=urlLogout %>" class="btn btn-default btn-flat">Sair</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
 <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="../../dist/img/admin.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Admin</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Procurar...">
          <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">NAVEGAÇÃO</li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-edit"></i> <span>Cadastrar</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
              <li><a href="cadastrarEmprestimo.jsp"><i class="fa fa-circle-o"></i> Empréstimos</a></li>
              <li><a href="cadastrarLivro.jsp"><i class="fa fa-circle-o"></i> Livros</a></li>
              <li><a href="cadastrarLeitor.jsp"><i class="fa fa-circle-o"></i> Leitores</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-edit"></i> <span>Editar</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
              <li><a href="../edit/editarEmprestimo.jsp"><i class="fa fa-circle-o"></i> Empréstimos</a></li>
              <li><a href="../edit/editarLivro.jsp"><i class="fa fa-circle-o"></i> Livros</a></li>
              <li><a href="../edit/editarLeitor.jsp"><i class="fa fa-circle-o"></i> Leitores</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-edit"></i> <span>Listar</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
              <li><a href="<%=urlListEmprestimos %>"><i class="fa fa-circle-o"></i> Empréstimos</a></li>
              <li><a href="<%=urlListLivros %>"><i class="fa fa-circle-o"></i> Livros</a></li>
              <li><a href="<%=urlListLeitores %>"><i class="fa fa-circle-o"></i> Leitores</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-table"></i> <span>Relatórios</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../tables/relatorioLeitor.jsp"><i class="fa fa-circle-o"></i> Leitores</a></li>
            <li><a href="../tables/relatorioLivro.jsp"><i class="fa fa-circle-o"></i> Livros</a></li>
            <li><a href="../tables/relatorioAlugados.jsp"><i class="fa fa-circle-o"></i> Livros Alugados</a></li>
          </ul>
        </li>
        <li class="header">MENSAGENS</li>
        <li><a href=""><i class="fa fa-circle-o text-red"></i> <span>Importante</span></a></li>
        <li><a href=""><i class="fa fa-circle-o text-yellow"></i> <span>Alerta</span></a></li>
        <li><a href=""><i class="fa fa-circle-o text-aqua"></i> <span>Informação</span></a></li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Livro
        <small>Cadastrar Livro</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="../../inicio.jsp"><i class="fa fa-dashboard"></i> Início</a></li>
        <li><a href="leitor.jsp">Leitor</a></li>
        <li class="active">Livro</li>
      </ol>
    </section>

 <section class="content">
    <div class="box box-primary">
      <div class="box-header with-border">
        <h3 style="font-size: 40px" class="box-title">Cadastrar Livro</h3>
      </div>
      <!-- form start -->
      <form action="../../Cadastrar" method="post" data-toggle="validator" role="form" id="cadastrarLivro">
        <div class="box-body">
            <input type="hidden" value="Livro" name="tipoCadastro">
      <div class="col-md-12">
          <div class="col-md-6">
            <div class="form-group">
              <label for="titulo">Título</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-sticky-note"></i>
                  </div>
                    <input type="text" required name="titulo" class="form-control" id="titulo" placeholder="Título do Livro" data-error="Por favor, informe apenas caractéres." pattern="[a-z A-Z á-ú Á-ú-]*"><br>
                </div>
              <div class="help-block with-errors"></div>
              </div>
          </div>

          <div class="col-md-6">
            <div class="form-group">
              <label for="subtitulo">Subtítulo</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-sticky-note"></i>
                  </div>
                    <input type="text" required name="subtitulo" class="form-control" id="subtitulo" placeholder="Subtítulo do Livro" data-error="Por favor, informe apenas caractéres." pattern="[a-z A-Z á-ú Á-ú-]*"><br>
                </div>
                <div class="help-block with-errors"></div>
              </div>
          </div>
        </div>

      <div class="col-md-12">
          <div class="col-md-3" style="width: 50%;">
            <div class="form-group">
              <label for="autor">Autor</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-sticky-note"></i>
                  </div>
                    <input type="text" required name="autor" class="form-control" id="autor" placeholder="Nome do Autor" data-error="Por favor, informe apenas caractéres." pattern="[a-z A-Z á-ú Á-ú-]*"><br>
                </div>
                <div class="help-block with-errors"></div>
              </div>
          </div>

          <div class="col-md-2">
            <div class="form-group">
              <label for="genero">Gênero</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-list"></i>
                  </div>
                  <select required class="form-control" name="genero">
                      <option value="">Selecione</option>
                      <option value="Ciência">Ciência</option>
                      <option value="Ficção Científica">Ficção Científica</option>
                      <option value="Fantasia">Fantasia</option>
                      <option value="Filosofia">Filosofia</option>
                      <option value="História">História</option>
                      <option value="Política">Política</option>
                      <option value="Romance">Romance</option>
                      <option value="Religião">Religião</option>
                      <option value="Terror">Terror</option>
                      <option value="Poesia">Poesia</option>
                      <option value="Drama">Drama</option>
                      <option value="Comédia">Comédia</option>
                      <option value="Biografias">Biografias</option>
                      <option value="Infanto Juvenil">Infanto Juvenil</option>
                      <option value="Suspense">Suspense</option>
                  </select>
                </div>
                <div class="help-block with-errors"></div>
              </div>
          </div>

          <div class="col-md-2">
              <div class="form-group">
                <label for="ano">Ano de Publicação</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                    <input type="text" required name="anoPublicacao" class="form-control" id="ano" placeholder="Publicação" data-error="Por favor, informe apenas números." pattern="[0-9]+$"><br>
                </div>
                <div class="help-block with-errors"></div>
              </div>
          </div>

          <div class="col-md-2">
              <div class="form-group">
                <label for="paginas">Páginas</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-columns"></i>
                  </div>
                    <input type="text" required name="qtdPaginas" class="form-control" id="paginas" placeholder="Nº de Páginas" data-error="Por favor, informe apenas números." pattern="[0-9]+$"><br>
                </div>
                <div class="help-block with-errors"></div>
              </div>
          </div>
        </div>

      <div class="col-md-12">
          <div class="col-md-6">
            <div class="form-group">
              <label for="editora">Editora</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-sticky-note"></i>
                  </div>
                    <input type="text" required name="editora" class="form-control" id="editora" placeholder="Editora da Publicação" data-error="Por favor, informe apenas caractéres." pattern="[a-z A-Z á-ú Á-ú-]*"><br>
                </div>
                <div class="help-block with-errors"></div>
              </div>
          </div>

          <div class="col-md-2">
            <div class="form-group">
              <label for="publicacao">Publicação</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-list"></i>
                  </div>
                    <select required class="form-control" name="publicacao">
                        <option value="">Selecione</option>
                        <option value="Nacional">Nacional</option>
                        <option value="Internacional">Internacional</option>
                  </select>
                </div>
                <div class="help-block with-errors"></div>
              </div>
          </div>

          <div class="col-md-2">
              <div class="form-group">
                <label for="exemplares">Exemplares</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-columns"></i>
                  </div>
                  <input type="text" required name="qtdExemplares" class="form-control" id="exemplares" placeholder="Quantidade" data-error="Por favor, informe apenas números." pattern="[0-9]+$"><br>
                </div>
                <div id="eror" class="help-block with-errors"></div>
              </div>
          </div>

          <div class="col-md-2">
              <div class="form-group">
                <label for="data">Data</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input type="text" name="data" class="form-control"  id="data" readonly="true"><br>
                </div>
              </div>
              <div class="help-block with-errors"></div>
          </div>

        </div>
      </div>
        <!-- /.box-body -->

        <div class="box-footer" style="text-align: right;">
          <button type="submit" class="btn btn-primary" style="width:15%;"><i class="fa fa-edit"></i> <br>Cadastrar</button>
          <button onclick="limpar()" class="btn btn-primary"  style="width:15%;"><i class="fa fa-repeat"></i> <br>Limpar Campos</button>
        </div>
      </form>
    </div>
    <!-- /.box -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<!-- ./wrapper -->
<!-- jQuery 3 -->
<script src="../../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="../../bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<script src="../../dist/js/validator.min.js"></script>
<script src="../../dist/js/jquery.form.js"></script>
<script src="../../dist/js/jquery.mask.js"></script>
<script type="text/javascript">
  function Data()
  {
      data = new Date();
      dia_semana = data.getDate();
      mes = data.getMonth();
      ano = data.getFullYear()
      dataCompleta = dia_semana + '/'+ (mes+1) +'/' + ano;

      return dataCompleta;
  }
   window.onload = function(){
      document.getElementById("data").value = Data();
  }

  function limpar(){
    $("#cadastrarLivro").resetForm();
    $("#data").val(Data());
}
   jQuery(function($){
    $("#paginas").mask("99999");
    $("#ano").mask("9999");
    $("#exemplares").mask("99999");
   });
</script>
</body>
</html>
