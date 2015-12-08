/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.controller;

import br.com.pronatal.business.UserService;
import br.com.pronatal.model.User;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 *
 * @author pedro
 */
@ManagedBean
@RequestScoped
public class RegisterBean implements Serializable{
    
    private static final long serialVersionUID = 7863262235394607247L;
    
    private User user;
    private UserService service;
    
    public RegisterBean(){
        
    }
    
    @PostConstruct
    public void init() {
        this.setUser(new User());
        service = new UserService();
    }
    
    public String register() {
        String result = "";
        try {
            service.register(getUser());
            System.out.println("registro: "+getUser().getEmail());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário Cadastrado!", "Bem vindo, "+getUser().getName()+"! Logue-se para usar o ProNatal!"));
            user = new User();
            user.setBirthDate(new Date());
            user.setEmail("");
            user.setId(0);
            user.setName("");
            user.setPassword("");
            result = "index";
        } catch (Exception ex) {
            Logger.getLogger(RegisterBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro de cadastro", "Cadastro não pode ser feito."));
        }
        return result;
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
}
