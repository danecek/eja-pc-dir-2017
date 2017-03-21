/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.hellojsf.data;

import eja.hellojsf.model.Colors;
import eja.hellojsf.model.Customer;
import eja.hellojsf.model.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
public class Data {

    private NavigableMap<Integer, Customer> customers = new ConcurrentSkipListMap<>();
    private NavigableMap<Integer, Order> orderes = new ConcurrentSkipListMap<>();

    public void addCustomer(Customer c) {
        int id = 1;
        if (!customers.isEmpty()) {
            id = customers.lastKey() + 1;
        }
        c.setId(id);
        customers.put(c.getId(), c);
    }
    
    public void addOrder(Customer c, Order o) {
        int id = 1;
        if (!orderes.isEmpty()) {
            id = orderes.lastKey() + 1;
        }
        o.setId(id);
        orderes.put(o.getId(), o);
        c.getOrders().add(o);
        o.setCustomer(c);
    }

    @PostConstruct
    void init() {
        Customer t = new Customer("Tom");
        addCustomer(t);
        addOrder(t, new Order(3, Colors.BLUE));
        addOrder(t, new Order(5, Colors.GREEN));
        addCustomer(new Customer("Bob"));
    }

    public List<Customer> all() {
        return new ArrayList<>(customers.values());
    }

    public void delete(Customer c) {
        customers.remove(c.getId());
    }

    public Customer findCustomer(int id) {
        return customers.get(id);
    }

    public List<Order> getOrders(Customer customer) {
        return customers.get(customer.getId()).getOrders();
    }

    public Order findOrder(int orderId) {
        return orderes.get(orderId);
    }
}
