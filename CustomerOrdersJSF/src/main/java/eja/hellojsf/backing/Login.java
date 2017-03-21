/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.hellojsf.backing;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Login implements Serializable {

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
        loggedUser = "anonymous";
        return "index?faces-redirect=true";
    }

    public String login() {
        loggedUser = user;
        user = null;
        return "index?faces-redirect=true";
    }

}
