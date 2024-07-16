package com.notes.jpa.cardinalities.one_to_one.bidirectional;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aadhaar_id", referencedColumnName = "id")
    Aadhaar aadhaar;

}
