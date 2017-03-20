/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.hellojsf.model;

public class Customer {

    private String name;
    private Integer id;

    public Customer(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    /**
     * @return the name
     */
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
