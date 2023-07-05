package fr.hunh0w.vfoback.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import jakarta.persistence.Entity;

@Entity
public class Car extends PanacheEntity {

    public String name;
    public String color;

}
