/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eja.customersmustache;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.mustache.MustacheMvcFeature;

@javax.ws.rs.ApplicationPath("customers")
public class CustomersResourceConfig extends ResourceConfig {

    public CustomersResourceConfig() {
        register(CustomersResource.class);
        register(MustacheMvcFeature.class);
        this.property(MustacheMvcFeature.TEMPLATE_BASE_PATH, "WEB-INF/mustachetempls");
    }

}
