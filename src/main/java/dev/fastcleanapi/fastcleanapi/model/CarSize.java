package dev.fastcleanapi.fastcleanapi.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor

@Getter
@Setter
@Entity
@Table (name = "car_size")

public class CarSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int type_size_id;

    @ManyToOne
    @JoinColumn(name = "type_model_car_id", nullable = false,  foreignKey = @ForeignKey(name = "fk_typemodelcar_carsize"))
    private TypeModelCar typeModelCar;

    public CarSize() {
    }
}