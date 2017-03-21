/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.hellojsf.backing;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@SessionScoped
public class Login implements Serializable {

    public String getPassw() {
        return passw;
    }
    
    public boolean getLoggedAdmin() {
        return getLoggedUser().equals("admin");
    }

    /**
     * @param passw the passw to set
     */
    public void setPassw(String passw) {
        this.passw = passw;
    }

    private String passw;

    /**
     * @return the loggedUser
     */
    public String getLoggedUser() {
        return loggedUser;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    private String user;
    private String loggedUser = "anonymous";

    public String logout() {
        try {
            loggedUser = "anonymous";
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpServletRequest r = (HttpServletRequest) fc.getExternalContext().getRequest();
            r.logout();
        } catch (ServletException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index?faces-redirect=true";
    }

    public String login() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest r = (HttpServletRequest) fc.getExternalContext().getRequest();
        try {
            if ("admin".equals(user)) {
                r.login(user, getPassw());
            } else {
                r.login("user", "user");
            }
            loggedUser = user;
            user = null;
            return "index?faces-redirect=true";
        } catch (ServletException ex) {
            fc.addMessage("passw", new FacesMessage( ex.toString()));
            user = null;
            return "login";
        }

    }

}
