/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.hellojsf.backing;

import eja.hellojsf.data.Facade;
import eja.hellojsf.model.Customer;
import eja.hellojsf.model.Order;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class DeleteOrder {

    @Inject
    private Facade facade;
    private Order order;
    private Customer customer;

    @PostConstruct
    void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest r = (HttpServletRequest) fc.getExternalContext().getRequest();
        setOrder(getFacade().
                findOrder(Integer.parseInt(r.getParameter("orderId"))));
        setCustomer(getFacade().findCustomer(getOrder().getCustomer().getId()));
    }

    public String delete() {
        getFacade().deleteOrder(getOrder());
        return "customerOrders?faces-redirect=true&custId="+customer.getId();
    }

    /**
     * @return the facade
     */
    public Facade getFacade() {
        return facade;
    }

    /**
     * @param facade the facade to set
     */
    public void setFacade(Facade facade) {
        this.facade = facade;
    }

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
