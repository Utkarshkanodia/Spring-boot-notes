package com.notes.jpa.inheritance.mapped_super_class;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "student_msc")
@NoArgsConstructor
@Getter
@Setter
public class Student extends Users {

    @Column(name = "college_pass")
    private String collegePass;

}
