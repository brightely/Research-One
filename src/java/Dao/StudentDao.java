/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.Student;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author almand
 */
public class StudentDao extends GenericDao<Student>{
    
    public List<Student> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> list = session.createCriteria(Student.class).list();
        session.close();
        return list;
    }

    public String lastId() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //System.out.println("Heyyy ... " + session.createQuery("SELECT max(student_id) FROM Student").uniqueResult());
        Integer id = (Integer) session.createQuery("SELECT max(s.student_id) FROM Student s").uniqueResult();
        session.close();
        return "id";
    }

}