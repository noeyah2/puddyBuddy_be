package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.PersonalColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalColorRepository extends JpaRepository<PersonalColor, Long> {
    List<PersonalColor> findAll();
}
