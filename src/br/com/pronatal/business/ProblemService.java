package br.com.pronatal.business;

import br.com.pronatal.dao.DAOFactory;

import br.com.pronatal.dao.IDAO;
import br.com.pronatal.model.Problem;
import java.util.ArrayList;
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
        
        public Problem retrieveProblemById(int id){
            return daoProblem.retrieveById(id);
        }
        
        public void updateProblem(Problem problem){
            daoProblem.update(problem);
        }
        
        public List<Problem> retrieveProblemsByUser(int userId) {
            List problems = daoProblem.retrieveAll();
            List<Problem> userProblems = new ArrayList<Problem>();
            for(int i = 0; i < problems.size(); i++) {
                Problem problem = (Problem) problems.get(i);
                if (problem.getUser().getId() == userId) {
                    userProblems.add(problem);
                }
            }
            return userProblems;
        }
}
