package dev.fastcleanapi.fastcleanapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "size_type")
public class SizeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String size;

    @OneToOne(mappedBy = "sizeType", cascade = CascadeType.ALL)
    private PriceClean priceCleans;

    public SizeType() {

    }
}
