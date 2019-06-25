/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Reserva;

/**
 *
 * @author darkc
 */
public class ReservaDAO implements ITreservaDAO {
    private ResultSet rs;
    private Connection con;
    private Conexao conexao;
    private PreparedStatement pst;

    public ReservaDAO() {
        conexao = new Conexao();
        con = conexao.conectar();
    }
    
    
    @Override
    public boolean salvar(Reserva obj) throws Exception {
        try{
            pst = con.prepareStatement("INSERT INTO reserva (id_hospede, id_quarto, id_funcionario, quant_dias) VALUES (?,?,?,?)");
            pst.setInt(1, obj.getIdHospede());
            pst.setInt(2, obj.getIdQuarto());
            pst.setInt(3, obj.getIdFunconario());
            pst.setInt(4, obj.getQuantidadeDias());
            pst.execute();
            return true;
        }catch(Exception e){
            throw new Exception("Erro ao salvar reserva. " + e.getMessage());
        }
    }

    @Override
    public ArrayList<String[]> listar() throws Exception {
        ArrayList<String[]> vetor = new ArrayList<String[]>();
        try{
            pst = con.prepareStatement("select r.id numReserva, h.nome nomeHospede, r.id_quarto idQuarto, r.quant_dias quantDias from hospede h inner join reserva r on\n" +
"(h.id = r.id_hospede)");
            
            rs = pst.executeQuery();
            while(rs.next()){
                String[] dados = new String[4];
                dados[0] = rs.getInt("numReserva")+"";
                dados[1] = rs.getString("nomeHospede");
                dados[2] = rs.getInt("idQuarto") + "";
                dados[3] = rs.getInt("quantDias")+"";
                vetor.add(dados);
            }
            return vetor;
        }catch(Exception e){
            throw new Exception("Erro ao listar reserva. " + e.getMessage());
        }
    }
    
}
