package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.BreedTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedTagRepository extends JpaRepository<BreedTag, Long> {
    List<BreedTag> findAll();
}
