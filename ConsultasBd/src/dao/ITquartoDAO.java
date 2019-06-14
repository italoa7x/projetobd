package dao;

import java.util.ArrayList;
import model.Extra;
import model.Quarto;

/**
 *
 * @author Italo
 */
public interface ITquartoDAO {


    public int create(Quarto obj) throws Exception;

    public Object read() throws Exception;

    public boolean delete(int id) throws Exception;
    
    public boolean salvarExtras(ArrayList<Extra> lista, int idQuarto) throws Exception;
    
    public ArrayList<String> viewAllExtras(int idQuarto) throws Exception;
}
