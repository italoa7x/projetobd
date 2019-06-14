package dao;

import java.util.ArrayList;
import model.Extra;

/**
 *
 * @author Italo
 */
public interface ITextraDAO {

    public ArrayList<Extra> read() throws Exception;
    
}
