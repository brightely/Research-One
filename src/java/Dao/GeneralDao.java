/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Domain.SystemAccount;
import Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author almand
 */
public class GeneralDao {
    public SystemAccount getLoggedOnUser(String a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query qry = session.createQuery("select f from SystemAccount f where f.username =?");
        qry.setString(0, a);
        SystemAccount account = (SystemAccount)qry.uniqueResult();
        return account;
    }

}