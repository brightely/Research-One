/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.SystemAccount;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;


/**
 *
 * @author almand
 */
public class SytemAccountDao extends GenericDao<SystemAccount> {
      public List<SystemAccount> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SystemAccount> list = session.createCriteria(SystemAccount.class).list();
        session.close();
        return list;
    }
}
