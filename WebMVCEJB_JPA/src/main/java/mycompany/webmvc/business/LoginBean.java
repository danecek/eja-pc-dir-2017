/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.webmvc.business;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;


@Stateful
@SessionScoped
public class LoginBean {

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    
    private String user;

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
