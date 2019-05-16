/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author almand
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
//    static {
//        try {
////            Configuration config = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
////            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
////            serviceRegistryBuilder.applySettings(config.getProperties());
////            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//           
//        } catch (Throwable ex) {
//            // Log the exception. 
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
