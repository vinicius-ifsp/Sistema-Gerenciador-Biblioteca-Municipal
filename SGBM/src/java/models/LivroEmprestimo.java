/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import conexao.MysqlDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Vinicius Silva
 */
public class LivroEmprestimo {
    private int idLivro;
    private int idEmprestimo;

    public LivroEmprestimo(int idLivro, int idEmprestimo) {
        this.idLivro = idLivro;
        this.idEmprestimo = idEmprestimo;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
    
    public void inserir() throws SQLException{
        MysqlDB banco = new MysqlDB();
        banco.connect();
        PreparedStatement ps = null;
        String sql = null;
        
        sql = "INSERT INTO LivroEmprestimo(idLivro, idEmprestimo) VALUES (?,?);";
        ps = banco.conn.prepareStatement(sql);
        ps.setInt(1, this.idLivro);
        ps.setInt(2, this.idEmprestimo);
        
        ps.executeUpdate();
        ps.close();
        banco.disconnect();
    }

}
