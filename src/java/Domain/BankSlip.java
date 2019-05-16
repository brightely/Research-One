/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author almand
 */
@Entity
public class BankSlip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String image;

    @OneToMany(mappedBy = "bankSlip", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<RequestReceived> requestreceived;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   
    
    public List<RequestReceived> getRequestreceived() {
        return requestreceived;
    }

    public void setRequestreceived(List<RequestReceived> requestreceived) {
        this.requestreceived = requestreceived;
    }

  
    
    
}
