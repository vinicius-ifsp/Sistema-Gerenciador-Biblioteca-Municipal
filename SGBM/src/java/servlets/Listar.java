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
import models.Emprestimo;
import models.Leitor;
import models.Livro;

/**
 *
 * @author Vinicius Silva
 */
@WebServlet(name = "Listar", urlPatterns = {"/Listar"})
public class Listar extends HttpServlet {

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
        String tipoListagem = request.getParameter("tipoListagem");
        switch (tipoListagem){
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
    private void leitor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        Leitor leitor = new Leitor();
        // Cria um array que recebera os dados da consulta sql
        ResultSet rs = leitor.listarLeitor();
        // Cria uma Lista que recebera objetos com informações dos leitores
        List<Leitor> leitores = new ArrayList<Leitor>();
        // Percorre todos os leitores enccontrados
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
                leitores.add(leitorEncontrado);
        }
        // Seta os atributos para serem acessados nas outras paginas
        request.setAttribute("leitores", leitores);
        request.setAttribute("titulo1", "Listar Leitores");
        request.setAttribute("tituloTable", "Lista de Leitores");
        // Redireciona para outra página com os dados.
        request.getRequestDispatcher("/WEB-INF/resultListarLeitor.jsp").forward(request, response);
    }
    private void livro(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        
        Livro livro = new Livro();
        // Cria um array que recebera os dados da consulta sql
        ResultSet rs = livro.listarLivro();

        // Cria uma Lista que recebera objetos com informações dos livros
        List<Livro> livros =  new ArrayList<Livro>();
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
            livros.add(livroEncontrado);
        }
        // Seta os atributos para serem acessados nas outras paginas
        request.setAttribute("livros", livros);
        request.setAttribute("titulo1", "Listar Livros");
        request.setAttribute("tituloTable", "Lista de Livros");
        // Redireciona para outra página com os dados.
        request.getRequestDispatcher("/WEB-INF/resultListarLivro.jsp").forward(request, response);
    }
    private void emprestimo(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        
        Emprestimo emp = new Emprestimo();
        // Cria um array que recebera os dados da consulta sql
        /*ResultSet rs = livro.listarLivro();

        // Cria uma Lista que recebera objetos com informações dos livros
        List<Livro> livros =  new ArrayList<Livro>();
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
            livros.add(livroEncontrado);
        }
        // Seta os atributos para serem acessados nas outras paginas
        request.setAttribute("livros", livros);
        request.setAttribute("titulo1", "Listar Livros");
        request.setAttribute("tituloTable", "Lista de Livros");
        // Redireciona para outra página com os dados.
        request.getRequestDispatcher("/WEB-INF/resultListarLivro.jsp").forward(request, response);
        */
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
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
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
