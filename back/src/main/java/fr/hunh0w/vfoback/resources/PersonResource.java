package fr.hunh0w.vfoback.resources;

import fr.hunh0w.vfoback.entities.Person;
import fr.hunh0w.vfoback.services.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1")
@ApplicationScoped
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    @Path("/person")
    public Response getPerson(){
        List<Person> persons = personRepository.getPersons();
        return Response.ok(persons).build();
    }

    @POST
    @Transactional
    @Path("/person")
    public Response createPerson(){
        return Response.status(Response.Status.FORBIDDEN).build();
    }

}
