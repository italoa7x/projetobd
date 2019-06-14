package model;

import java.util.ArrayList;

/**
 *
 * @author darkc
 */
public class Hospede {
    private String nome,cpf,telefone,email;
    private int id;
    private ArrayList<Hospede> listaHospede;

    public ArrayList<Hospede> getListaHospede() {
        return listaHospede;
    }

    public void setListaHospede(ArrayList<Hospede> listaHospede) {
        this.listaHospede = listaHospede;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
