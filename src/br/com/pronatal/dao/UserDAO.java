/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.dao;

import br.com.pronatal.model.User;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class UserDAO implements IDAO<User>, Serializable {

    private static UserDAO user;

    private ArrayList<User> users;

    private int id = 0;

    private UserDAO() {
        users = new ArrayList<>();
        User user = new User();
        user.setEmail("brunomoreira@hotmail.com");
        user.setPassword("123");
        cadastrar(user);
    }

    public static UserDAO getInstance() {
        if (user == null) {
            user = new UserDAO();
        }
        return user;
    }

    @Override
    public boolean cadastrar(User a) {
        if (existsUser(a) == null) {
            a.setId(id);
            users.add(a);
            id++;
        } else {
            return false;
        }
        users.stream().forEach((us) -> {
            System.out.println("" + us.getId());
        });
        return true;
    }

    @Override
    public boolean deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(User a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User existsUser(User u) {
        for (User us : users) {
            if (us.getEmail().equals(u.getEmail()) && us.getPassword().equals(u.getPassword())) {
                return us;
            }
        }
        return null;
    }

}
