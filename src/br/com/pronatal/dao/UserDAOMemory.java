/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.dao;

import br.com.pronatal.model.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class UserDAOMemory implements IDAO<User>, Serializable {

    private static UserDAOMemory user;

    private ArrayList<User> users;

    private int id = 0;

    UserDAOMemory() {
        users = new ArrayList<>();
        addAdminUser();
    }

    public static UserDAOMemory getInstance() {
        if (user == null) {
            user = new UserDAOMemory();
        }
        return user;
    }

    @Override
    public void create(User user) {
        System.out.println("Chegou aqui Brunno");
        if (retrieve(user) == null) {
            System.out.println("Chegou aqui Fabio");
            user.setId(id);
            users.add(user);
            id++;
        }
        System.out.println("Tamanho: " + users.size());
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User retrieve(User user) {
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
                return u;
            }
        }
        return null;
    }
    
    @Override
    public List<User> retrieveAll() {
        return users;
    }

    @Override
    public User retrieveById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    private void addAdminUser() {
        User user = new User();
        user.setName("Admin");
        user.setEmail("admin@admin.com");
        user.setPassword("admin@admin.com");
        create(user);
    }
}
