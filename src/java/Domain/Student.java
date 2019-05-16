/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author almand
 */
@Entity
public class Student extends Person implements Academic, User {

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "student_id")
    private List<RequestReceived> requests;

    public List<RequestReceived> getRequests() {
        return requests;
    }

    public void setRequests(List<RequestReceived> requests) {
        this.requests = requests;
    }

    @Override
    public Department getDepartment() {
        return this.department;
    }

    @Override
    public void setDepartment(Department department) {
        this.department = department;
    }


}