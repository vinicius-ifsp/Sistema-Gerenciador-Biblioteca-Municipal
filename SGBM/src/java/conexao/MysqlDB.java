/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.*;

/**
 *
 * @author Vinicius Silva
 */
public class MysqlDB {
    public Connection conn = null;
    public boolean status;
    
    String host = "localhost";
    String user = "admin";
    String pwd = "admin1234";
    String nomeBD = "biblioteca";
    
    public MysqlDB(String hosttmp){
        host = hosttmp;
	status = false;
    }
    public MysqlDB(){
	host = "jdbc:mysql://"+host+"/"+nomeBD+"?user="+user+"&password="+pwd;
	status=false;
    }
    public void connect() throws SQLException{ // Ao mudar na linha 30 para Class... pediu throws SQLException
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection( host );
	    status=true;
	    System.out.println("A conexão foi um sucesso");
	} catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.out.println("excessão Classe não encontrada");
	    e.printStackTrace();
	} catch(SQLException e) {
            System.out.println("SQL Exception... Não conectado");
	    e.printStackTrace();
	}
    }
    public void disconnect() throws SQLException{
        conn.close();
        status = false;
        System.out.println("Fechando conexão");
    }
    public boolean isconnected(){
        return status;
    }
}
