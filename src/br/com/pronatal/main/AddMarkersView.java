package br.com.pronatal.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.StateChangeEvent;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.LatLngBounds;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.pronatal.business.ProblemService;
import br.com.pronatal.model.Problem;

@ManagedBean
@ViewScoped
public class AddMarkersView implements Serializable {

    private MapModel emptyModel;
    private Marker marker;
    private String title;
    private Problem problem;
    private ProblemService problemService;

    private double lat;
    private double lng;

    public AddMarkersView() {
        problemService = new ProblemService();
	}
    
    @PostConstruct
    public void init() {
    	
    	System.out.println("Carregando problems");
    	
        emptyModel = new DefaultMapModel();
        
        ArrayList<Problem> problems = problemService.retrieveAllProblems();
        Iterator<Problem> it = problems.iterator();
        while (it.hasNext()) {
        	Problem problem = it.next();
        	Marker marker = new Marker(new LatLng(problem.getLatitude(), problem.getLongitude()), problem.getTitle());
        	emptyModel.addOverlay(marker);
        }
        
    }

    public MapModel getEmptyModel() {
        return emptyModel;
    }

    
    public Problem getProblem() {
    	if (problem == null) {
    		problem = new Problem();
    	}
    	return problem;
    }
    
    public void setProblem(Problem problem) {
    	this.problem = problem;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void addMarker() {
    	if (problemService == null) {
    		problemService = new ProblemService();
    	}
    	
    	problemService.registerProblem(problem);
        setMarker(new Marker(new LatLng(problem.getLatitude(), problem.getLongitude()), problem.getTitle()));
        
        emptyModel.addOverlay(getMarker());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
    }

    /**
     * @return the marker
     */
    public Marker getMarker() {
        return marker;
    }

    /**
     * @param marker the marker to set
     */
    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    } 

    public void onStateChange(StateChangeEvent event) {
        LatLngBounds bounds = event.getBounds();
        int zoomLevel = event.getZoomLevel();
    }
}
