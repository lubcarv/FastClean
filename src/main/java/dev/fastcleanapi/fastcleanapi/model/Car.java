package dev.fastcleanapi.fastcleanapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor

@Getter
@Setter
@Entity
@Table (name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "O modelo do carro é obrigatório")
    @Size(max = 100, message = "O modelo do carro deve ter no máximo 100 caracteres")
    @Column(name = "car_model", nullable = false, length = 100)
    private String carModel;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false,  foreignKey = @ForeignKey(name = "fk_car_client"))
    private Client client;

    public Car() {

    }
}
