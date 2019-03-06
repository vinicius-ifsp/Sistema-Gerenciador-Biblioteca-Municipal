/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
import models.Leitor;
import models.Livro;

/**
 *
 * @author Vinicius Silva
 */
@WebServlet(name = "EditarBuscar", urlPatterns = {"/EditarBuscar"})
public class EditarBuscar extends HttpServlet {

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
            throws ServletException, IOException {
        String tipoEdicaoBusca = request.getParameter("tipoEdicaoBusca");
        switch (tipoEdicaoBusca){
            case "Leitor":
                leitor(request, response);
                break;
            case "Livro":
                livro(request,response);
                break;
            case "Emprestimo":
                //emprestimo(request, response);
                break;
            default:
                break;
        }
    }
    private void leitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Obtem os dados enviados e atribui as respectivas váriaveis
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        
        // Cria um objeto da Classe Leitor
        Leitor leitor = new Leitor();
        // Seta seus atributos com os dados recebidos do form
        leitor.setNome(nome);
        leitor.setEmail(email);
        try {
            // Cria um array que recebera resultados da consulta sql
            ResultSet rs = leitor.buscarLeitor();

            // Cria uma Lista que recebera objetos com informações dos livros encontrados
            List<Leitor> leitoresEncontrados =  new ArrayList<Leitor>();
            
            // Percorre todos os livros enccontrados
            while (rs.next()){
                Leitor leitorEncontrado = new Leitor();
                leitorEncontrado.setId(rs.getInt(1));
                leitorEncontrado.setNome(rs.getString(2));
                leitorEncontrado.setRg(rs.getString(3));
                leitorEncontrado.setCpf(rs.getString(4));
                leitorEncontrado.setEndereco(rs.getString(5));
                leitorEncontrado.setComplemento(rs.getString(6));
                leitorEncontrado.setNumero(rs.getString(7));
                leitorEncontrado.setTelefone(rs.getString(8));
                leitorEncontrado.setCelular(rs.getString(9));
                leitorEncontrado.setEmail(rs.getString(10));
                leitorEncontrado.setDataEntrada(rs.getString(11));
                
                // Adiciona Leitor com as informações a lista de leitores
                leitoresEncontrados.add(leitorEncontrado);
            }
            // Seta os atributos para serem acessados nas outras paginas
            request.setAttribute("leitores", leitoresEncontrados);
            request.setAttribute("titulo1", "Buscar Leitor");
            request.setAttribute("tituloTable", "Leitores Encontrados");
            // Redireciona para outra página com os dados.
            request.getRequestDispatcher("/WEB-INF/resultListarLeitor.jsp").forward(request, response);
        } catch (SQLException ex) {
            String msg = "Erro ao tentar buscar leitor!";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/WEB-INF/erroBuscaLeitor.jsp").forward(request, response);
            Logger.getLogger(EditarBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void livro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Obtem os dados enviados e atribui as respectivas váriaveis
        String titulo = request.getParameter("titulo");
	String autor = request.getParameter("autor");
        
        // Cria um objeto da Classe Livro
	Livro livro = new Livro();
        // Seta seus atributos com os dados recebidos do form
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        try {
            // Cria um array que recebera resultados da consulta sql
            ResultSet rs = livro.buscarLivro();
            // Cria uma Lista que recebera objetos com informações dos livros encontrados
            List<Livro> livrosEncontrados =  new ArrayList<Livro>();
            // Percorre todos os livros enccontrados
            while (rs.next()){
                Livro livroEncontrado = new Livro();
                livroEncontrado.setId(rs.getInt(1));
                livroEncontrado.setTitulo(rs.getString(2));
                livroEncontrado.setSubtitulo(rs.getString(3));
                livroEncontrado.setAutor(rs.getString(4));
                livroEncontrado.setGenero(rs.getString(5));
                livroEncontrado.setAnoPublicacao(rs.getString(6));
                livroEncontrado.setQtdPaginas(rs.getString(7));
                livroEncontrado.setEditora(rs.getString(8));
                livroEncontrado.setPublicacao(rs.getString(9));
                livroEncontrado.setQtdExemplares(rs.getInt(10));
                livroEncontrado.setDataEntrada(rs.getString(11));
                // Adiciona Livro com as informações a lista de livros
                livrosEncontrados.add(livroEncontrado);
            }
            // Seta os atributos para serem acessados nas outras paginas
            request.setAttribute("livros", livrosEncontrados);
            request.setAttribute("titulo1", "Buscar Livro");
            request.setAttribute("tituloTable", "Livros Encontrados");
            // Redireciona para outra página com os dados.
            request.getRequestDispatcher("/WEB-INF/resultListarLivro.jsp").forward(request, response);
        } catch (SQLException ex) {
            String msg = "Erro ao tentar buscar livro!";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/WEB-INF/erroBuscaLivro.jsp").forward(request, response);
            Logger.getLogger(EditarBuscar.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
