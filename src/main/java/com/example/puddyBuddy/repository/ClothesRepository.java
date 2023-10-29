package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClothesRepository extends JpaRepository<Clothes, Long> {
    List<Clothes> findAll();
    Optional<Clothes> findByClothesId(Long clothesId);
}

