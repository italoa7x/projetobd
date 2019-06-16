/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author darkc
 */
public class Pedido {
    private int idHospede, idFuncionario;
    private ArrayList<Produto> produtos;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    

    public int getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(int idHospede) {
        this.idHospede = idHospede;
    }
    
}
