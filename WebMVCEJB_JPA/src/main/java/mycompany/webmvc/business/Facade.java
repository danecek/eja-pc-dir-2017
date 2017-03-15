/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.webmvc.business;

import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mycompany.webmvc.integration.CustomerDAO;
import mycompany.webmvc.model.Customer;

/**
 *
 * @author admin
 */
@Stateless
public class Facade {

    @Inject
    LoginBean loginBean;
    @Inject
    CustomerDAO data;

    public void login(String user) {
        loginBean.setUser(user);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public boolean isLogged() {
        return getUser().isPresent();
    }

    public Optional<String> getUser() {
        return Optional.ofNullable(loginBean.getUser());
    }

    public List<Customer> getAll() {
        return data.getAll();
    }

    public void add(Customer item) {
        data.add(item);
    }

    public void delete(Long id) {
        data.delete(id);
    }

    public Customer getCustomer(long custId) {
        return data.get(custId);
    }

    public void addOrder(long custId, String description) {
        data.addOrder(custId, description);
    }

}
