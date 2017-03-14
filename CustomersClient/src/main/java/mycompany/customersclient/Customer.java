/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.customersclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

    public Customer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    private Integer id;
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
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
        return "Customer{" + "id=" + id + ", name=" + name + '}';
    }
    
    
    
}
