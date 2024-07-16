package com.notes.jpa.inheritance.single_table;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "mentor_st")
@DiscriminatorValue(value = "1")
public class Mentor extends Users {

    @Column(name = "staff_pass")
    private String staffPass;
}
