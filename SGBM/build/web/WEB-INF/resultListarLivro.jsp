<%-- 
    Document   : resultBuscaLivro
    Created on : 02/12/2017, 15:57:38
    Author     : Vinicius Silva
--%>
<%@page import="models.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.Livro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    String urlLogout = "Authentication?tipoRequisicao=Logout";
    
    //Titullo 1 page e table
    String titulo1 = (String) request.getAttribute("titulo1");
    String tituloTable = (String) request.getAttribute("tituloTable");
    
    //Menu - Itens - Listar
    String urlListEmprestimos = "Listar?tipoListagem=Emprestimo"; 
    String urlListLivros = "Listar?tipoListagem=Livro"; 
    String urlListLeitores = "Listar?tipoListagem=Leitor";
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">  
        <link rel="icon" href="dist/img/icon.png" type="image/x-icon"/>
        <title>Biblioteca Municipal</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
        <style type="text/css">
          th, td{
            text-align: center;
          }

        </style>
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
          <a href="inicio.jsp" class="logo">
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
                    <img src="dist/img/admin.png" class="user-image" alt="User Image">
                    <span class="hidden-xs">Admin</span>
                  </a>
                  <ul class="dropdown-menu">
                    <!-- User image -->
                    <li class="user-header">
                      <img src="dist/img/admin.png" class="img-circle" alt="User Image">

                      <p>
                        <%=usuario.getNome() %>
                        <small>Bibliotecário</small>
                      </p>
                    </li>
                    <!-- Menu Footer-->
                    <li class="user-footer">
                      <div class="pull-left">
                        <a href="pages/examples/profile.jsp" class="btn btn-default btn-flat">Perfil</a>
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
                <img src="dist/img/admin.png" class="img-circle" alt="User Image">
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
                    <li><a href="pages/forms/cadastrarEmprestimo.jsp"><i class="fa fa-circle-o"></i> Empréstimo</a></li>
                    <li><a href="pages/forms/cadastrarLivro.jsp"><i class="fa fa-circle-o"></i> Livros</a></li>
                    <li><a href="pages/forms/cadastrarLeitor.jsp"><i class="fa fa-circle-o"></i> Leitores</a></li>
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
                    <li><a href="pages/edit/editarEmprestimo.jsp"><i class="fa fa-circle-o"></i> Empréstimos</a></li>
                    <li><a href="pages/edit/editarLivro.jsp"><i class="fa fa-circle-o"></i> Livros</a></li>
                    <li><a href="pages/edit/editarLeitor.jsp"><i class="fa fa-circle-o"></i> Leitores</a></li>
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
            <li><a href="<%=urlListEmprestimos%>"><i class="fa fa-circle-o"></i> Empréstimos</a></li>
            <li><a href="<%=urlListLivros%>"><i class="fa fa-circle-o"></i> Livros</a></li>
            <li><a href="<%=urlListLeitores%>"><i class="fa fa-circle-o"></i> Leitores</a></li>
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
                  <li><a href="pages/tables/relatorioLeitores.jsp"><i class="fa fa-circle-o"></i> Leitores</a></li>
                  <li><a href="pages/tables/relatorioLivro.jsp"><i class="fa fa-circle-o"></i> Livros</a></li>
                  <li><a href="pages/tables/relatorioAlugados.jsp"><i class="fa fa-circle-o"></i> Livros Alugados</a></li>
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
              Livros
              <small><%=titulo1%></small>
            </h1>
            <ol class="breadcrumb">
              <li><a href="inicio.jsp"><i class="fa fa-dashboard"></i> Início</a></li>
              <li><a href="pages/edit/editarLivro.jsp">Editar</a></li>
              <li class="active">Livros</li>
            </ol>
          </section>

          <!-- Main content -->
          <section class="content">
            <div class="row">
              <div class="col-xs-12">
                <div class="box">
                  <div class="box-header">
                    <h3 class="box-title" style="font-size: 40px;"><%=tituloTable%></h3>

                    <div class="box-tools">
                      <div class="input-group input-group-sm" style="width: 150px;">
                        <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                        <div class="input-group-btn">
                          <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                        </div>
                      </div>
                    </div>
                  </div>
                  <!-- /.box-header -->
                        <%
                          List<Livro> livros = (List<Livro>) request.getAttribute("livros");
                          if(livros.size()>0){
                        %>
                  <div class="box-body table-responsive no-padding">
                    <table class="table table-hover">
                        <thead
                            <tr>
                              <th>ID</th>
                              <th>Título</th>
                              <th>Subtítulo</th>
                              <th>Autor</th>
                              <th>Gênero</th>
                              <th>Ano de Publicação</th>
                              <th>Nº de Páginas</th>
                              <th>Editora</th>
                              <th>Publicação</th>
                              <th>Exemplares</th>
                              <th>Data</th>
                              <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                      <%
                          for (int i = 0; i < livros.size(); i++){
                              Livro livro = livros.get(i);
                              // Variavel utlizada para mapear os campos 
                              int id = livro.getId();
                      %>
                            <tr>
                              <td><%=id %></td>
                              <td id="tituloLiv<%=id%>"><%= livro.getTitulo()%></td>
                              <td id="subtituloLiv<%=id%>"><%= livro.getSubtitulo()%></td>
                              <td id="autorLiv<%=id%>"><%= livro.getAutor()%></td>
                              <td id="generoLiv<%=id%>"><%= livro.getGenero()%></td>
                              <td id="anoPublicacaoLiv<%=id%>"><%= livro.getAnoPublicacao()%></td>
                              <td id="qtdPaginasLiv<%=id%>"><%= livro.getQtdPaginas()%></td>
                              <td id="editoraLiv<%=id%>"><%= livro.getEditora()%></td>
                              <td id="publicacaoLiv<%=id%>"><%= livro.getPublicacao()%></td>
                              <td id="qtdExemplaresLiv<%=id%>"><%= livro.getQtdExemplares()%></td>
                              <td><%= livro.getDataEntrada()%></td>
                              <td class="btn btn-primary" onclick="carregarDados(<%=id%>,'#myModalEditLivro')">Editar</td>
                              <td class="btn btn-danger" onclick="excluir(<%=id%>,'<%=livro.getTitulo()%>')">Exluir</td>
                            </tr>
                      <% } %>
                        </tbody>
                    </table>
                    <%
                        } else{
                     %>
                     <h2>Nenhuma Livro encontrado.</h2>
                     <% } %>
                  </div>
                  <!-- /.box-body -->
                </div>
                <!-- /.box -->
              </div>
              <div class="box-footer clearfix">
                <ul class="pagination pagination-sm no-margin pull-right">
                  <li><a href="#">&laquo;</a></li>
                  <li><a href="#">1</a></li>
                  <li><a href="#">2</a></li>
                  <li><a href="#">3</a></li>
                  <li><a href="#">&raquo;</a></li>
                </ul>
              </div>
            </div>
            <!-- Modal de Edição do Livro -->
            <div class="modal fade" id="myModalEditLivro">
                <div class="modal-dialog modal-lg">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                      <h4 class="modal-title">Editar Livro</h4>
                    </div>
                    <div class="modal-body">
                        <form id="formEditLivro">
                            <div class="form-group">
                              <input type="text" class="form-control" name="titulo" id="titulo"
                              placeholder="Título" required><br>
                              <input type="text" class="form-control" name="subtitulo" id="subtitulo"
                              placeholder="Subtítulo" required><br>
                              <input type="text" class="form-control" name="autor" id="autor"
                              placeholder="Autor" required><br>
                              <input type="text" class="form-control" name="genero" id="genero"
                              placeholder="Gênero" required><br>
                              <input type="text" class="form-control" name="anoPublicacao" id="anoPublicacao"
                              placeholder="Ano de Publicação" required><br>
                              <input type="text" class="form-control" name="qtdPaginas" id="qtdPaginas"
                              placeholder="Ano de Publicação" required><br>
                              <input type="text" class="form-control" name="editora" id="editora"
                              placeholder="Editora" required><br>
                              <input type="text" class="form-control" name="publicacao" id="publicacao"
                              placeholder="Publicação" required><br>
                              <input type="text" class="form-control" name="qtdExemplares" id="qtdExemplares"
                              placeholder="Exemplares" required><br>
                              <input type="hidden" value="" name="idEdit" id="idEdit">
                              <input type="hidden" value="salvarEditLivro" name="tipoRequisicao">
                            </div>
                        </form>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                          <button type="button" class="btn btn-primary" onclick="salvarEditLivro('#myModalEditLivro', '#formEditLivro')">Salvar</button>
                        </div>
                    </div> 
                  </div>
                </div>
            </div> <!-- Fim do Modal de Edição do Livro -->
          </section>
          <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
      <!-- ./wrapper -->

      <!-- jQuery 3 -->
      <script src="bower_components/jquery/dist/jquery.min.js"></script>
      <!-- Bootstrap 3.3.7 -->
      <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
      <!-- Slimscroll -->
      <script src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
      <!-- FastClick -->
      <script src="bower_components/fastclick/lib/fastclick.js"></script>
      <!-- AdminLTE App -->
      <script src="dist/js/adminlte.min.js"></script>
      <!-- AdminLTE for demo purposes -->
      <script src="dist/js/demo.js"></script>
      <script src="dist/js/funcoesGenericas.js"></script>
      <script>
          // Funcao responsavl por prrencher os dados do form de editar
          function carregarDados(id,myModal){
              var titulo = $("#tituloLiv"+id).text();
              var subtitulo = $("#subtituloLiv"+id).text();
              var autor = $("#autorLiv"+id).text();
              var genero = $("#generoLiv"+id).text();
              var anoPublicacao = $("#anoPublicacaoLiv"+id).text();
              var qtdPaginas = $("#qtdPaginasLiv"+id).text();
              var editora = $("#editoraLiv"+id).text();
              var publicacao = $("#publicacaoLiv"+id).text();
              var qtdEmplares = $("#qtdExemplaresLiv"+id).text();
              
              atualizarCampoVal("#titulo",titulo);
              atualizarCampoVal("#subtitulo",subtitulo);
              atualizarCampoVal("#autor",autor);
              atualizarCampoVal("#genero",genero);
              atualizarCampoVal("#anoPublicacao",anoPublicacao);
              atualizarCampoVal("#qtdPaginas",qtdPaginas);
              atualizarCampoVal("#editora",editora);
              atualizarCampoVal("#publicacao",publicacao);
              atualizarCampoVal("#qtdExemplares",qtdEmplares);
              atualizarCampoVal("#idEdit", id);
              abrirModal(myModal);
          }
          // Funcao responsavel por enviar informações a serem alteradas
          function salvarEditLivro(myModal, idForm){
              $(document).ready(function(){
                  var dados = $( idForm ).serialize(); // Pega todos os dados do formulario.
                  $.ajax({
                      type: 'POST',
                      data: dados,
                      url:'AjaxEdicoes',
                      success: function (data, textStatus, jqXHR) {
                          // Recupera os dados atualizados
                          var id = $("#idEdit").val();
                          var titulo = getCampo(idForm, "#titulo");
                          var subtitulo = getCampo(idForm, "#subtitulo");
                          var autor = getCampo(idForm, "#autor");
                          var genero = getCampo(idForm, "#genero");
                          var anoPublicacao = getCampo(idForm, "#anoPublicacao");
                          var qtdPaginas = getCampo(idForm, "#qtdPaginas");
                          var editora = getCampo(idForm, "#editora");
                          var publicacao = getCampo(idForm, "#publicacao");
                          var qtdExemplares = getCampo(idForm, "#qtdExemplares");
                           // Atualiza os campos com os novos dados
                          atualizarCampoHtml("#tituloLiv"+id,titulo);
                          atualizarCampoHtml("#subtituloLiv"+id,subtitulo);
                          atualizarCampoHtml("#autorLiv"+id,autor);
                          atualizarCampoHtml("#generoLiv"+id,genero);
                          atualizarCampoHtml("#anoPublicacaoLiv"+id,anoPublicacao);
                          atualizarCampoHtml("#qtdPaginasLiv"+id,qtdPaginas)                          ;
                          atualizarCampoHtml("#editoraLiv"+id,editora);
                          atualizarCampoHtml("#publicacaoLiv"+id,publicacao);
                          atualizarCampoHtml("#qtdExemplaresLiv"+id,qtdExemplares);
                          //Fecha o modal                                             
                          fecharModal(myModal);
                      }
                    });
                });
          }
          function excluir(id, titulo){
              if(confirm("Excluir o livro "+titulo+". Atenção essa ação excluirá todos os registros do livro")){
                  $(document).ready(function(){
                  $.ajax({
                      type: 'POST',
                      data: {tipoRequisicao: "excluirLivro", id: id},
                      url:'AjaxEdicoes',
                      success: function (data, textStatus, jqXHR) {
                          alert(data)
                      }
                    });
                });
              }
          }
      </script>
    </body>
</html>

