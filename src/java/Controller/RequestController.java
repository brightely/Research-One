/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.RequestDao;
import Dao.RequestTypeDao;
import Domain.Request;
import Domain.RequestType;
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
public class RequestController implements Serializable {

    Request request = new Request();
    private String reqtype;
    List<RequestType> reqtypes = new RequestTypeDao().findAll();

    public String createrequest() {
        RequestType req = new RequestType();
        req.setId(reqtype);
        request.setRequesttype(req);
        new RequestDao().Create(request);
        request = new Request();
        FacesMessage msg = new FacesMessage("Well Added.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/RequestAccount.xhtml";
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public List<Request> getRequests() {
        return new RequestDao().findAll();
    }

    public String getReqtype() {
        return reqtype;
    }

    public void setReqtype(String reqtype) {
        this.reqtype = reqtype;
    }

    public List<RequestType> getReqtypes() {
        return reqtypes;
    }

    public void setReqtypes(List<RequestType> reqtypes) {
        this.reqtypes = reqtypes;
    }
     
}
