package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long>, JpaSpecificationExecutor<Clothes> {
    List<Clothes> findAll();
    Optional<Clothes> findByClothesId(Long clothesId);

}


