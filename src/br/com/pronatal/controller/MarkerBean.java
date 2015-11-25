package br.com.pronatal.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.map.LatLng;

import br.com.pronatal.business.ProblemService;
import br.com.pronatal.model.Marker;
import br.com.pronatal.model.Problem;

@ManagedBean
public class MarkerBean {
	private Marker marker;
	private List<Marker> markers;
	private ProblemService problemService;
	
	public Marker getMarker() {
		return marker;
	}
	
	public void setMarker(Marker marker) {
		this.marker = marker;
	}
	
	public void loadMarkers() {
		
	}
}
