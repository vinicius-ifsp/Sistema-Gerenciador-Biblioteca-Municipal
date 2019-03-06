/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.mysql.jdbc.ResultSet;
import conexao.MysqlDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Vinicius Silva
 */
public class Emprestimo {
    int id;
    private String dataSaida;
    private String dataRetorno;

    public Emprestimo(String dataSaida, String dataRetorno){
        this.dataSaida = dataSaida;
        this.dataRetorno = dataRetorno;
    }    

    public Emprestimo() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }
    
    public void inserir() throws SQLException{
        MysqlDB banco = new MysqlDB();
        banco.connect();
        PreparedStatement ps = null;
        String sql = null;
        
        sql = "INSERT INTO Emprestimo(dataSaida, dataRetorno) VALUES (?,? );";
        ps = banco.conn.prepareStatement(sql);
        ps.setString(1, this.dataSaida);
        ps.setString(2, this.dataRetorno);
        
        ps.executeUpdate();
        ps.close();
        banco.disconnect();
    }
    public int buscarMaiorId() throws SQLException{
        int id = 0;

        MysqlDB banco = new MysqlDB();
        banco.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        
        sql = "SELECT MAX(ID) FROM Emprestimo;";
        ps = banco.conn.prepareStatement(sql);
        rs = (ResultSet) ps.executeQuery();
        while(rs.next()){
            id = rs.getInt(1);
        }
        ps.close();
        banco.disconnect();
        return id;
    }
}
