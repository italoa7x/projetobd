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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.exolab.castor.types.Date;

/**
 *
 * @author darkc
 */
public class RelatorioDAO {

    private Conexao conexao;
    private Connection con;

    public RelatorioDAO() {
        conexao = new Conexao();
        con = conexao.conectar();
    }

    public ArrayList<String[]> relatorio(String data, String ordemExibicao) throws Exception {
        ResultSet rs = null;
        ArrayList<String[]> vetor = new ArrayList<String[]>();
        String sql = "select q.id Quarto, q.diaria Diaria_quarto, h.nome Hospede, (pp.quantidade * prod.valor) Total_pedido, p.valor Valor_estadia from hospede h\n"
                    + "inner join reserva r on (h.id = r.id_hospede) inner join pagamento p on (p.id_reserva = r.id) inner join quarto q on \n"
                    + "(q.id = r.id_quarto) inner join pedido pe on (pe.id_hospede = h.id) inner join produto_pedido pp on (pe.id = pp.id_pedido) inner join produto prod\n"
                    + "on (pp.id_produto = prod.id) where pe.data_pedido = ? order by h.nome = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, java.sql.Date.valueOf(data));
            pst.setString(2, ordemExibicao);
            rs = pst.executeQuery();
            while(rs.next()){
                String[] dados = new String[5];
                dados[0] = rs.getInt("Quarto") + "";
                dados[1] = rs.getFloat("Diaria_quarto") + "";
                dados[2] = rs.getString("Hospede");
                dados[3] = rs.getFloat("Total_pedido") + "";
                dados[4] = rs.getFloat("Valor_estadia") + "";
                vetor.add(dados);
            }
            return vetor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
