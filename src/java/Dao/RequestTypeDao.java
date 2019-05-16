/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.RequestType;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author almand
 */
public class RequestTypeDao extends GenericDao<RequestType>{
      public List<RequestType> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<RequestType> list = session.createCriteria(RequestType.class).list();
        session.close();
        return list;
    }
}
