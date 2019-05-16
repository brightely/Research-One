/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author almand
 */
public abstract class GenericDao<X> {
    
    public void Create(X x){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(x);
        session.getTransaction().commit();
        session.save(x);
    }
    
    public void update(X x){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(x);
        session.getTransaction().commit();
        session.save(x);
    }
    
    public void delete(X x){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(x);
        session.getTransaction().commit();
        session.save(x);
    }
    
}
