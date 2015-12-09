/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.dao;

import br.com.pronatal.model.Comment;
import br.com.pronatal.utils.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pedro
 */
public class CommentDAO implements IDAO<Comment>, Serializable {

    private static CommentDAO instance;
    
    public static CommentDAO getInstance(){
        if(instance == null){
            return new CommentDAO();
        }
        return instance;
    }
    
    @Override
    public void create(Comment obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
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
    public void update(Comment obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comment retrieve(Comment obj) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createSQLQuery(
                    "select * from comment c where c.id = :id")
                    .addEntity(Comment.class)
                    .setParameter("id", obj.getId());
            List result = query.list();
            
            if (result.isEmpty()) {
                return null;
            } else {
                return (Comment) result.get(0);
            }
        } catch (HibernateException e) {
            System.out.println("Retrieve exception: " + e.getMessage());
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Comment> retrieveAll() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List<Comment> list = session.createCriteria(Comment.class).list();
            return list;
        } catch (Exception e) {
            System.out.println("retrieve all exception: " + e.getMessage());
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Comment retrieveById(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Comment p = session.get(Comment.class, id);
            return p;
        } catch (Exception e) {
            System.out.println("retrieve all exception: " + e.getMessage());
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}
