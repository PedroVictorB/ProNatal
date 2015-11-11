/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import org.primefaces.model.map.Marker;

/**
 *
 * @author pedro
 */
public class MarkerDAO implements IDAO<Marker>, Serializable{
    
    private static MarkerDAO instance;
    
    ArrayList<Marker> lista;
    
    private MarkerDAO(){
        lista = new ArrayList<>();
    }
    
    public static MarkerDAO getInstance(){
        if(instance == null){
            return new MarkerDAO();
        }
        return instance;
    }

    @Override
    public boolean cadastrar(Marker a) {
        lista.add(a);
        return true;
    }

    @Override
    public boolean deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(Marker a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Marker> getAll() {
        return lista;
    }

    @Override
    public Marker getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
