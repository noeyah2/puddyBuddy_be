package com.example.puddyBuddy.repository;
import com.example.puddyBuddy.domain.PersonalColor;
import com.example.puddyBuddy.domain.PetsnalColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetsnalColorRepository extends JpaRepository<PetsnalColor, Long> {
    List<PetsnalColor> findAll();
}
