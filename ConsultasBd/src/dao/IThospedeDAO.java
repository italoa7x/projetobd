/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Hospede;

/**
 *
 * @author Italo
 */
public interface IThospedeDAO {

    public boolean create(Hospede obj) throws Exception;

    public Hospede read() throws Exception;

    public boolean delete(int id) throws Exception;

    public boolean update(Hospede obj) throws Exception;
    
    public Hospede search(String name) throws Exception;
}
