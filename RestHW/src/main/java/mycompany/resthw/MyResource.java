
package mycompany.resthw;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("hello")
public class MyResource {
    @GET
    @Produces("text/plain")
    public String hello(@DefaultValue("Anybody") @QueryParam("name") String name) {
        return "Hello " + name;
    }
}
