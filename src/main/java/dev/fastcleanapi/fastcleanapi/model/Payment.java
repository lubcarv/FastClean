package dev.fastcleanapi.fastcleanapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_order_payment"))
    private Order order;

    @NotBlank(message = "O método de pagamento é obrigatório")
    @Size(max = 50, message = "O método de pagamento não pode ter mais de 50 caracteres")
    private String method;

    @Positive(message = "O preço deve ser maior que zero")
    @Column(nullable = false)
    private float price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_status_id", referencedColumnName = "id",  foreignKey = @ForeignKey(name = "fk_paymentstatus_payment"))
    private PaymentStatus paymentStatus;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate created_at;

    public Payment() {

    }
}
