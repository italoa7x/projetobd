/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author darkc
 */
public class RelatorioDAO implements ITrelatorios{

    private Conexao conexao;
    private Connection con;
    private ResultSet rs = null;
    private PreparedStatement pst;
    
    public RelatorioDAO() {
        conexao = new Conexao();
        con = conexao.conectar();
    }

    public ArrayList<String[]> relatorio(String dataInicio, String dataFim, String ordemExibicao) throws Exception {
        ArrayList<String[]> vetor = new ArrayList<String[]>();
            String sql = "select *from relatorio9 where Data_pg between ? and ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setDate(1, java.sql.Date.valueOf(dataInicio));
            pst.setDate(2, java.sql.Date.valueOf(dataFim));
            rs = pst.executeQuery();
            while(rs.next()){
                String[] dados = new String[7];
                dados[0] = rs.getInt("Quarto") + "";
                dados[1] = rs.getFloat("Diaria_quarto") + "";
                dados[2] = rs.getString("Hospede");
                dados[3] = rs.getInt("Id_hospede") + "";
                dados[4] = rs.getFloat("Valor_estadia") + "";
                dados[5] = rs.getFloat("Total_compras") + "";
                dados[6] = rs.getDate("Data_pg") + "";
                vetor.add(dados);
            }
            return vetor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public ArrayList<String[]> relatorio1() throws Exception {
         ArrayList<String[]> vetor = new ArrayList<String[]>();
        String sql = "select q.diaria, q.acomodacoes, q.status, q.id from quarto q inner join quarto_extra qe on (q.id = qe.id_quarto)";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String[] dados = new String[5];
                dados[0] = rs.getFloat("diaria")+"";
                dados[1] = rs.getInt("acomodacoes")+"";
                dados[2] = rs.getString("status");
                dados[3] = rs.getInt("id") + "";
                vetor.add(dados);
            }
            return vetor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public ArrayList<String[]> relatorio2() throws Exception {
          ArrayList<String[]> vetor = new ArrayList<String[]>();
        String sql = "select p.* from produto p inner join produto_pedido pp on (p.id = pp.id_produto)";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String[] dados = new String[5];
                dados[0] = rs.getFloat("valor") + "";
                dados[1] = rs.getString("nome");
                dados[2] = rs.getInt("quantidade") + "";
                dados[3] = rs.getInt("id") + "";
                vetor.add(dados);
            }
            return vetor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArrayList<String[]> relatorio3() throws Exception {
          ArrayList<String[]> vetor = new ArrayList<String[]>();
        String sql = "select p.nome, p.valor from produto p inner join produto_pedido pp on (p.id = pp.id_produto)";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String[] dados = new String[5];
                dados[0] = rs.getString("nome");
                dados[1] = rs.getFloat("valor") + "";
                vetor.add(dados);
            }
            return vetor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArrayList<String[]> relatorio4() throws Exception {
          ArrayList<String[]> vetor = new ArrayList<String[]>();
        String sql = "select *from funcionario where upper(cargo) = 'atendente'";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String[] dados = new String[5];
                dados[0] = rs.getString("nome");
                dados[1] = rs.getString("cpf");
                dados[2] = rs.getString("cargo");
                dados[3] = rs.getString("telefone") + "";
                vetor.add(dados);
            }
            return vetor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArrayList<String[]> relatorio5() throws Exception {
          ArrayList<String[]> vetor = new ArrayList<String[]>();
        String sql = "select q.* from quarto q inner join quarto_extra qe on (q.id = qe.id_quarto) inner join\n" +
"extra e on (qe.id_extra = e.id) where upper(e.descricao) = 'fogão'";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String[] dados = new String[5];
                dados[0] = rs.getInt("acomodacoes") + "";
                dados[1] = rs.getFloat("diaria") + "";
                dados[2] = rs.getString("status");
                vetor.add(dados);
            }
            return vetor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArrayList<String[]> relatorio6() throws Exception {
          ArrayList<String[]> vetor = new ArrayList<String[]>();
        String sql = "select *from quarto where acomodacoes > 2";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String[] dados = new String[5];
                dados[0] = rs.getInt("acomodacoes") + "";
                dados[1] = rs.getFloat("diaria") + "";
                dados[2] = rs.getString("status");
                vetor.add(dados);
            }
            return vetor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArrayList<String[]> relatorio7() throws Exception {
          ArrayList<String[]> vetor = new ArrayList<String[]>();
        String sql = "select h.nome, h.telefone from hospede h inner join reserva r on (h.id = r.id_hospede)";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String[] dados = new String[5];
                dados[0] = rs.getString("nome");
                dados[1] = rs.getString("telefone");
                vetor.add(dados);
            }
            return vetor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArrayList<String[]> relatorio8() throws Exception {
          ArrayList<String[]> vetor = new ArrayList<String[]>();
        String sql = "select p.* from produto p where p.id not in \n" +
"(select id_produto from produto_pedido pp inner join pedido p on(pp.id_pedido = p.id) inner join hospede h on (p.id_hospede = h.id) \n" +
"where h.cpf like '%1%')";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String[] dados = new String[5];
                dados[0] = rs.getInt("quantidade") + "";
                dados[1] = rs.getFloat("valor") + "";
                dados[2] = rs.getString("nome");
                vetor.add(dados);
            }
            return vetor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
  
}
