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
import model.Produto;

/**
 *
 * @author italo
 */
public class ProdutoDAO implements ITprodutoDAO {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private Conexao conexao;

    public ProdutoDAO() {
        conexao = new Conexao();
        con = conexao.conectar();
    }

    @Override
    public boolean create(Object obj) throws Exception {
        try {
            Produto produto = (Produto) obj;
            pst = con.prepareStatement("INSERT INTO produto(nome,valor,quantidade) VALUES (?,?,?)");
            pst.setString(1, produto.getNome());
            pst.setFloat(2, produto.getValor());
            pst.setInt(3, produto.getQuantidade());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao salva funcionário. " + e.getMessage());
        }
    }

    @Override
    public Object read() throws Exception {
        Produto retorno = new Produto();
        ArrayList<Produto> vetor = new ArrayList<Produto>();
        try {
            pst = con.prepareStatement("SELECT *FROM produto");
            rs = pst.executeQuery();
            while (rs.next()) {
                Produto atual = new Produto();
                atual.setNome(rs.getString("nome"));
                atual.setValor(rs.getFloat("valor"));
                atual.setQuantidade(rs.getInt("quantidade"));
                atual.setId(rs.getInt("id"));
                vetor.add(atual);
            }
            retorno.setProdutosCadastrados(vetor);
            return retorno;
        } catch (Exception e) {
            throw new Exception("Erro ao consultar produtos. " + e.getMessage());
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        try {
            pst = con.prepareStatement("DELETE FROM produto WHERE id = ?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao excluir produto. " + e.getMessage());
        }
    }

    @Override
    public Produto search(String name) throws Exception {
        try {
            Produto produto = new Produto();
            pst = con.prepareStatement("SELECT *FROM produto WHERE nome LIKE ? LIMIT 1");
            pst.setString(1, "%" + name + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produto.setId(rs.getInt("id"));
            }
            return produto;
        } catch (Exception e) {
            throw new Exception("Erro ao excluir produto. " + e.getMessage());
        }
    }

    public int buscaQuantidade(int idProduto) throws Exception {
        try {
            pst = con.prepareStatement("SELECT quantidade as quant FROM produto WHERE id = ?");
            pst.setInt(1, idProduto);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("quant");
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar quantidade de produtos. " + e.getMessage());
        }
        return 0;
    }

}
