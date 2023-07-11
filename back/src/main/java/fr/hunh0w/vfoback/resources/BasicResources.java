package fr.hunh0w.vfoback.resources;

import fr.hunh0w.vfoback.entities.Car;
import fr.hunh0w.vfoback.services.CarRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class BasicResources {

    @Inject
    CarRepository carRepository;

    @Path("/hello")
    @GET
    public Response getHello(){
        return Response.ok("Hello World !").build();
    }

    @Path("/healthz")
    @GET
    public Uni<Response> getHealth(){
        Uni<Car> car = carRepository.getCar();
        return car.map(carObj -> {
            return Response.ok().build();
        });
    }

}
