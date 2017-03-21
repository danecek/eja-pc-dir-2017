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

    public void add(Customer c) {
        int id = 1;
        if (!customers.isEmpty()) {
            id = customers.lastKey() + 1;
        }
        c.setId(id);
        customers.put(c.getId(), c);
    }

    @PostConstruct
    void init() {
        Customer t = new Customer("Tom");
        t.addOrder(new Order(3, Colors.BLUE));
        t.addOrder(new Order(3, Colors.GREEN));
        add(t);
        add(new Customer("Bob"));
    }

    public List<Customer> all() {
        return new ArrayList<>(customers.values());
    }

    public void delete(Customer c) {
        customers.remove(c.getId());
    }

    public Customer find(int id) {
        return customers.get(id);
    }

    public List<Order> getOrders(Customer customer) {
        return customers.get(customer.getId()).getOrders();
    }
}
