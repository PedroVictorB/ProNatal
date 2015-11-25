package br.com.pronatal.controller;

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
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;

@ManagedBean
@ViewScoped
public class MapController implements Serializable {

    private MapModel emptyModel;
    private Marker marker;
    private String title;
    private Problem problem;
    private ProblemService problemService;

    private int id;
    private double lat;
    private double lng;
    
    private int upVoteCount = 0;
    private int downVoteCount = 0;

    public MapController() {
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
        	//emptyModel.addOverlay(new Marcador(new LatLng(problem.getLatitude(), problem.getLongitude()), problem.getTitle(), problem.getId()));
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
        //Marcador marcador = (Marcador) event.getOverlay();
        //id = marcador.getIdMarcador();  
    } 

    public void onStateChange(StateChangeEvent event) {
        LatLngBounds bounds = event.getBounds();
        int zoomLevel = event.getZoomLevel();
    } 
    
    public void refresh() {  
        FacesContext context = FacesContext.getCurrentInstance();  
        Application application = context.getApplication();  
        ViewHandler viewHandler = application.getViewHandler();  
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());  
        context.setViewRoot(viewRoot);  
        context.renderResponse();  
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    public void upVote(){
        Problem p = problemService.getProblemById(id);   
        int vote = p.getUpVote();
        vote++;
        p.setUpVote(vote);
        problemService.updateProblem(p);
        setUpVoteCount(vote);
        System.out.println("Número de votos up do id "+p.getId()+" = "+vote);
    }
    
    public void downVote(){
        Problem p = problemService.getProblemById(id);
        int vote = p.getDownVote();
        vote++;
        p.setDownVote(vote);
        problemService.updateProblem(p);
        setDownVoteCount(vote);
        System.out.println("Número de votos down do id "+p.getId()+" = "+vote);
    }

    /**
     * @return the upVoteCount
     */
    public int getUpVoteCount() {
        return upVoteCount;
    }

    /**
     * @param upVoteCount the upVoteCount to set
     */
    public void setUpVoteCount(int upVoteCount) {
        this.upVoteCount = upVoteCount;
    }

    /**
     * @return the downVoteCount
     */
    public int getDownVoteCount() {
        return downVoteCount;
    }

    /**
     * @param downVoteCount the downVoteCount to set
     */
    public void setDownVoteCount(int downVoteCount) {
        this.downVoteCount = downVoteCount;
    }
}
