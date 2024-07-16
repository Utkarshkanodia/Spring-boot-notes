package com.notes.jpa.inheritance.table_per_class;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository("student_tpc")
public interface StudentRepository extends JpaRepository<Student, UUID> {
}
