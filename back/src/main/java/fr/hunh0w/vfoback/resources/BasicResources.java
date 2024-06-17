package fr.hunh0w.vfoback.resources;

import fr.hunh0w.vfoback.entities.Person;
import fr.hunh0w.vfoback.services.PersonRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jose4j.json.internal.json_simple.JSONObject;

import java.util.List;

@ApplicationScoped
@Path("/")
public class BasicResources {

    @Inject
    PersonRepository personRepository;

    @Path("/hello")
    @GET
    public Response getHello(){
        return Response.ok("Hello World from API !").build();
    }

    @Path("/healthz")
    @GET
    public Response getHealth(){
        List<JSONObject> persons = personRepository.getPersons();
        return Response.ok().build();
    }

}
