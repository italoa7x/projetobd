package dao;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author Italo
 */
public interface ITpedidoDAO {

    public boolean create(Object obj) throws Exception;

    public Object read() throws Exception;

    public boolean delete(int id) throws Exception;
    
    public boolean salvaProdutoPedido(int idPedido, ArrayList<Produto> listaProdutos) throws Exception;
    
}
