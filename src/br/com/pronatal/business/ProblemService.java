package br.com.pronatal.business;

import br.com.pronatal.dao.DAOFactory;

import br.com.pronatal.dao.IDAO;
import br.com.pronatal.model.Problem;
import java.util.List;

public class ProblemService {
	
	private IDAO<Problem> daoProblem;
	
	public ProblemService() {
            daoProblem = DAOFactory.getProblemDAO();
	}
	
	public void registerProblem(Problem problem) {
            daoProblem.create(problem);
	}
	
	public List<Problem> retrieveAllProblems() {
            return daoProblem.retrieveAll();
	}
        
        public Problem getProblemById(int id){
            return daoProblem.retrieveById(id);
        }
        
        public void updateProblem(Problem problem){
            daoProblem.update(problem);
        }
}
