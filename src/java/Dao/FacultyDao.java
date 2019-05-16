/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.Faculty;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author almand
 */
public class FacultyDao extends GenericDao<Faculty>{
     public List<Faculty> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Faculty> list = session.createCriteria(Faculty.class).list();
        session.close();
        return list;
    }
    
}
