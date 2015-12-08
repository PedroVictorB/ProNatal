package br.com.pronatal.dao;

import br.com.pronatal.model.Marker;
import java.io.Serializable;
import java.util.ArrayList;


import br.com.pronatal.model.Problem;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProblemDAOMemory implements IDAO<Problem>, Serializable{

    private static ProblemDAOMemory instance; 

    private ArrayList<Problem> problems;
    private int id = 0;

    ProblemDAOMemory () {
        problems = new ArrayList<Problem>();
    }

    public static ProblemDAOMemory getInstance() {
        if (instance == null) {
            instance = new ProblemDAOMemory();
        }
        return instance;
    }

    @Override
    public void create(Problem problem) {
        problem.setId(id);
        problems.add(problem);
        id++;
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
    }

    @Override
    public void update(Problem problem) {
        for(Problem p : problems){
            if(p.getId() == problem.getId()){
                p = problem;
            }
        }
    }
    
    @Override
    public Problem retrieve(Problem problem) {
        return null;
    }

    @Override
    public List<Problem> retrieveAll() {
        return problems;
    }

    @Override
    public Problem retrieveById(int id) {
        for(Problem p : problems){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

}
