package dao;

import bd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author Italo
 */
public class FuncionarioDAO implements ITfuncionarioDAO {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private Conexao conexao;

    public FuncionarioDAO() {
        conexao = new Conexao();
        con = conexao.conectar();
    }

    public boolean create(Object obj) throws Exception {
        try {
            Funcionario funcionario = (Funcionario) obj;
            pst = con.prepareStatement("INSERT INTO funcionario(nome,telefone,cpf,cargo) VALUES (?,?,?,?)");
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getTelefone());
            pst.setString(3, funcionario.getCpf());
            pst.setString(4, funcionario.getCargo());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao salva funcionário. " + e.getMessage());
        }
    }

    public ArrayList<Funcionario> read() throws Exception {
        Funcionario retorno = new Funcionario();
        ArrayList<Funcionario> vetor = new ArrayList<Funcionario>();
        try {
            pst = con.prepareStatement("SELECT *FROM funcionario");
            rs = pst.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setTelefone(rs.getString("telefone"));
                f.setCargo(rs.getString("cargo"));
                f.setId(rs.getInt("id"));
                vetor.add(f);
            }
            return vetor;
        } catch (Exception e) {
            throw new Exception("Erro ao consultar funcionários. " + e.getMessage());
        }
    }

    public boolean update(Object obj) throws Exception {
        try {
            Funcionario funcionario = (Funcionario) obj;
            pst = con.prepareStatement("UPDATE funcionario SET nome = ?, cpf = ?, cargo = ?, telefone = ? WHERE id = ?");
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getCpf());
            pst.setString(3, funcionario.getCargo());
            pst.setString(4, funcionario.getTelefone());
            pst.setInt(5, funcionario.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar dado do funcionário. " + e.getMessage());
        }
    }

    public boolean delete(int id) throws Exception {
        try {
            pst = con.prepareStatement("DELETE FROM funcionario WHERE id = ?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao excluir funcionário. " + e.getMessage());
        }
    }

    public Funcionario acessSystem(String cpf, String cargo) throws Exception {
        Funcionario logado = new Funcionario();
        try {
            pst = con.prepareStatement("SELECT *FROM funcionario WHERE cpf = ? and cargo = ?");
            pst.setString(1, cpf);
            pst.setString(2, cargo);
            rs = pst.executeQuery();
            while (rs.next()) {
                logado.setNome(rs.getString("nome"));
                logado.setCargo(rs.getString("cargo"));
                logado.setId(rs.getInt("id"));
                logado.setTelefone(rs.getString("telefone"));
            }

        } catch (Exception e) {
            throw new Exception("Erro ao acessar o sistema. " + e.getMessage());
        }
        return logado;
    }

    public void fecharConexoes() {
        conexao.desconectar(con, pst, rs);
    }
}
