package fr.hunh0w.vfoback.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person extends PanacheEntity {

    public String last_name;
    public String phone_number;

    @Nonnull
    public String location;

}
