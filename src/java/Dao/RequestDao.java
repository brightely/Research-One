/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.Request;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author almand
 */
public class RequestDao extends GenericDao<Request>{
     public List<Request> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Request> list = session.createCriteria(Request.class).list();
        session.close();
        return list;
    }
}
