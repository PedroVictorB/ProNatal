/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.controller;

import br.com.pronatal.business.UserService;
import br.com.pronatal.model.User;
import br.com.pronatal.utils.Session;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pedro
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable{
    
    private User user;
    private UserService service;
    private String teste = "teste";
    
    @PostConstruct
    public void init() {
        this.setUser(new User());
        service = new UserService();
    }
    
    public String login() {
        User user = service.login(getUser());
        if (user != null) {
            HttpSession session = Session.getSession();
            session.setAttribute("user", user);
            this.user = user;
            System.out.println("Logado: "+user.getName());
            return "index";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Email ou senha incorretos","Por favor digite os campos corretamente."));
            return "index";
        }
    }
    
    public String logout() {
        HttpSession session = Session.getSession();
        session.invalidate();
        return "index";
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the teste
     */
    public String getTeste() {
        return teste;
    }

    /**
     * @param teste the teste to set
     */
    public void setTeste(String teste) {
        this.teste = teste;
    }
}
