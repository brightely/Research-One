/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DepartmentDao;
import Dao.FacultyDao;
import Dao.StaffDao;
import Dao.SytemAccountDao;
import Domain.Academic;
import Domain.AcademicStaff;
import Domain.AdministrativeStaff;
import Domain.Department;
import Domain.Faculty;
import Domain.Person;
import Domain.Staff;
import Domain.SystemAccount;
import java.io.Serializable;
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
public class StaffController implements Serializable {

//    Staff staff = new Staff();
    private String id;
    private String firstName;
    private String lastName;
    private Person.Gender gender;
    private String email;
    private String address;
    private Staff.Type type;
    private String facultyId;
    private String departmentId;
    private Staff.Position position;
    private String password="123";

    SystemAccount account = new SystemAccount();

    /*
    Staff staff = new Staff();
    private String staff_id;
    SystemAccount account = new SystemAccount();
    List<UserType> usertype = new UserTypeDao().findAll();
    GenderType[] genderType = GenderType.values();
    AcademicAdministration[] academictype = AcademicAdministration.values();

    public String createstaffmember() {
        System.out.println(StaffType.values());

        //account.setAccount_Id(Integer.valueOf(staff_id));
        account.setUsername(staff_id);

        //encrypt password before saving it to the database using MD5Encryption
        account.setPassword("123");
        //account.setAccount_id(usertype);
        for (UserType us : usertype) {
            if (us.getUsertype_Id().equals(1)) {
                account.setUsertype(us);
            }
        }
        new SytemAccountDao().Create(account);
        staff.setAccount_id(account);
        staff.setStaff_Id(Integer.valueOf(staff_id));
        new StaffDao().Create(staff);
        staff = new StaffMember();
        FacesMessage msg = new FacesMessage("Well Added.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/StaffAccount.xhtml";
    }

    public List<StaffMember> getStaffMembers() {
        return new StaffDao().findAll();
    }

    public StaffMember getStaff() {
        return staff;
    }

    public void setStaff(StaffMember staff) {
        this.staff = staff;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<UserType> getUsertype() {
        return usertype;
    }

    public void setUsertype(List<UserType> usertype) {
        this.usertype = usertype;
    }

    public StaffType[] getStaffTypes() {
        return StaffType.values();// for setting enum staffmembertype
    }

    public GenderType[] getGenderType() {
        return genderType;
    }

    public AcademicAdministration[] getAcademictype() {
        return academictype;
    }*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person.Gender getGender() {
        return gender;
    }

    public void setGender(Person.Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Staff.Type getType() {
        return type;
    }

    public void setType(Staff.Type type) {
        this.type = type;
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

    public Staff.Position getPosition() {
        return position;
    }

    public void setPosition(Staff.Position position) {
        this.position = position;
    }

    public Person.Gender[] getGenders() {
        return Person.Gender.values();
    }

    public Staff.Type[] getTypes() {
        return Staff.Type.values();
    }

    public Boolean isAcademic() {
        return type == Staff.Type.ACADEMIC;
    }

    public List<Faculty> getFaculties() {
        return new FacultyDao().findAll();
    }

    public List<Department> getDepartments() {
        return new DepartmentDao().findAll();
    }

    public Staff.Position[] getPositions() {
        return Staff.Position.values();
    }

    public SystemAccount getAccount() {
        return account;
    }

    public void setAccount(SystemAccount account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public String register() {

        Staff staff;
        if (type != null) {
            if (type == Staff.Type.ADMINISTRATIVE) {
                staff = new AdministrativeStaff();
                
            } else {
                staff = new AcademicStaff();
                System.out.println("DEPAAAAAAR " + departmentId);
//                List<Department> department = new DepartmentDao().findOne(departmentId);
//                ((Academic)staff).setDepartment(department);
//               // Department department = new DepartmentDao().findOne(departmentId);
                Department dep = new Department();
                dep.setUuid(departmentId);

                ((Academic) staff).setDepartment(dep);
                
            }

            staff.setPersonId(id);
            staff.setFirstName(firstName);
            staff.setLastName(lastName);
            staff.setGender(gender);
            staff.setEmail(email);
            staff.setAddress(address);
            staff.setPosition(position);
            // System.out.println();
            new StaffDao().Create(staff);

            //create account staff member account.
            account.setUsername(id);
            account.setPassword(password);
            account.setUser(staff);
            new SytemAccountDao().Create(account);
            new SendMail().sendmail(email, firstName + " " + lastName, id, password);
        
        }

        FacesMessage msg = new FacesMessage("Well Added.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/StaffAccount.xhtml";
    }

}
