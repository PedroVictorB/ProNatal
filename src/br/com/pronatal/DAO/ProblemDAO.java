package br.com.pronatal.dao;

import java.io.Serializable;
import java.util.ArrayList;

import org.primefaces.model.map.Marker;

import br.com.pronatal.model.Problem;

public class ProblemDAO implements IDAO<Problem>, Serializable{

	private static ProblemDAO problem;
	
	private ArrayList<Problem> problems;
	
	private ProblemDAO () {
		problems = new ArrayList<Problem>();
	}
	
	public static ProblemDAO getInstance() {
		if (problem == null) {
			problem = new ProblemDAO();
		}
		return problem;
	}
	
	@Override
	public boolean cadastrar(Problem a) {
		// TODO Auto-generated method stub
		problems.add(a);
		return true;
	}

	@Override
	public boolean deletar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(Problem a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Problem> getAll() {
		return problems;
	}

	@Override
	public Problem getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
