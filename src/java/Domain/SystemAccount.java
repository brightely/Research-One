/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

/**
 *
 * @author almand
 */
@Entity
public class SystemAccount implements Serializable {

    
    private String username;
    private String password;
    private User user;
   

    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Any(metaColumn = @Column(name = "privilege"), fetch = FetchType.EAGER)
    @AnyMetaDef(
            idType = "string",
            metaType = "string",
            metaValues = {
                @MetaValue(targetEntity = Student.class, value = "STUDENT"),
                @MetaValue(targetEntity = AcademicStaff.class, value = "ACADEMIC_STAFF"),
                @MetaValue(targetEntity = AdministrativeStaff.class, value = "ADMINISTRATIVE_STAFF")
                    
            }
    )
    @JoinColumn(name = "usar")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}