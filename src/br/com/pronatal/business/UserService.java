/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.business;

import br.com.pronatal.dao.DAOFactory;
import br.com.pronatal.dao.IDAO;
import br.com.pronatal.model.User;
import java.io.Serializable;

/**
 *
 * @author pedro
 */
public class UserService implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private IDAO<User> daoUser;
    
    public UserService() {
        daoUser = DAOFactory.getUserDAO();
    }
    
    public void register(User u) throws Exception{
        if(!u.getName().equals("") && !u.getPassword().equals("")){
            daoUser.create(u);
        }
        else {
            throw new Exception("Error ao registrar usuário");
        }
    }
    
    public User login(User u){
        if(!u.getEmail().equals("") && !u.getPassword().equals("")){
            System.out.println("Chegou aqui 1");
            return daoUser.retrieve(u);
        }
        return null;
    }
    
}
