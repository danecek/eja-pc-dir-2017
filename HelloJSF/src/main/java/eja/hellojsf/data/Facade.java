/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.hellojsf.data;

import eja.hellojsf.model.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Facade {
   @Inject
   Data data;
   
   public List<Customer> all() {
     return data.all();
   }

    public void addCustomer(Customer customer) {
        data.add(customer);
    }

    public void delete(Customer c) {
        data.delete(c);
    }

    public Customer find(int id) {
        return data.find(id);
    }
}
