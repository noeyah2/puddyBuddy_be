package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.ArClothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArClothesRepository extends JpaRepository<ArClothes, Long> {
    List<ArClothes> findAll();
}

