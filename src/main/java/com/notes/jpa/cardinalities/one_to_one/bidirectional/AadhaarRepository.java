package com.notes.jpa.cardinalities.one_to_one.bidirectional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AadhaarRepository extends JpaRepository<Aadhaar, Long> {
}
