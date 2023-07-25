package fr.hunh0w.vfoback.resources;

import fr.hunh0w.vfoback.entities.Car;
import fr.hunh0w.vfoback.services.CarRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/api/v1")
@ApplicationScoped
public class CarResource {

    @Inject
    CarRepository carRepository;

    @GET
    @Path("/car")
    public Response getCar(){
        System.out.println("retrieving Car...");
        Car car = carRepository.getCar();

        return Response.ok(car).build();
    }

    @POST
    @Path("/car")
    public Response createCar(){
        System.out.println("Creating Car...");
        return carRepository.generateCar();
    }

}
