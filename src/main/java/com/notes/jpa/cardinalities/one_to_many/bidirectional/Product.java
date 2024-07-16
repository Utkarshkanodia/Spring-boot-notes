package com.notes.jpa.cardinalities.one_to_many.bidirectional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
   // @JsonBackReference
    Category category;
}
