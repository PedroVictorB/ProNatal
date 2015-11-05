package br.com.pronatal.model;

import org.primefaces.model.map.Marker;

import br.com.pronatal.utils.ProblemStatus;

public class Problem {
	private int id;
	private int userId;
	private String title;
	private String category;
	private String description;
	private int numberOfFollowers;
	private Marker marker;
	private ProblemStatus problemStatus;
}
