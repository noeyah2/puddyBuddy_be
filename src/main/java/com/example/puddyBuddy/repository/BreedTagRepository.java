package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.BreedTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BreedTagRepository extends JpaRepository<BreedTag, Long> {
    List<BreedTag> findAll();

    Optional<BreedTag> findByBreedTagId(long breedTagId);
}
