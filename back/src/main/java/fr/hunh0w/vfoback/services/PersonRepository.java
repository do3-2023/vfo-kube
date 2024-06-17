package fr.hunh0w.vfoback.services;

import fr.hunh0w.vfoback.entities.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Random;

@ApplicationScoped
public class PersonRepository {

    Random rd = new Random();

    public List<Person> getPersons(){
        return Person.findAll().list();
    }

    public Response generatePerson(){
        Person person = new Person();
        person.last_name = "Zglivendu-"+randomDigits(16);
        person.phone_number = "+33"+randomDigits(9);
        //person.location = "Paris";
        person.persist();
        return Response.ok(person).status(Response.Status.CREATED).build();
    }

    private String randomDigits(int digitsCount){
        String result = "";
        for(int i = 0; i < digitsCount; i++){
            result += rd.nextInt(10);
        }
        return result;
    }


}
