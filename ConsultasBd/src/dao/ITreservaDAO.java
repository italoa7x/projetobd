/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Reserva;

/**
 *
 * @author darkc
 */
public interface ITreservaDAO {
    
    public boolean salvar(Reserva obj) throws Exception;
    
    public ArrayList<String[]> listar() throws Exception;
    
}
