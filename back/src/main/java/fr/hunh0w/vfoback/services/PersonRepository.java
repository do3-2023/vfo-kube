package fr.hunh0w.vfoback.services;

import fr.hunh0w.vfoback.entities.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Random;

@ApplicationScoped
public class PersonRepository {

    public List<Person> getPersons(){
        return Person.findAll().list();
    }

}
