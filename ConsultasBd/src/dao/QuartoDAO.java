package dao;

import bd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Extra;
import model.Quarto;

/**
 *
 * @author Italo
 */
public class QuartoDAO implements ITquartoDAO {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private Conexao conexao;
    
    public QuartoDAO() {
        conexao = new Conexao();
        con = conexao.conectar();
    }

    public boolean salvar(Quarto obj) throws Exception{
        int idQuarto = create(obj);
        return this.salvarExtras(obj.getExtras(), idQuarto);
    }
    
    @Override
    public int create(Quarto obj) throws Exception {
        int idQuarto = 0;
        try {
            pst = con.prepareStatement("INSERT INTO quarto (acomodacoes,diaria,status) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, obj.getAcomodacoes());
            pst.setFloat(2, obj.getDiaria());
            pst.setString(3, obj.getStatus());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();

            while (rs.next()) {
                idQuarto = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new Exception("Erro ao salvar quarto. " + e.getMessage());
        }
        return idQuarto;
    }

    @Override
    public Object read() throws Exception {
        Quarto retorno = new Quarto();
        ArrayList<Quarto> vetor = new ArrayList<Quarto>();
        try {
            pst = con.prepareStatement("SELECT *FROM quarto");
            rs = pst.executeQuery();
            while (rs.next()) {
                Quarto q = new Quarto();
                q.setAcomodacoes(rs.getInt("acomodacoes"));
                q.setDiaria(rs.getFloat("diaria"));
                q.setStatus(rs.getString("status"));
                q.setId(rs.getInt("id"));
                vetor.add(q);
            }
            retorno.setQuartos(vetor);
            return retorno;
        } catch (Exception e) {
            throw new Exception("Erro ao consultar quartos. " + e.getMessage());
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        try {
            pst = con.prepareStatement("DELETE FROM quarto WHERE id = ?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao excluir quarto. " + e.getMessage());
        }
    }

    public boolean salvarExtras(ArrayList<Extra> lista, int idQuarto) throws Exception {
        try {
            pst = con.prepareStatement("INSERT INTO quarto_extra (id_quarto, id_extra) VALUES (?,?)");
            for (int i = 0; i < lista.size(); i++) {
                pst.setInt(1, idQuarto);
                pst.setInt(2, lista.get(i).getId());
                pst.execute();
            }
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao salvar extras do quarto." + e.getMessage());
        }
    }

    @Override
    public ArrayList<String> viewAllExtras(int idQuarto) throws Exception {
        ArrayList<String> extras = new ArrayList<String>();
        try{
            pst = con.prepareStatement("select e.descricao from quarto_extra qe inner join quarto as q on (q.id = qe.id_quarto)\n" +
"inner join extra as e on (qe.id_extra = e.id) where q.id = ?");
            pst.setInt(1, idQuarto);
            rs = pst.executeQuery();
            
            while(rs.next()){
                extras.add(rs.getString("descricao"));
            }
        }catch(Exception e){
            throw new Exception("Erro ao buscar extras do quarto.");
        }
        return extras;
    }

    public void fecharConexoes(){
        conexao.desconectar(con, pst, rs);
    }
    
    
}
