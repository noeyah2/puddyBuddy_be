package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.PetsizeTotal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface PetsizeTotalRepository extends JpaRepository<PetsizeTotal, Long> {
    List<PetsizeTotal> findByBreedTagBreedTagCode(String breedTagCode);
}
