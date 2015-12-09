package br.com.pronatal.controller;

import javax.faces.bean.ManagedBean;

import br.com.pronatal.business.ProblemService;
import br.com.pronatal.model.Marker;
import br.com.pronatal.model.Problem;
import br.com.pronatal.model.User;
import br.com.pronatal.utils.Session;
import com.google.gson.Gson;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="problemBean")
@SessionScoped
public class ProblemBean {
    private String name;
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
        HttpSession session = Session.getSession();
        problem.setUser((User)session.getAttribute("user"));
        problem.setDate(new Date());
        problemService.registerProblem(problem);
        problem = new Problem();
    }
    
    public String retrieveAllProblems () {
        return new Gson().toJson(problemService.retrieveAllProblems());
    }
    
    public List<Problem> retrieveAll () {
        return problemService.retrieveAllProblems();
    }
    
    public int getNumberOfProblems() {
        return problemService.retrieveAllProblems().size();
    }
    
    public List<Problem> retrieveProblemsByUser() {
        HttpSession session = Session.getSession();
        User user = (User)session.getAttribute("user");
        return problemService.retrieveProblemsByUser(user.getId());
    }
    
    public int getNumberOfProblemsByUser() {
        HttpSession session = Session.getSession();
        User user = (User)session.getAttribute("user");
        return problemService.retrieveProblemsByUser(user.getId()).size();
    }
}
