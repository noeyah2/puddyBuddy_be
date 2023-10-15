package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Long> {
    List<Color> findAll();
}
