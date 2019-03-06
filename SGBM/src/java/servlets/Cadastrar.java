/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Emprestimo;
import models.Leitor;
import models.LeitorEmprestimo;
import models.Livro;
import models.LivroEmprestimo;

/**
 *
 * @author Vinicius Silva
 */
@WebServlet(name = "Cadastrar", urlPatterns = {"/Cadastrar"})
public class Cadastrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String tipoCadastro = request.getParameter("tipoCadastro");
        switch (tipoCadastro){
            case "Leitor":
                leitor(request, response);
                break;
            case "Livro":
                livro(request,response);
                break;
            case "Emprestimo":
                emprestimo(request, response);
                break;
            default:
                break;
        }
    }
    private void leitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Obtem os dados enviados e atribui as respectivas váriaveis
        String nome = request.getParameter("nome");
	String rg = request.getParameter("rg");
	String cpf = request.getParameter("cpf");
	String endereco = request.getParameter("endereco");
	String complemento = request.getParameter("complemento");
	complemento=complemento==null?" ":complemento;
        String numero = request.getParameter("numero");
	String telefone = request.getParameter("telefone");
	String celular = request.getParameter("celular");
	String email = request.getParameter("email");
	String dataEntrada = request.getParameter("data");

        // Cria um objeto da Classe Leitor
	Leitor leitor = new Leitor(nome, rg, cpf, endereco, complemento, numero, telefone, celular, email, dataEntrada);

        // Declaração da variavel
	String status = null ;
        try {
            // Insere Leitor no banco de dados
            leitor.inserirLeitor();
            status = "Leitor cadastrado com sucesso.";
            request.setAttribute("result", true);
        } catch (SQLException e) {
            e.printStackTrace();
            status = "Erro ao realizar cadastro de Leitor!";
            request.setAttribute("result", false);
        } finally{
            request.setAttribute("status", status);
            request.setAttribute("titulo1", "Cadastrar Leitor");
            request.setAttribute("tituloPage", "Cadastrar Leitor");
            request.setAttribute("urlVoltar", "pages/forms/cadastrarLeitor.jsp");
            request.getRequestDispatcher("/WEB-INF/resultadoCadastro.jsp").forward(request, response);
        }
    }
    private void livro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Obtem os dados enviados e atribui as respectivas váriaveis
        String titulo = request.getParameter("titulo");
	String subtitulo = request.getParameter("subtitulo");
	String autor = request.getParameter("autor");
	String genero = request.getParameter("genero");
	String anoPublicacao = request.getParameter("anoPublicacao");
	String qtdPaginas = request.getParameter("qtdPaginas");
	String editora = request.getParameter("editora");
	String publicacao = request.getParameter("publicacao");
	int qtdExemplares = Integer.parseInt(request.getParameter("qtdExemplares"));
	String dataEntrada = request.getParameter("data");
        
        request.setAttribute("titulo", titulo);
        request.setAttribute("subtitulo", subtitulo);
        request.setAttribute("autor", autor);
        request.setAttribute("genero", genero);
        request.setAttribute("anoPublicacao", anoPublicacao);
        request.setAttribute("qtdPaginas", qtdPaginas);
        request.setAttribute("editora", editora);
        request.setAttribute("publicacao", publicacao);
        request.setAttribute("qtdExemplares", qtdExemplares);
        request.setAttribute("dataEntrada", dataEntrada);

        // Cria um objeto da Classe Leitor
	Livro livro = new Livro(titulo, subtitulo, autor, genero, anoPublicacao, qtdPaginas, editora, publicacao, qtdExemplares, dataEntrada);

        // Declaração da variavel
	String status = null ;
        try {
            // Insere Leitor no banco de dados
            livro.inserirLivro();
            status = "Livro cadastrado com sucesso.";
            request.setAttribute("result", true);
        } catch (SQLException e) {
            e.printStackTrace();
            status = "Erro ao realizar cadastro do livro!";
            request.setAttribute("result", false);
        } finally{
            request.setAttribute("status", status);
            request.setAttribute("titulo1", "Cadastrar Livro");
            request.setAttribute("tituloPage", "Cadastrar Livro");
            request.setAttribute("urlVoltar", "pages/forms/cadastrarLivro.jsp");
            request.getRequestDispatcher("/WEB-INF/resultadoCadastro.jsp").forward(request, response);
        }
    }

    private void emprestimo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
        int idLeitor = Integer.parseInt(request.getParameter("idLeitor"));
        int idLivro = Integer.parseInt(request.getParameter("idLivro"));
        String dataSaida = request.getParameter("dataSaida");
        String dataRetorno = request.getParameter("dataDevolucao");
        
        String status = null;
        try {
            //Emprestimo
            Emprestimo emp = new Emprestimo(dataSaida, dataRetorno);
            emp.inserir();

            int idEmprestimo = emp.buscarMaiorId();
            //Leitor Emprestimo
            LeitorEmprestimo leitorEmp = new LeitorEmprestimo(idLeitor, idEmprestimo);       
            leitorEmp.inserir();
            
            //Livro Emprestimo
            LivroEmprestimo livroEmp = new LivroEmprestimo(idLivro, idEmprestimo);
            livroEmp.inserir();
            
            status = "Empréstimo cadastrado com sucesso.";
            request.setAttribute("result", true);
        } catch (SQLException e) {
            e.printStackTrace();
            status = "Erro ao realizar cadastro do empréstimo!";
            request.setAttribute("result", false);
        } finally{
            request.setAttribute("status", status);
            request.setAttribute("titulo1", "Cadastrar Emprestimo");
            request.setAttribute("tituloPage", "Cadastrar Empréstimo");
            request.setAttribute("urlVoltar", "pages/forms/cadastrarEmprestimo.jsp");
            request.getRequestDispatcher("/WEB-INF/resultadoCadastro.jsp").forward(request, response);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
