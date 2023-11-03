package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.PersonalColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonalColorRepository extends JpaRepository<PersonalColor, Long> {
    List<PersonalColor> findAll();

    Optional<PersonalColor> findByPersonalColorId(long personalColorId);
}
