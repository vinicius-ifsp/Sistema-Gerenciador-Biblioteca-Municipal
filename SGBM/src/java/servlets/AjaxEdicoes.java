/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Leitor;
import models.Livro;

/**
 *
 * @author Vinicius Silva
 */
@WebServlet(name = "AjaxEdicoes", urlPatterns = {"/AjaxEdicoes"})
public class AjaxEdicoes extends HttpServlet {

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
        /* TODO output your page here. You may use following sample code. */
        String tipoRequisicao = request.getParameter("tipoRequisicao");
        switch (tipoRequisicao){
            case "salvarEditLivro":
                salvarEditLivro(request, response);
                break;
            case "salvarEditLeitor":
                salvarEditLeitor(request, response);
                break;
            case "buscarLeitor":
                buscarLeitor(request, response);
                break;
            case "buscarLivro":
                buscarLivro(request, response);
                break;
            case "excluirLivro":
                excluirLivro(request, response);
                break;
            case "excluirLeitor":
                excluirLeitor(request, response);
                break;
            default:
                break;
        }
    }
    private void salvarEditLivro(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
        // Obtem os dados enviados e atribui as respectivas váriaveis
        int id = Integer.parseInt(request.getParameter("idEdit"));
        String titulo = request.getParameter("titulo");
	String subtitulo = request.getParameter("subtitulo");
	String autor = request.getParameter("autor");
	String genero = request.getParameter("genero");
	String anoPublicacao = request.getParameter("anoPublicacao");
	String qtdPaginas = request.getParameter("qtdPaginas");
	String editora = request.getParameter("editora");
	String publicacao = request.getParameter("publicacao");
	int qtdExemplares = Integer.parseInt(request.getParameter("qtdExemplares"));
	
        // Cria um objeto da Classe Leitor
	Livro livro = new Livro();
        livro.setId(id);
        livro.setTitulo(titulo);
        livro.setSubtitulo(subtitulo);
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setAnoPublicacao(anoPublicacao);
        livro.setQtdPaginas(qtdPaginas);
        livro.setEditora(editora);
        livro.setPublicacao(publicacao);
        livro.setQtdExemplares(qtdExemplares);
        
        String status = null;
        try {
            livro.editarLivro();
            status = "Dados do livro atualizado com sucesso.";
        } catch (SQLException e) {
            e.printStackTrace();
            status = "Erro ao realizar atualização de dados do livro!";
        }
        // Retorna resposta para o Ajax
        PrintWriter out = response.getWriter();
        out.print("Hello Word Ajax: "+status);
        out.close();
    }
    private void salvarEditLeitor(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
        // Obtem os dados enviados e atribui as respectivas váriaveis
        int id = Integer.parseInt(request.getParameter("idEdit"));
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
	
        // Cria um objeto da Classe Leitor
	Leitor leitor = new Leitor();
        leitor.setId(id);
        leitor.setNome(nome);
        leitor.setRg(rg);
        leitor.setCpf(cpf);
        leitor.setEndereco(endereco);
        leitor.setNumero(numero);
        leitor.setTelefone(telefone);
        leitor.setCelular(celular);
        leitor.setEmail(email);
        
        String status = null;
        try {
            leitor.editarLeitor();
            status = "Dados do leitor atualizado com sucesso.";
        } catch (SQLException e) {
            e.printStackTrace();
            status = "Erro ao realizar atualização de dados do leitor!";
        }
        // Retorna resposta para o Ajax
        PrintWriter out = response.getWriter();
        out.print("Hello Word Ajax: "+status);
        out.close();
    }
    
    private void buscarLeitor(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        
        // Cria um objeto da classe leitor e set dois atributos
        Leitor leitor = new Leitor();
        leitor.setNome(nome);
        leitor.setEmail(email);
        //Chama o metodo de buscar leitor
        ResultSet rs = leitor.buscarLeitor();
        // Cria uma Lista que recebera objetos com informações dos leitores encontrados
        ArrayList<String> leitoresEncontrados = new ArrayList();
        // Percorre todos os leitores encontrados
        
        while (rs.next()){
            //ArrayList<String> leitorEncontrado = new ArrayList();

            leitoresEncontrados.add(Integer.toString(rs.getInt(1)));
            leitoresEncontrados.add(rs.getString(2));
            // Adiciona Leitor com as informações a lista de leitores
           // leitoresEncontrados.add(leitorEncontrado);
            
        }
        PrintWriter out = response.getWriter();
        if(leitoresEncontrados.size()>0){
            out.print(leitoresEncontrados);
        }else{
            out.print("Buscar Leitor: Erro!");
        }
        out.close();
    }

    private void buscarLivro(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        
        // Cria um objeto da classe livro e set dois atributos
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        //Chama o metodo de buscar leitor
        ResultSet rs = livro.buscarLivro();
        // Cria uma Lista que recebera objetos com informações dos livros encontrados
        ArrayList<String> livrosEncontrados = new ArrayList();
        // Percorre todos os leitores encontrados
        
        while (rs.next()){
            
            livrosEncontrados.add(Integer.toString(rs.getInt(1)));
            livrosEncontrados.add(rs.getString(2));            
        }
        PrintWriter out = response.getWriter();
        if(livrosEncontrados.size()>0){
            out.print(livrosEncontrados);
        }else{
            out.print("Buscar Livro: Erro!");
        }
        out.close();
    }

    private void excluirLivro(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Livro livro = new Livro();
        livro.setId(id);
        String status = null;
        try{
            livro.excluirLivro();
            status = "Livro excluido com sucesso.";
        }catch(Exception e){
            status = "Erro ao excluir livro.";
        }finally{
            PrintWriter out = response.getWriter();
            out.print(status);
            out.close();                    
        }
    }

    private void excluirLeitor(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        Leitor leitor = new Leitor();
        leitor.setId(id);
        String status = null;
        try{
            leitor.excluirLeitor();
            status = "Leitor excluido com sucesso.";
        }catch(Exception e){
            status = "Erro ao excluir leitor.";
        }finally{
            PrintWriter out = response.getWriter();
            out.print(status);
            out.close();                    
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
            Logger.getLogger(AjaxEdicoes.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AjaxEdicoes.class.getName()).log(Level.SEVERE, null, ex);
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
