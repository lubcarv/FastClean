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
@Table (name = "model_brand")
public class   ModelBrand {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "O nome da marca é obrigatório")
    @Size(max = 10, message = "O nome deve ter no máximo 10 caracteres")
    @Column(nullable = false, length = 10)
    private String brandName;

    @NotBlank(message="O nome da marca é obrigatório")
    @Size(max = 15, message = "O nome da marca deve ter até 15 caracteres")
    @Column(nullable = false, length = 15, unique = true)
    private String modelName;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false, foreignKey = @ForeignKey(name = "fk_car_modelbrand"))
    private Car car;

    @ManyToOne
    @JoinColumn(name = "type_model_car_id", nullable = false,  foreignKey = @ForeignKey(name = "fk_typemodelcar_modelbrand"))
    private TypeModelCar typeModelCar;

    public ModelBrand() {

    }
}
