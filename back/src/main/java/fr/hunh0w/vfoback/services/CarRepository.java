package fr.hunh0w.vfoback.services;

import fr.hunh0w.vfoback.entities.Car;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.util.Random;

@ApplicationScoped
public class CarRepository {

    Random rd = new Random();

    public Car getCar(){
        return Car.findAll().firstResult();
    }

    public Response generateCar(){
        Car car = new Car();
        car.name = "Toyota-"+randomDigits(16);
        car.color = "color-"+randomDigits(8);
        car.persist();
        return Response.ok(car).status(Response.Status.CREATED).build();
    }

    private String randomDigits(int digitsCount){
        String result = "";
        for(int i = 0; i < digitsCount; i++){
            result += rd.nextInt(10);
        }
        return result;
    }


}
