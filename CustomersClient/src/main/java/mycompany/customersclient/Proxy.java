/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.customersclient;

import java.net.URI;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class Proxy {

    public static final Proxy inst = new Proxy();
    WebTarget customersResource;

    private Proxy() {
        Client c = ClientBuilder.newClient();
        customersResource = c.target("http://localhost:9998/customers");

    }

    public List<Customer> all() {
        return customersResource.request().
                get(new GenericType<List<Customer>>() {
                });
    }

    public void add(String name) {
        Response r = customersResource.request().put(Entity.text("add"));
        System.out.println(r.getStatus() +":" + r.getStatusInfo());
        URI uri = r.getLocation();
        String us = uri.toString();
        int li = us.lastIndexOf('/');
        WebTarget custRes = customersResource.path(us.substring(li));
        System.out.println(custRes);
        custRes.request().put(Entity.text(name));

    }

}
