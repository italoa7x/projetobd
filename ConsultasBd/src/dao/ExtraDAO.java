package dao;

import bd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Extra;

/**
 *
 * @author Italo
 */
public class ExtraDAO implements ITextraDAO {
    private Conexao conexao;

    public ExtraDAO() {
        conexao = new Conexao();
    }
    
    @Override
    public ArrayList<Extra> read() throws Exception {
        ArrayList<Extra> vetor = new ArrayList<Extra>();
        try {
            Connection con = conexao.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT *FROM extra");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                Extra x = new Extra();
                x.setNome(rs.getString("descricao"));
                x.setId(rs.getInt("id"));
                vetor.add(x);
            }
            conexao.desconectar(con, pst, rs);
            return vetor;
        } catch (Exception e) {
            throw new Exception("Erro ao consultas extras. " + e.getMessage());
        }
    }

    
}
