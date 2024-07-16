package com.notes.jpa.inheritance.single_table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository("student_st")
public interface StudentRepository extends JpaRepository<Student, UUID> {
}
