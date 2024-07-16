package com.notes.jpa.inheritance.mapped_super_class;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "mentor_msc")
public class Mentor extends Users {

    @Column(name = "staff_pass")
    private String staffPass;
}
