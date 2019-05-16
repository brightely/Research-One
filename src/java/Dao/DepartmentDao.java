/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.Department;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author almand
 */
public class DepartmentDao extends GenericDao<Department>{
    
    public List<Department> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Department> list = session.createCriteria(Department.class).list();
        session.close();
        return list;
    }
      public List<Department> findOne(final String c){
        
        Session con  = HibernateUtil.getSessionFactory().openSession();
        Query qry = con.createQuery("Select f from Department f where f.uuid=?");
        qry.setString(0, c);
        return qry.list();
    }
}
