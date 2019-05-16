/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.GeneralDao;
import Domain.Staff;
import Domain.Student;
import Domain.SystemAccount;
import java.io.Serializable;
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
public class loginBean implements Serializable {

    SystemAccount account = new SystemAccount();
    private String username;
    private String password;
    private String pass="123";

    //specific user account;
    public String login() {
        try {
            SystemAccount account0 = new GeneralDao().getLoggedOnUser(username);
            if (account0 != null) {

                //If password is equal to default password
                this.account = account0;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loggedInUserAccount", account);
                if (account0.getPassword().equals(pass)) {//change made but ask if it's correct.
                    //Change Password Page

                    return "/ChangingPassword.xhtml";
                } // you have to Encrypt the password entered in a webpage
                else if (account0.getPassword().equals(password)) {
                    if (account0.getUser() instanceof Student) {
                        return "/SendRequestForm.xhtml";
                    } else if (account0.getUser() instanceof Staff) {
                        return "/ReplyRequest.xhtml";
                    }

//                    if (account0.getUsername().equals("Admin")) {
//                        //return Student homepage
//                        return "/AdminTemplate.xhtml";
//                    } else if (account0.getUsername().equals("Student")) {
//
//                        //return Staff homepage
//                        return "/SendRequestForm.xhtml";
//                    } else if (account0.getUsername().equals("Staff member")) {
//
//                        //return Admin Page
//                        return "/ReplyRequest.xhtml";
//                    } else {
//
//                        //message : Invalid Account
//                        FacesMessage msg = new FacesMessage("Invalid Username or password");
//                        FacesContext.getCurrentInstance().addMessage(null, msg);
//                        System.out.println(account0);
//                        return "Login.xhtml";
//
//                    }
                }
            } else {
                //message: Invalid Username or Password
                FacesMessage msg = new FacesMessage("Invalid Username or password");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                System.out.println(account0);
                return "Login.xhtml";

            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Invalid Username or Password!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/Login.xhtml";
        }

        return "/Login.xhtml";
    }

//    public String logout() {
//
//        FacesContext context = FacesContext.getCurrentInstance();
//        this.account = new Account();
//        context.getExternalContext().invalidateSession();
//        return "/Login.xhtml";
//    }
    public SystemAccount getAccount() {
        return account;
    }

    public void setAccount(SystemAccount account) {
        this.account = account;
    }

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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    
    
}
