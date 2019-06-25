package dao;
import bd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Hospede;

/**
 *
 * @author Italo
 */
public class HospedeDAO implements IThospedeDAO {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;
    private Conexao conexao;

    public HospedeDAO() {
        conexao = new Conexao();
        con = conexao.conectar();
    }

    public boolean create(Hospede obj) throws Exception {
        String sql = "INSERT INTO hospede(nome,cpf,telefone,email) VALUES (?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCpf());
            pst.setString(3, obj.getTelefone());
            pst.setString(4, obj.getEmail());
            pst.execute();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao salvar hospede. " + e.getMessage());
        }
    }

    public Hospede read() throws Exception {
        Hospede retorno = new Hospede();
        ArrayList<Hospede> vetor = new ArrayList<Hospede>();
        try {
            String sql = "SELECT *FROM hospede";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Hospede h = new Hospede();
                h.setNome(rs.getString("nome"));
                h.setCpf(rs.getString("cpf"));
                h.setTelefone(rs.getString("telefone"));
                h.setId(rs.getInt("id"));
                h.setEmail(rs.getString("email"));
                vetor.add(h);
            }
            retorno.setListaHospede(vetor);
        } catch (Exception e) {
            throw new Exception("Erro ao consultar hospedes. " + e.getMessage());
        }
        return retorno;
    }

    public boolean delete(int id) throws Exception {
        try {
            pst = con.prepareStatement("DELETE FROM hospede WHERE id = ?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao excluir hospede. " + e.getMessage());
        }
    }

    public boolean update(Hospede obj) throws Exception {
        try {
            Hospede hospede = (Hospede) obj;
            pst = con.prepareStatement("UPDATE hospede SET nome = ?, cpf = ?, email = ?, telefone = ? WHERE id = ?");
            pst.setString(1, hospede.getNome());
            pst.setString(2, hospede.getCpf());
            pst.setString(3, hospede.getEmail());
            pst.setString(4, hospede.getTelefone());
            pst.setInt(5, hospede.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar dado do hospede. " + e.getMessage());
        }
    }

    public Hospede search(String name) throws Exception {
        try {
            Hospede retorno = new Hospede();
            String sql = "SELECT *FROM hospede WHERE nome LIKE ? LIMIT 1";
            pst = con.prepareStatement(sql);
            pst.setString(1, name + "%");

            rs = pst.executeQuery();
            while (rs.next()) {
                retorno.setCpf(rs.getString("cpf"));
                retorno.setNome(rs.getString("nome"));
                retorno.setId(rs.getInt("id"));
                retorno.setEmail(rs.getString("email"));
                retorno.setTelefone(rs.getString("telefone"));
            }
            return retorno;
        } catch (Exception e) {
            throw new Exception("Erro ao consultar hospedes. " + e.getMessage());
        }
    }

}
