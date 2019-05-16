/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DepartmentDao;
import Dao.FacultyDao;
import Domain.Department;
import Domain.Faculty;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author almand
 */
@ManagedBean
@SessionScoped
public class FacultyController {

    Faculty faculty = new Faculty();
    private String facultyId;
    private String fname;
    Department department = new Department();
    private List<Faculty> faculties = new FacultyDao().findAll();

    public String createFaculty() {

        new FacultyDao().Create(faculty);
        
        faculty = new Faculty();
        FacesMessage msg = new FacesMessage("Well Added.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/AddFaculty.xhtml";

    }

    public String createDepartment() {

        faculty.setUuid(facultyId);
        department.setFaculty(faculty);
        new DepartmentDao().Create(department);
        department = new Department();
        FacesMessage msg = new FacesMessage("Well Added.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/AddDepartment.xhtml";

    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
   
}
