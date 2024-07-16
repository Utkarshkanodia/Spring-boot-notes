package com.notes.jpa.inheritance.table_per_class;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("mentor_tpc")
public interface MentorRepository extends JpaRepository<Mentor, UUID> {
}
