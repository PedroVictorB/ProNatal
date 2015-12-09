/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.dao;

import br.com.pronatal.model.Problem;
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
public class ProblemDAO implements IDAO<Problem>, Serializable{
    
    private static ProblemDAO instance;
    
    public static ProblemDAO getInstance(){
        if(instance == null){
            return new ProblemDAO();
        }
        return instance;
    }

    @Override
    public void create(Problem obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Create exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Problem obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Problem retrieve(Problem obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createSQLQuery(
                    "select * from problem p where p.id = :id")
                    .addEntity(Problem.class)
                    .setParameter("id", obj.getId());
            List result = query.list();
            
            if (result.isEmpty()) {
                return null;
            } else {
                return (Problem) result.get(0);
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
    public List<Problem> retrieveAll() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List<Problem> list = session.createCriteria(Problem.class).list();
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
    public Problem retrieveById(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Problem p = session.get(Problem.class, id);
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
