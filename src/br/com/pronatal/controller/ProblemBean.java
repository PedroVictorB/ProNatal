package br.com.pronatal.controller;

import javax.faces.bean.ManagedBean;

import br.com.pronatal.business.ProblemService;
import br.com.pronatal.model.Marker;
import br.com.pronatal.model.Problem;
import com.google.gson.Gson;
import java.util.ArrayList;
import static java.util.Collections.list;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="problemBean")
@SessionScoped
public class ProblemBean {
    private Problem problem;
    private ProblemService problemService;

    public ProblemBean () {
        problem = new Problem();
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
    
    public void create() {
        problemService.registerProblem(problem);
        problem = new Problem();
    }
    
    public String retrieveAllProblems () {
        return new Gson().toJson(problemService.retrieveAllProblems());
    }
}
