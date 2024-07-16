package com.notes.jpa.inheritance.joined_table;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "student_jt")
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue(value = "2")
public class Student extends Users {

    @Column(name = "college_pass")
    private String collegePass;

}
