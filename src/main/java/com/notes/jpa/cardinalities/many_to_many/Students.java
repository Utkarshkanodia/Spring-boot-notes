package com.notes.jpa.cardinalities.many_to_many;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;

    @ManyToMany
    @JoinTable(
            name = "courses_id",
            joinColumns = @JoinColumn(name = "students_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Courses> coursesList;

}
