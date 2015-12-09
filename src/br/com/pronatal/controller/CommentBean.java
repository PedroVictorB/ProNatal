package br.com.pronatal.controller;

import br.com.pronatal.business.CommentService;
import br.com.pronatal.business.ProblemService;
import javax.faces.bean.ManagedBean;

import br.com.pronatal.model.Comment;
import br.com.pronatal.model.Problem;
import br.com.pronatal.model.User;
import br.com.pronatal.utils.Session;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="commentBean")
@SessionScoped
public class CommentBean {
    private Comment comment;
    
    private ProblemService problemService;
    
    private CommentService commentService;

    public CommentBean () {
        comment = new Comment();
        commentService = new CommentService();
        problemService = new ProblemService();
    }

    public Comment getComment() {
            return comment;
    }

    public void setComment (Comment comment) {
            this.comment = comment;
    }

    public void create() {
        HttpSession session = Session.getSession();
        comment.setUser((User)session.getAttribute("user"));
        comment.setDate(new Date());
        
        String problemId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("problemId");
        comment.setProblem(problemService.retrieveProblemById(Integer.parseInt(problemId)));
        
        commentService.registerComment(comment);
        comment = new Comment();
    }

    public String delete() {
            return "removed";
    }
    
    public List<Comment> retrieveAll () {
        ArrayList<Comment> a = new ArrayList<Comment>();
        Comment c = new Comment();
        c.setComment("asdadadasd");
        User u = new User();
        u.setName("Brunno");
        c.setUser(u);
        a.add(c);
        return a;
    }
}
