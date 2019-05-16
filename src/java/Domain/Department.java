/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author almand
 */
@Entity
public class Department implements Serializable {
    
    @Id
    public String uuid = UUID.randomUUID().toString();
    public String dname;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    public Faculty faculty;
    
    @OneToMany(mappedBy = "department")
    public List<Student> students;
    
    @OneToMany(mappedBy = "department")
    public List<AcademicStaff> academicStaffs;

//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

//    public List<AcademicStaff> getAcademicStaffs() {
//        return academicStaffs;
//    }
//
//    public void setAcademicStaffs(List<AcademicStaff> academicStaffs) {
//        this.academicStaffs = academicStaffs;
//    }
    
    @Override
    public String toString(){
        return dname;
    }

}