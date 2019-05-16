/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author almand
 */
@Entity
public class AcademicStaff extends Staff implements Academic {

    @ManyToOne
    private Department department;

    @Override
    public Department getDepartment() {
        return this.department;
    }

    @Override
    public void setDepartment(Department department) {
        this.department = department;
    }

    

}