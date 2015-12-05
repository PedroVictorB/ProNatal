package br.com.pronatal.dao;

import java.io.Serializable;
import java.util.ArrayList;

import org.primefaces.model.map.Marker;

import br.com.pronatal.model.Problem;

public class ProblemDAO implements IDAO<Problem>, Serializable{

	private static ProblemDAO problem; 
	
	private ArrayList<Problem> problems;
        private int id = 0;
	
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
                a.setId(id);
		problems.add(a);
                id++;
		return true;
	}

	@Override
	public boolean deletar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(Problem a) {
		for(Problem p : problems){
                    if(p.getId() == a.getId()){
                        p = a;
                        return true;
                    }
                }
		return false;
	}

	@Override
	public ArrayList<Problem> getAll() {
		return problems;
	}

	@Override
	public Problem getById(int id) {
            for(Problem p : problems){
                if(p.getId() == id){
                    return p;
                }
            }
            return null;
	}

}
