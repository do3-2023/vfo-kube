package fr.hunh0w.vfoback.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity(name = "car")
public class Car extends PanacheEntity {

    public String name;
    public String color;

}
