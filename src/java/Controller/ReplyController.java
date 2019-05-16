/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Domain.SystemAccount;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author almand
 */
@ManagedBean
@SessionScoped
public class ReplyController {
    SystemAccount loggedInUserAccount = (SystemAccount) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedInUserAccount");

    public SystemAccount getLoggedInUserAccount() {
        return loggedInUserAccount;
    }

    public void setLoggedInUserAccount(SystemAccount loggedInUserAccount) {
        this.loggedInUserAccount = loggedInUserAccount;
    }
  

}
