package com.notes.jpa.inheritance.joined_table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("user_jt")
public interface UserRepository extends JpaRepository<Users, UUID> {

    public Optional<Users> findByUsername(String username);
}
