package com.notes.jpa.inheritance.table_per_class;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "student_tpc")
@NoArgsConstructor
@Getter
@Setter
public class Student extends Users{

    @Column(name = "college_pass")
    private String collegePass;

}
