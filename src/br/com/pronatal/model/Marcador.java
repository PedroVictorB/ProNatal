/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.model;

import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;

/**
 *
 * @author pedro
 */
public class Marcador extends Marker{
    
    private int idMarcador;

    public Marcador(LatLng latlng) {
        super(latlng);
    }
    public Marcador(LatLng latlng, String title, int idMarcador){
        super(latlng, title);
        this.idMarcador = idMarcador;
    }
    public Marcador(LatLng latlng, String title, Object data){
        super(latlng, title, data);
    }
    public Marcador(LatLng latlng, String title, Object data, String icon){
        super(latlng, title, data, icon);
    }
    
    public Marcador(LatLng latlng, String title, Object data, String icon, String shadow){
        super(latlng, title, data, icon, shadow);
    }

    /**
     * @return the idMarcador
     */
    public int getIdMarcador() {
        return idMarcador;
    }

    /**
     * @param idMarcador the idMarcador to set
     */
    public void setIdMarcador(int idMarcador) {
        this.idMarcador = idMarcador;
    }
    
}
