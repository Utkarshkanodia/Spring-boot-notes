package com.notes.jpa.inheritance.joined_table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("mentor_jt")
public interface MentorRepository extends JpaRepository<Mentor, UUID> {
}
