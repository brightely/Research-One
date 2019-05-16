/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Dao.SytemAccountDao;
import Domain.SystemAccount;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author almand
 */
@ManagedBean
@SessionScoped
public class userController {

    @ManagedProperty("#{loginBean.account}")
    private SystemAccount account;
    private String username;
    private String OldPassword;
    private String NewPassword;
    private String ConfirmPassword;

    public String manipulateUser() {
        if (account.getPassword().equals(OldPassword)) {
           if (NewPassword.equals(ConfirmPassword)) {
               account.setPassword(NewPassword);
           }
           
        }
        new SytemAccountDao().update(account);
        return "/Login.xhtml";
    }

    public SystemAccount getAccount() {
        return account;
    }

    public void setAccount(SystemAccount account) {
        this.account = account;
    }

    public String getOldPassword() {
        return OldPassword;
    }

    public void setOldPassword(String OldPassword) {
        this.OldPassword = OldPassword;
    }

    public String getNewPassword() {
        return NewPassword;
    }

    public void setNewPassword(String NewPassword) {
        this.NewPassword = NewPassword;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String ConfirmPassword) {
        this.ConfirmPassword = ConfirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
