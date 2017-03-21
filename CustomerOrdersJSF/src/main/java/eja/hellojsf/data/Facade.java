/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.hellojsf.data;

import eja.hellojsf.model.Customer;
import eja.hellojsf.model.Order;
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
        data.addCustomer(customer);
    }

    public void delete(Customer c) {
        data.delete(c);
    }

    public Customer findCustomer(int id) {
        return data.findCustomer(id);
    }

    public List<Order> getOrders(Customer customer) {
        return data.getOrders(customer);
    }

    public void deleteOrder(Order order) {
       Customer customer = data.findCustomer(order.getCustomer().getId());
       customer.getOrders().remove(order);
    }

    public Order findOrder(int orderId) {
        return data.findOrder(orderId);
    }

    public void addOrder(Customer customer, Order order) {
        data.addOrder(customer, order);
    }
}
