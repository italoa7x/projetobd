package dao;

import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author Italo
 */
public interface ITfuncionarioDAO {

    public boolean create(Object obj) throws Exception;

    public ArrayList<Funcionario> read() throws Exception;

    public boolean update(Object obj) throws Exception;

    public boolean delete(int id) throws Exception;
    
    public Funcionario acessSystem(String nome, String  cpf) throws Exception;

    public void fecharConexoes();
}
