/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DepartmentDao;
import Dao.FacultyDao;
import Dao.StudentDao;
import Dao.SytemAccountDao;
import Domain.Department;
import Domain.Faculty;
import Domain.Person;
import Domain.Student;
import Domain.SystemAccount;
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
public class StudentController {

    /*@ManagedProperty("loginBean.getUser")
    User user;*/
    Student student = new Student();
    private Person.Gender gender;
    //private String student_id = ((String)new StudentDao().lastId() + 1);
    private String student_id;
    private String studentuser = "Student";
    SystemAccount account = new SystemAccount();
    //List<UserType> usertype = new UserTypeDao().findAll();
    private String departmentId;
    List<Department> departments = new DepartmentDao().findAll();
    //GenderType[] genderType = GenderType.values();
    private String facultyId;
    private String password="123";

    public String createstudent() {

        //creating account for a student
//        account.setUsername(String.valueOf(student_id));
//        //encrypt password before saving it to the database using MD5Encryption 
        // account.setUsertype(usertype);
//        for (UserType us : usertype) {
//            if (us.getUsertype_Id().equals(2)) {//attention to the change made
//                account.setUsertype(us);
//            }
//        }
//         for (SystemAccount us : systemaccount) {
//        if (account.getUser().equals("STUDENT")) {//attention to the change made
//            account.setUser(us);
//        }
        //}
        /*end of creating student's account*/
        // student.setAccount_id(account);
        Department dep = new Department();
        dep.setUuid(departmentId);
        student.setDepartment(dep);

        student.setGender(gender);
        student.setPersonId(student_id);
        new StudentDao().Create(student);

        account.setUsername(student_id);
        account.setPassword(password);
        account.setUser(student);
        //  new SendMail().sendmail(email, firstname + " " + lastname, email, password);
        new SytemAccountDao().Create(account);
        //send email notification
        //new SendMail().sendmail(student.getEmail(), student.getFirstName() + " " + student.getLastName(), student.getEmail(), password);
        
        student = new Student();
        FacesMessage msg = new FacesMessage("Well Added.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/StudentAccount.xhtml";
    }

    public Person.Gender getGender() {
        return gender;
    }

    public void setGender(Person.Gender gender) {
        this.gender = gender;
    }

    public Person.Gender[] getGenders() {
        return Person.Gender.values();
    }

    public SystemAccount getAccount() {
        return account;
    }

    public void setAccount(SystemAccount account) {
        this.account = account;
    }

    public List<Student> getStudents() {
        return new StudentDao().findAll();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public List<UserType> getUsertype() {
//        return usertype;
//    }
//
//    public void setUsertype(List<UserType> usertype) {
//        this.usertype = usertype;
//    }
    public List<Department> getDepartments() {
        return departments;
    }

    public List<Faculty> getFaculties() {
        return new FacultyDao().findAll();
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

//    public GenderType[] getGenderType() {
//        return genderType;
//    }
    public String getStudentuser() {
        return studentuser;
    }

    public void setStudentuser(String studentuser) {
        this.studentuser = studentuser;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
