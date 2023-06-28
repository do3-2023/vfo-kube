package fr.hunh0w.vfoback.resources;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jose4j.json.internal.json_simple.JSONObject;

@Path("/api/v1")
@ApplicationScoped
public class CarResource {

    @GET
    @Path("/car")
    public Response getCar(){
        return Response.ok("Hello World!").build();
    }

}
