package dev.fastcleanapi.fastcleanapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "client")
public class Client {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "O nome deve ser completo.")
    @Size(min = 10, max = 100, message = "O nome deve ter entre 10 a 100 caracteres")
    @Column(nullable = false, length = 100)
    private String fullName;

    @NotBlank(message = "O documento é obrigatório")
    @Size(min = 11, max = 15)
    @Column(nullable = false, unique = true, length = 15)
    private String document;

    @NotBlank(message = "A inserção de um email é obrigatória")
    @Email (message = "O email deve ser válido")
    @Size(max = 100, message = "O email deve ter nomáximo 100 caracteres")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "O telefone é obrigatório")
    @Size( max = 15)
    @Pattern(
            regexp = "\\(?\\d{2}\\)?\\s?\\d{4,5}-\\d{4}",
            message = "O telefone deve estar em um formato válido"
    )
    private String phone;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();

    @Column(nullable = false)
    private boolean active = true;


    public Client() {

    }
}
