package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.Prefer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreferRepository extends JpaRepository<Prefer, Long> {
    List<Prefer> findAll();
}
