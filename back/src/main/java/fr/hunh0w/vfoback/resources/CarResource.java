package fr.hunh0w.vfoback.resources;

import fr.hunh0w.vfoback.entities.Car;
import fr.hunh0w.vfoback.services.CarRepository;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.hibernate.reactive.mutiny.Mutiny;
import org.jboss.resteasy.reactive.RestResponse;
import org.jose4j.json.internal.json_simple.JSONObject;

@Path("/api/v1")
@ApplicationScoped
public class CarResource {

    @Inject
    CarRepository carRepository;

    @GET
    @WithTransaction
    @Path("/car")
    public Uni<Response> getCar(){
        System.out.println("retrieving Car...");
        Uni<Car> car = carRepository.getCar();

        return car.map(carObj -> {
            if(carObj == null)
                return Response.status(RestResponse.Status.NOT_FOUND).build();
            else
                return Response.ok(carObj).build();
        });
    }

    @POST
    @WithTransaction
    @Path("/car")
    public Uni<Response> createCar(){
        System.out.println("Creating Car...");
        return carRepository.generateCar();
    }

}
