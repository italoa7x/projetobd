/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author darkc
 */
public class Conexao {
    private final String USER  = "postgres";
    private final String PASS  = "postgres";
    private final String URL  = "jdbc:postgresql://localhost:5432/db_pousada";
    
    public Connection conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(Exception e){
            throw new RuntimeException("Erro ao conectar");
        }
    }
}
