package com.notes.jpa.cardinalities.one_to_one.unidirectional;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "profiles")
@Data
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String firstName;

    private String lastName;
}
