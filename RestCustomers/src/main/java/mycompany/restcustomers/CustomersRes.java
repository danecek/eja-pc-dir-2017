/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.restcustomers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mycompany.restcustomers.data.Customer;
import mycompany.restcustomers.data.Data;

@Path("customers")
public class CustomersRes {

    @PUT
    public Response newCustomerId() {
        try {
            int key = Data.inst.addKey();
            URI location = new URI("http://localhost:9998/customers/" + key);
            return Response.created(location).build();
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Customer> all() {
        return Data.inst.all();
    }

    @Path("{id}")
    public CustomerSubres cust(@PathParam("id") Integer id) {
        return new CustomerSubres(id);
    }

}
