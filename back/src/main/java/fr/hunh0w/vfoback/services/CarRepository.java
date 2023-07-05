package fr.hunh0w.vfoback.services;

import fr.hunh0w.vfoback.entities.Car;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.hibernate.reactive.mutiny.Mutiny;

import java.util.Random;

@ApplicationScoped
public class CarRepository {

    Random rd = new Random();

    @Inject
    Mutiny.SessionFactory sf;

    public Uni<Car> getCar(){
        return sf.withTransaction(s -> s
                .createNamedQuery("Car.findAll", Car.class)
                .getSingleResult());
    }

    public Uni<Response> generateCar(){
        Car car = new Car();
        car.name = "Toyota-"+randomDigits(16);
        car.color = "color-"+randomDigits(8);
        car.persist();
        return sf.withTransaction(s -> s.persist(car))
                .replaceWith(Response.ok(car).status(Response.Status.CREATED)::build);
    }

    private String randomDigits(int digitsCount){
        String result = "";
        for(int i = 0; i < digitsCount; i++){
            result += rd.nextInt(10);
        }
        return result;
    }


}
