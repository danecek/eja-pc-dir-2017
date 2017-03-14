/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.restcustomers.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Data {

    public static final Data inst = new Data();
    static int counter;
    Map<Integer, Customer> data = new ConcurrentHashMap<>();

    private Data() {
        add(new Customer("Bob"));
    }

    public List<Customer> all() {
        return new ArrayList<>(data.values());
    }

    public void add(Customer c) {
        c.setId(++counter);
        data.put(c.getId(), c);
    }

    public Customer get(int id) {
        Customer c = data.get(id);
        if (c.getName().equals("undefined")) {
            throw new RuntimeException("unavailable");
        }
        return c;
    }

    public int addKey() {
        counter++;
        data.put(counter, new Customer(counter, "Undefined"));
        return counter;
    }

    public void update(int id, String name) {
        data.get(id).setName(name);
    }

}
