package com.notes.jpa.cardinalities.many_to_many;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;

    @ManyToMany(mappedBy = "coursesList")
    List<Students> studentsList;


}
