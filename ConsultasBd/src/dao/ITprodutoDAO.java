package dao;

import model.Produto;


/**
 *
 * @author Italo
 */
public interface ITprodutoDAO {

    public boolean create(Object obj) throws Exception;

    public Object read() throws Exception;

    public boolean delete(int id) throws Exception;

    public Produto search(String name) throws Exception;
}
