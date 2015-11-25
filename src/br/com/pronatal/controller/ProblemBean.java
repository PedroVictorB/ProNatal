package br.com.pronatal.controller;

import javax.faces.bean.ManagedBean;

import br.com.pronatal.business.ProblemService;
import br.com.pronatal.model.Problem;

@ManagedBean
public class ProblemBean {
	private Problem problem;
	private ProblemService problemService;
	
	public ProblemBean () {
		problemService = new ProblemService();
	}
	
	public void support() {
	}
	
	public void notSupport() {
		
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}
}
