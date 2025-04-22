package dev.fastcleanapi.fastcleanapi.model;

import dev.fastcleanapi.fastcleanapi.model.Login.Login;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "customer_order")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_client_oder"))
    private Client client;

    @ManyToOne
    @JoinColumn(
            name = "price_clean_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_order_priceclean")
    )
    private PriceClean priceClean;


    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "price_clean_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_priceclean_order"))
    //private PriceClean priceClean;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_login_order"))
    private Login login;

    @OneToOne
    @JoinColumn(name = "order_status_id", nullable = false, foreignKey = @ForeignKey(name = "fk_orderstatus_order") )
    private OrderStatus status;

    // Data de criação
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate created_at;


    public Order() {

    }
}
