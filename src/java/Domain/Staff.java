/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

/**
 *
 * @author almand
 */
@Entity
public abstract class Staff extends Person implements User {

    @Enumerated(EnumType.STRING)
    private Position position;

    @OneToMany(mappedBy = "staff_id")
    private List<RequestReceived> requests;

    public List<RequestReceived> getRequests() {
        return requests;
    }

    public void setRequests(List<RequestReceived> requests) {
        this.requests = requests;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public enum Type {

        ADMINISTRATIVE, ACADEMIC

    }

    public enum Position {

        ACCOUNTANT, EXAMINATION_OFFICER, REGISTRAR, DEAN, HOD, TEACHER

    }

}