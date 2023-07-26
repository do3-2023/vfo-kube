package fr.hunh0w.vfoback.resources;

import fr.hunh0w.vfoback.entities.Car;
import fr.hunh0w.vfoback.services.CarRepository;
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
public class CarResource {

    @Inject
    CarRepository carRepository;

    @GET
    @Path("/car")
    public Response getCar(){
        List<Car> car = carRepository.getCars();
        return Response.ok(car).build();
    }

    @POST
    @Transactional
    @Path("/car")
    public Response createCar(){
        return carRepository.generateCar();
    }

}
