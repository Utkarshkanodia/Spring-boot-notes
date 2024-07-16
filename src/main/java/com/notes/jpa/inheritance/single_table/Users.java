package com.notes.jpa.inheritance.single_table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "user_st")
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "userType",
        discriminatorType = DiscriminatorType.INTEGER
        //,columnDefinition = "varchar"
)
@DiscriminatorValue(value = "0")
public class Users {
    @Id
    @UuidGenerator
    UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
