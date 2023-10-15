package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.ClothesPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothesPhotoRepository extends JpaRepository<ClothesPhoto, Long> {
    List<ClothesPhoto> findAll();
}

