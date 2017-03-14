/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.restcustomers;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import mycompany.restcustomers.data.Customer;
import mycompany.restcustomers.data.Data;

public class CustomerSubres {

    private final int id;

    public CustomerSubres(int id) {
        this.id = id;
    }

    @GET
    public Customer getCust() {
        return Data.inst.get(id);
    }
    
    @PUT
    void setName(String name) {
        Data.inst.update(id, name);
    }
            
    

}
