/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.hellojsf.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    /**
     * @return the orders
     */
    public List<Order> getOrders() {
        return orders;
    }

    private String name;
    private Integer id;
    private List<Order> orders = new ArrayList<>();

    public Customer(Integer id, String name) {
        this.name = name;
        this.id = id;
    }
    
    public void addOrder(Order order) {
        getOrders().add(order);
        order.setCustomer(this);
    }

    public String getName() {
        return name;
    }

    public Customer(String name) {
        this.name = name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", id=" + id + '}';
    }

}
