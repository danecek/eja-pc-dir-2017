/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.customersmustache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("")
@Singleton
public class CustomersResource {

    @Context
    private UriInfo context;
    List<Customer> custs = new ArrayList<>();

    public CustomersResource() {
    }

    @PostConstruct
    void init() {
        custs.add(new Customer("Tom"));
        custs.add(new Customer("Bob"));
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getHtml() {
        return new Viewable("/customers.mustache", Collections.singletonMap("customers", custs));
    }

    /**
     * PUT method for updating or creating an instance of CustomersResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
