/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;

/**
 *
 * @author almand
 */
public interface Academic extends Serializable {

    public Department getDepartment();
    public void setDepartment(Department department);

}