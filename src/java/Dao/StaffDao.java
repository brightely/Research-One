/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Domain.Staff;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author almand
 */
public class StaffDao extends GenericDao<Staff>{
    
    public List<Staff> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Staff> list = session.createCriteria(Staff.class).list();
        session.close();
        return list;
    }
}
