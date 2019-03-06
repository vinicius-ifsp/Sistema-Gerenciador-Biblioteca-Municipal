/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import conexao.MysqlDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vinicius Silva
 */
public class Livro {    
    private int id;
    private String titulo;
    private String subtitulo;
    private String autor;
    private String genero;
    private String anoPublicacao;
    private String qtdPaginas;
    private String editora;
    private String publicacao;
    private int qtdExemplares;
    private String dataEntrada;

    public Livro(){

    }

    public Livro(String titulo, String subtitulo, String autor, String genero, String anoPublicacao,
            String qtdPaginas, String editora, String publicacao, int qtdExemplares, String dataEntrada) {
        this.id = id;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.qtdPaginas = qtdPaginas;
        this.editora = editora;
        this.publicacao = publicacao;
        this.qtdExemplares = qtdExemplares;
        this.dataEntrada = dataEntrada;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getSubtitulo() {
        return subtitulo;
    }
    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public String getQtdPaginas() {
        return qtdPaginas;
    }
    public void setQtdPaginas(String qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public String getPublicacao() {
        return publicacao;
    }
    public void setPublicacao(String publicacao) {
        this.publicacao = publicacao;
    }
    public int getQtdExemplares() {
        return qtdExemplares;
    }
    public void setQtdExemplares(int qtdExemplares) {
        this.qtdExemplares = qtdExemplares;
    }
    public String getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public void inserirLivro() throws SQLException{
        MysqlDB banco = new MysqlDB();
        banco.connect();
        PreparedStatement ps = null;
        String sql = null;

        sql = "INSERT INTO Livro(titulo,subtitulo,autor,genero,anoPublicacao,qtdPaginas,editora,publicacao,"
                + "qtdExemplares,dataEntrada) VALUES(?,?,?,?,?,?,?,?,?,?);";
        ps = banco.conn.prepareStatement(sql);
        ps.setString(1, this.titulo);
        ps.setString(2, this.subtitulo);
        ps.setString(3, this.autor);
        ps.setString(4, this.genero);
        ps.setString(5, this.anoPublicacao);
        ps.setString(6, this.qtdPaginas);
        ps.setString(7, this.editora);
        ps.setString(8, this.publicacao);
        ps.setInt(9, this.qtdExemplares);
        ps.setString(10, this.dataEntrada);
        ps.executeUpdate();
        ps.close();
        banco.disconnect();
    }
    public ResultSet buscarLivro() throws SQLException{
        MysqlDB banco = new MysqlDB();
        banco.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;

        sql = "SELECT * FROM Livro WHERE titulo like '"+this.titulo+"%' or autor like '"+this.autor+"%'";
        ps = banco.conn.prepareStatement(sql);
        //ps.setString(1, getTitulo());
        //ps.setString(2, getAutor());
        rs = ps.executeQuery();
        return rs;
    }
    public ResultSet listarLivro() throws SQLException{
        MysqlDB banco = new MysqlDB();
        banco.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;

        sql = "SELECT * FROM Livro";
        ps = banco.conn.prepareStatement(sql);
        rs = ps.executeQuery(sql);
        return rs;
    }
    public void editarLivro() throws SQLException{
        MysqlDB banco = new MysqlDB();
        banco.connect();
        PreparedStatement ps = null;
        String sql = null;

        sql = "UPDATE Livro SET titulo=?, subtitulo=?, autor=?, genero=?, anoPublicacao=?, "
                + "qtdPaginas=?, editora=?, publicacao=?,qtdExemplares=? "
                + "WHERE id=? ;";

        ps = banco.conn.prepareStatement(sql);
        ps.setString(1, this.titulo);
        ps.setString(2, this.subtitulo);
        ps.setString(3, this.autor);
        ps.setString(4, this.genero);
        ps.setString(5, this.anoPublicacao);
        ps.setString(6, this.qtdPaginas);
        ps.setString(7, this.editora);
        ps.setString(8, this.publicacao);
        ps.setInt(9, this.qtdExemplares);
        ps.setInt(10, this.id);         

        ps.executeUpdate();
        ps.close();
        banco.disconnect();

    }

    public void excluirLivro() throws SQLException {
        MysqlDB banco = new MysqlDB();
        banco.connect();
        PreparedStatement ps = null;
        String sql = null;

        sql = "DELETE FROM Livro WHERE id="+this.id+";";
        ps = banco.conn.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
        banco.disconnect();
    }
}
