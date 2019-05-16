/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;
import java.util.List;
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
public class Request implements Serializable {
    @Id
    public Integer request_id;
    private Double price;
    private String requestname;
  
    @ManyToOne
    @JoinColumn(name = "Id")
    private RequestType requesttype;
    
    @OneToMany(mappedBy = "requestname")
    private List<RequestReceived> requestreceived;
    
    // to be revised It's one request to one staff member.
    
    
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRequestname() {
        return requestname;
    }

    public void setRequestname(String requestname) {
        this.requestname = requestname;
    }

   public RequestType getRequesttype() {
        return requesttype;
    }

    public void setRequesttype(RequestType requesttype) {
        this.requesttype = requesttype;
    }

    public Integer getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Integer request_id) {
        this.request_id = request_id;
    }

    public List<RequestReceived> getRequestreceived() {
        return requestreceived;
    }

    public void setRequestreceived(List<RequestReceived> requestreceived) {
        this.requestreceived = requestreceived;

    }
   
}
