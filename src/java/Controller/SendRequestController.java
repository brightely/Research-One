/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BankSlipDao;
import Dao.RequestDao;
import Dao.SendRequestDao;
import Domain.BankSlip;
import Common.FileUpload;
import Domain.Request;
import Domain.RequestReceived;
import Domain.Student;
import Domain.SystemAccount;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author almand
 */
@ManagedBean
@SessionScoped
public class SendRequestController implements Serializable {

    SystemAccount loggedInUserAccount = (SystemAccount) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedInUserAccount");
    private RequestReceived sendrequest = new RequestReceived();
    private String request;
    public BankSlip bankslip = new BankSlip();
    List<Request> requests = new RequestDao().findAll();
    private Part file;
    Student student_id = new Student();

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public RequestReceived getSendrequest() {
        return sendrequest;
    }

    public void setSendrequest(RequestReceived sendrequest) {
        this.sendrequest = sendrequest;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public SystemAccount getLoggedInUserAccount() {
        return loggedInUserAccount;
    }

    public void setLoggedInUserAccount(SystemAccount loggedInUserAccount) {
        this.loggedInUserAccount = loggedInUserAccount;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void Upload(FileUploadEvent event) {
        String profilePicture = new FileUpload().Upload(event, "C:\\Users\\almand\\Documents\\lulu staff\\memo\\Research One\\web\\file\\");
        //<!--  <h:inputFile alt="Upload file" value="#{sendRequestController.bankslip} "/> -->
        this.bankslip.setImage(profilePicture);
    }

    public String sendRequest() {
       // SystemAccount account = (SystemAccount) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedInUserAccount");

        //bankslip.setImage((File) file);
        new BankSlipDao().Create(bankslip);
        // sendrequest.setStudent_id(student_id);
        sendrequest.setStudent_id((Student) loggedInUserAccount.getUser());
        sendrequest.setBankSlip(bankslip);
        sendrequest.setRequestdate(new Date());
        new SendRequestDao().Create(sendrequest);
        
        FacesMessage msg = new FacesMessage("Well Added.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/SendRequestForm.xhtml";

    }

    public BankSlip getBankslip() {
        return bankslip;
    }

    public void setBankslip(BankSlip bankslip) {
        this.bankslip = bankslip;
    }

}
