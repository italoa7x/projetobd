package dao;

import bd.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pedido;
import model.Produto;

/**
 *
 * @author Italo
 */
public class PedidoDAO implements ITpedidoDAO {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private ProdutoDAO produtodao;
    private Conexao conexao;
    
    public PedidoDAO() {
        conexao = new Conexao();
        con = conexao.conectar();
    }

    @Override
    public boolean create(Object obj) throws Exception {
        Pedido pedido = (Pedido) obj;
        int idPedido = -1;
        try {
            pst = con.prepareStatement("INSERT INTO pedido (id_hospede,data_pedido) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, pedido.getIdHospede());
            pst.setDate(2, new Date(System.currentTimeMillis()));
            pst.execute();
            rs = pst.getGeneratedKeys();

            while (rs.next()) {
                idPedido = rs.getInt(1);
            }

        } catch (Exception e) {
            throw new Exception("Erro ao salvar pedido. " + e.getMessage());
        }
        if (idPedido > -1) {
            if (this.salvaProdutoPedido(idPedido, pedido.getProdutos())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object read() throws Exception {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        try {
            pst = con.prepareStatement("select p.id as codigo, h.nome hospede, prod.nome as produto, (pp.quantidade * prod.valor) as total, p.data_pedido from\n"
                    + "pedido p inner join produto_pedido pp on (p.id = pp.id_pedido) inner join produto prod\n"
                    + "on (pp.id_produto = prod.id) inner join hospede h on (h.id = p.id_hospede)");

            rs = pst.executeQuery();
            while (rs.next()) {
                String[] dados = new String[5];
                dados[0] = rs.getInt("codigo") + "";
                dados[1] = rs.getString("hospede");
                dados[2] = rs.getString("produto");
                dados[3] = rs.getDouble("total") + "";
                dados[4] = rs.getDate("data_pedido") + "";
                lista.add(dados);
            }

        } catch (Exception e) {
            throw new Exception("Erro ao buscar registro de pedidos. " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean salvaProdutoPedido(int idPedido, ArrayList<Produto> listaProdutos) throws Exception {
        try {
            pst = con.prepareStatement("INSERT INTO produto_pedido (id_pedido, id_produto, quantidade) VALUES (?,?,?)");
            for (Produto x : listaProdutos) {
                pst.setInt(1, idPedido);
                pst.setInt(2, x.getId());
                pst.setInt(3, x.getQuantidade());
                pst.execute();
            }
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao salvar produtos do pedido. " + e.getMessage());
        }
    }
   
}
