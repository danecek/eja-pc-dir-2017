/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.hellojsf.model;

/**
 *
 * @author admin
 */
public class Order {

    private int id;
    private int amount;
    private Colors color;
    Customer customer;

    public Order(int amount, Colors color) {
        this.amount = amount;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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

    void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    

}
