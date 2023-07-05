package fr.hunh0w.vfoback.resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class BasicResources {

    @Path("/hello")
    @GET
    public Response getHello(){
        return Response.ok("Hello World !").build();
    }

}
