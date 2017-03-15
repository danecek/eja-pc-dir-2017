/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.webmvc.business;

import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mycompany.webmvc.integration.Data;

/**
 *
 * @author admin
 */
@Stateless
public class Facade {

    @Inject
    LoginBean loginBean;
    @Inject
    Data data;

    public void login(String user) {
        loginBean.setUser(user);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public boolean isLogged() {
        return getUser().isPresent();
    }

    public Optional<String> getUser() {
        return  Optional.ofNullable(loginBean.getUser());
    }

    public Iterable<String> getAll() {
        return data.getAll();
    }

    public void add(String item) {
        data.add(item);
    }
    
    
}
