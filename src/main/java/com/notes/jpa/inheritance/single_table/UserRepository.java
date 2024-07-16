package com.notes.jpa.inheritance.single_table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository("user_st")
public interface UserRepository extends JpaRepository<Users, UUID> {
}
