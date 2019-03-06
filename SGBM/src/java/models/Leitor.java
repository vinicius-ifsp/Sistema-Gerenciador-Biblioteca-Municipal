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
public class Leitor {
    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private String endereco;
    private String complemento;
    private String numero;
    private String telefone;
    private String celular;
    private String email;
    private String dataEntrada;
    
    public Leitor(){
        
    }
    
    public Leitor(String nome, String rg, String cpf, String endereco, String complemento, String numero,
			String telefone, String celular, String email, String dataEntrada) {
        this.nome = nome;
	this.rg = rg;
	this.cpf = cpf;
	this.endereco = endereco;
	this.complemento = complemento;
	this.numero = numero;
	this.telefone = telefone;
	this.celular = celular;
	this.email = email;
	this.dataEntrada = dataEntrada;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
    	return nome;
    }
    public void setNome(String nome) {
    	this.nome = nome;
    }
    public String getRg() {
	return rg;
    }
    public void setRg(String rg) {
	this.rg = rg;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
    	this.endereco = endereco;
    }
    public String getComplemento() {
	return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getNumero() {
    	return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getTelefone() {
    	return telefone;
    }
    public void setTelefone(String telefone) {
    	this.telefone = telefone;
    }
    public String getCelular() {
    	return celular;
    }
    public void setCelular(String celular) {
    	this.celular = celular;
    }
    public String getEmail() {
    	return email;
    }
    public void setEmail(String email) {
	this.email = email;
    }
    public String getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public void inserirLeitor() throws SQLException {
    	MysqlDB banco = new MysqlDB();
    	banco.connect();
    	java.sql.PreparedStatement ps = null;
    	String sql = null;

	sql = "INSERT INTO Leitor(nome,rg,cpf,endereco,complemento,numero,telefone,celular,email,dataEntrada)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?);";
	ps = banco.conn.prepareStatement(sql);
	ps.setString(1, this.nome);
	ps.setString(2, this.rg);
	ps.setString(3, this.cpf);
	ps.setString(4, this.endereco);
	ps.setString(5, this.complemento);
	ps.setString(6, this.numero);
	ps.setString(7, this.telefone);
	ps.setString(8, this.celular);
	ps.setString(9, this.email);
	ps.setString(10, this.dataEntrada);

        ps.executeUpdate();
	ps.close();
	banco.disconnect();
    }
    public ResultSet buscarLeitor() throws SQLException{
        MysqlDB banco = new MysqlDB();
        banco.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
           
        sql = "SELECT * FROM Leitor WHERE nome like '"+this.nome+"%' or email like '"+this.email+"'";
        ps = banco.conn.prepareStatement(sql);
        //ps.setString(1, getTitulo());
        //ps.setString(2, getAutor());
        rs = ps.executeQuery();
        return rs;
    }
    public  ResultSet listarLeitor() throws SQLException{
        MysqlDB banco = new MysqlDB();
        banco.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        
        sql = "SELECT * FROM Leitor;";
        ps = banco.conn.prepareStatement(sql);
        rs = ps.executeQuery();
        return rs;
    }
        public void editarLeitor() throws SQLException{
            MysqlDB banco = new MysqlDB();
            banco.connect();
            PreparedStatement ps = null;
            String sql = null;

            sql = "UPDATE Leitor SET nome=?, rg=?, cpf=?, endereco=?, complemento=?, "
                    + "numero=?, telefone=?, celular=?,email=? "
                    + "WHERE id=? ;";
             
            ps = banco.conn.prepareStatement(sql);
            ps.setString(1, this.nome);
            ps.setString(2, this.rg);
            ps.setString(3, this.cpf);
            ps.setString(4, this.endereco);
            ps.setString(5, this.complemento);
            ps.setString(6, this.numero);
            ps.setString(7, this.telefone);
            ps.setString(8, this.celular);
            ps.setString(9, this.email);
            ps.setInt(10, this.id);         
           
            ps.executeUpdate();
            ps.close();
            banco.disconnect();

        }

    public void excluirLeitor() throws SQLException {
        MysqlDB banco = new MysqlDB();
        banco.connect();
        PreparedStatement ps = null;
        String sql = null;

        sql = "DELETE FROM Leitor WHERE id="+this.id+";";
        ps = banco.conn.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
        banco.disconnect();
    }

}
