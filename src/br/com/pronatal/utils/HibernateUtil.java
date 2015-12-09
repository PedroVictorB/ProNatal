/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.utils;

import br.com.pronatal.model.Marker;
import br.com.pronatal.model.Problem;
import br.com.pronatal.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author pedro
 */
public class HibernateUtil {
 
    private static SessionFactory sessionFactory;
 
    private static SessionFactory buildSessionFactory() {
        try {
        	Configuration cfg = new Configuration();
                cfg.configure("hibernate.cfg.xml");
                cfg.addAnnotatedClass(User.class);
                cfg.addAnnotatedClass(Problem.class);
                cfg.addAnnotatedClass(Marker.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
                SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        	return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
 
}
