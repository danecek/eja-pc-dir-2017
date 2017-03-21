/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.hellojsf.backing;

import eja.hellojsf.data.Facade;
import eja.hellojsf.model.Customer;
import eja.hellojsf.model.Order;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class CustomerOrders {

    private Customer customer;
    @Inject
    Facade facade;

    @PostConstruct
    void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest r = (HttpServletRequest) fc.getExternalContext().getRequest();
        String custIds = r.getParameter("custId");
        customer = facade.find(Integer.parseInt(custIds));
    }

    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public List<Order> getCustomerOrderes() {
        return facade.getOrders(customer);
    }


    public String addOrder() {
        return "customerOrders";
    }

    public String deleteOrder() {
        return "customerOrders";
    }
}
