package dev.fastcleanapi.fastcleanapi.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {

    public Client() {

    }

    public Client(int id, String fullName, String email, String phone, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.createdAt = LocalDate.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        this.active = active;
    }

    @Getter
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String email;
    private String phone;

    @Getter
    @Setter(AccessLevel.NONE)
    private LocalDate createdAt;
    private boolean active;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars = new ArrayList<>();
}