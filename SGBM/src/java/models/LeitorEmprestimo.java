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
public class LeitorEmprestimo {
    private int idLeitor;
    private int idEmprestimo;

    public LeitorEmprestimo(int idLeitor, int idEmprestimo) {
        this.idLeitor = idLeitor;
        this.idEmprestimo = idEmprestimo;
    }
     
    public int getIdLeitor() {
        return idLeitor;
    }

    public void setIdLeitor(int idLeitor) {
        this.idLeitor = idLeitor;
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
        
        sql = "INSERT INTO LeitorEmprestimo(idLeitor, idEmprestimo) VALUES (?,?);";
        ps = banco.conn.prepareStatement(sql);
        ps.setInt(1, this.idLeitor);
        ps.setInt(2, this.idEmprestimo);
        
        ps.executeUpdate();
        ps.close();
        banco.disconnect();
    }    
}
