/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.hellojsf.backing;

import eja.hellojsf.data.Facade;
import eja.hellojsf.model.Colors;
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

    /**
     * @return the custId
     */
    public int getCustId() {
        return customer.getId();
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(int custId) {
        customer = facade.findCustomer(custId);
    }

    /**
     * @return the colors
     */
    public Colors[] getColors() {
       return Colors.values();
    }

    private Customer customer;

    private int amount;
    private Colors color;

    @Inject
    private Facade facade;

    @PostConstruct
    void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest r = (HttpServletRequest) fc.getExternalContext().getRequest();
        String custIds = r.getParameter("custId");
        setCustomer(getFacade().findCustomer(Integer.parseInt(custIds)));
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
        return getCustomer().getOrders();//facade.getOrders(customer);
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the color
     */
    public Colors getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Colors color) {
        this.color = color;
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

    public String addOrder() {
        facade.addOrder(customer, new Order(amount, color));
        return "customerOrders?faces-redirect=true&custId=" + customer.getId();
    }

}
