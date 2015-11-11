package br.com.pronatal.business;

import java.util.ArrayList;

import br.com.pronatal.dao.IDAO;
import br.com.pronatal.dao.ProblemDAO;
import br.com.pronatal.model.Problem;

public class ProblemService {
	
	private IDAO<Problem> daoProblem;
	
	public ProblemService() {
		daoProblem = ProblemDAO.getInstance();
	}
	
	public void registerProblem(Problem a) {
		daoProblem.cadastrar(a);
	}
	
	public ArrayList<Problem> retrieveAllProblems() {
		return daoProblem.getAll();
	}
}
