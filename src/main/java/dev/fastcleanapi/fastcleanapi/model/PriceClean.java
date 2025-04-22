package dev.fastcleanapi.fastcleanapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "price_clean")
public class PriceClean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_size_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_sizetype_priceclean"))
    private SizeType sizeType;

    private float price;

//    @ManyToOne
//    @JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name = "fk_order_priceclean"))
//    private Order order;

    public PriceClean() {

    }
}
