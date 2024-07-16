package com.notes.jpa.cardinalities.one_to_one.bidirectional;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "aadhaars")
public class Aadhaar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(unique = true, nullable = false)
    private String adhaarNumber;

    @Column(unique = true)
    private String vid;

    @OneToOne(mappedBy = "aadhaar")
    private Person person;

}
