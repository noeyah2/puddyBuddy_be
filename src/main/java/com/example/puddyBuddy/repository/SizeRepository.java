package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SizeRepository extends JpaRepository<Size, Long> {
    List<Size> findAll();
}
