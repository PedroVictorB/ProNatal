package br.com.pronatal.dao;

import br.com.pronatal.model.Marker;
import java.io.Serializable;
import java.util.ArrayList;


import br.com.pronatal.model.Problem;

public class ProblemDAO implements IDAO<Problem>, Serializable{

    private static ProblemDAO problem; 

    private ArrayList<Problem> problems;
    private int id = 0;

    private ProblemDAO () {
        problems = new ArrayList<Problem>();
        Problem p1 = new Problem();
        Problem p2 = new Problem();
        p1.setTitle("Test 1");
        p1.setDescription("Teste 1");
        p1.setMarker(new Marker(-5.838543909700438, -35.218705236911774));
        p2.setMarker(new Marker(-5.855279206147372, -35.22282510995865));
        cadastrar(p1);
        cadastrar(p2);
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
