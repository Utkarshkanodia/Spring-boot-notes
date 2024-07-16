package com.notes.jpa.cardinalities.one_to_many.unidirectional;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
        @Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    List<Post> posts;
}
