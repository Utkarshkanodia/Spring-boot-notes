package com.notes.jpa.inheritance.mapped_super_class;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("student_msc")
public interface StudentRepository extends JpaRepository<Student, UUID> {
}
