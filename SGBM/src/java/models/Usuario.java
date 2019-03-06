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
public class Usuario {
    private int id;
    private String nome; // 2
    private String rg; // 3
    private String email; // 4
    private String pswd; // 5
    private String tipoUser; // 6

    public Usuario(String nome, String rg, String email, String pswd, String tipoUser) {
        this.nome = nome;
        this.rg = rg;
        this.email = email;
        this.pswd = pswd;
        this.tipoUser = tipoUser;
    }

    public Usuario() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public boolean logar() throws SQLException{
        boolean statusLogin = false;
        MysqlDB banco = new MysqlDB();
        banco.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        
        //sql = "SELECT * FROM Usuario WHERE email = '?' and pswd = '?';";
        sql = "SELECT * FROM Usuario WHERE email = '"+email+"' and pswd = '"+pswd+"';";
        ps = banco.conn.prepareStatement(sql);

        //ps.setString(1, this.email);
        //ps.setString(2, this.pswd);
        
        rs = ps.executeQuery(sql);
        while(rs.next()){
            this.id = rs.getInt(1);
            this.nome = rs.getString(2);
            this.rg = rs.getString(3);
            this.tipoUser = rs.getString(6);
            
            statusLogin = true;
        }
        
        return statusLogin;
    }
}
