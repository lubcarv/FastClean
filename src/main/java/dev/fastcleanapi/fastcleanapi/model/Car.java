package dev.fastcleanapi.fastcleanapi.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "cars")
public class Car {

    @Getter
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String carModel;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}