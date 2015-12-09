/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.dao;

import br.com.pronatal.exception.UserException;
import br.com.pronatal.model.User;
import br.com.pronatal.utils.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pedro
 */
public class UserDAO implements IDAO<User>, Serializable {

    private static UserDAO instance;

    private UserDAO() {

    }

    public static UserDAO getInstance() {
        if (instance != null) {
            return instance;
        }
        return new UserDAO();
    }

    @Override
    public void create(User obj) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Create exception: " + e.getMessage());
        }
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User retrieve(User obj) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createSQLQuery(
                    "select * from user u where u.email = :email")
                    .addEntity(User.class)
                    .setParameter("email", obj.getEmail());
            List result = query.list();
            
            if (result.isEmpty()) {
                return null;
            } else {
                return (User) result.get(0);
            }
        } catch (HibernateException e) {
            System.out.println("Retrieve exception: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<User> retrieveAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User retrieveById(int id) {
        try {
            User l;
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            l = (User) session.load(User.class, id);
            if (l == null) {
                throw new UserException();
            } else {
                return l;
            }
        } catch (HibernateException | UserException e) {
            System.out.println("retrieve by id exception: " + e.getMessage());
            return null;
        }
    }

}
