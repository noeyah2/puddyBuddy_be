package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.Petsize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetsizeRepository extends JpaRepository<Petsize, Long> {
    List<Petsize> findAll();
}
