/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.main;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author pedro
 */
@ManagedBean(name = "MapMB")
@ViewScoped 
public class MapController implements Serializable{

    private static final long serialVersionUID = 5359528954148173473L;
    private MapModel model;   

    public MapController() {
        model = new DefaultMapModel();
    }

    public MapModel getModel() {
        System.out.println("Starting getModel");
        for (Marker m : model.getMarkers()) {
            System.out.println("--" + m.getLatlng().getLat() + "--" + m.getLatlng().getLng());
        }
        System.out.println("Ending getModel");
        return model;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        System.out.println("Marker Selected");
        Marker marker = (Marker) event.getOverlay();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Clicked Marker", marker.getTitle());
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

    public void onPointSelect(PointSelectEvent event) {
        System.out.println("Map Clicked");
        LatLng location = event.getLatLng();
        addMarker(location.getLat(), location.getLng());
    }

    private void addMarker(double lat, double lng) {
        System.out.println("Adding Marker " + lat + ", " + lng);
        // Clear out the model. I only want it holding one marker.
        //model = new DefaultMapModel();
        Marker marker = new Marker(new LatLng(lat, lng), "mkr");
        model.addOverlay(marker);
    }

}
