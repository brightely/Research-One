/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.File;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author almand
 */
@Entity
public class RequestReceived {
    
    @Id
    private Integer requestedId;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date requestdate;
   // private Double price;
    private String details;
    //private String requestname;

   // private String Observation; it has to be in response.
    private String status;
    @Enumerated (EnumType.STRING)
    private Staff.Position Redirection;
    
    
    // to set relationship with requesttype and set price attribute.

    @ManyToOne
    private BankSlip bankSlip;
    
    @ManyToOne
    @JoinColumn(name = "request_Name")
    private Request requestname;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student_id;
    
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff_id;
    // to be revised It's one request to one staff member.

//    public String getRequestname() {
//        return requestname;
//    }
//
//    public void setRequestname(String requestname) {
//        this.requestname = requestname;
//    }

   

//    public RequestType getRequesttype() {
//        return requesttype;
//    }
//
//    public void setRequesttype(RequestType requesttype) {
//        this.requesttype = requesttype;
//    }
    
    
   
    public Date getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(Date requestdate) {
        this.requestdate = requestdate;
    }

    public BankSlip getBankSlip() {
        return bankSlip;
    }

    public void setBankSlip(BankSlip bankSlip) {
        this.bankSlip = bankSlip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public Staff getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Staff staff_id) {
        this.staff_id = staff_id;
    }

    public Integer getRequestedId() {
        return requestedId;
    }

    public void setRequestedId(Integer requestedId) {
        this.requestedId = requestedId;
    }

    public Staff.Position getRedirection() {
        return Redirection;
    }

    public void setRedirection(Staff.Position Redirection) {
        this.Redirection = Redirection;
    }

    public Request getRequestname() {
        return requestname;
    }

    public void setRequestname(Request requestname) {
        this.requestname = requestname;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    
   
}