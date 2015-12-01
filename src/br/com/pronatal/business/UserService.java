/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.business;

import br.com.pronatal.dao.UserDAO;
import br.com.pronatal.model.User;
import java.io.Serializable;

/**
 *
 * @author pedro
 */
public class UserService implements Serializable{
    
    public boolean register(User u){
        if(!u.getName().equals("") && !u.getPassword().equals("")){
            return UserDAO.getInstance().cadastrar(u);
        }
        return false;
    }
    
    public User login(User u){
        if(!u.getEmail().equals("") && !u.getPassword().equals("")){
            return UserDAO.getInstance().existsUser(u);
        }
        return null;
    }
    
}
