/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author darkc
 */
public class Conexao {
    private String USER  = "root";
    private String PASS  = "root";
    private String URL  = "jdbc:mysql://127.0.0.1:3306/db_pousada?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(Exception e){
            throw new RuntimeException("Erro ao conectar " + e.getMessage());
        }
    }
    
    public void desconectar(Connection con, PreparedStatement pst){
        try{
            if (con != null && pst != null) {
                con.close();
                pst.close();
            }
        }catch(Exception e) {
            
        }
    }
    public void desconectar(Connection con, PreparedStatement pst, ResultSet rs){
        desconectar(con, pst);
        try{
            if (rs != null) {
                rs.close();
            }
        }catch(Exception e) {
            
        }
    }
}
