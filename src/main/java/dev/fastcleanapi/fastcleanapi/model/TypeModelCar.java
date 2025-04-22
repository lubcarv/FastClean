package dev.fastcleanapi.fastcleanapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table (name = "type_model_car")

public class TypeModelCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "O tipo de modelo de carro é obrigatório")
    @Size(max = 50, message = "O tipo de modelo de carro deve ter no máximo 50 caracteres")
    @Column(name = "type_model", nullable = false, length = 50)
    private String typeModel;

    @OneToMany(mappedBy = "typeModelCar", cascade = CascadeType.ALL)
    private List<CarSize> carSizes = new ArrayList<>();

    public TypeModelCar() {

    }
}
