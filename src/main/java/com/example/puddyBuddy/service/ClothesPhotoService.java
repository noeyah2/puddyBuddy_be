package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.ClothesPhoto;
import com.example.puddyBuddy.repository.ClothesPhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesPhotoService {
    private final ClothesPhotoRepository userRepository;

    public ClothesPhotoService(ClothesPhotoRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<ClothesPhoto> getClothesPhotos(){
        List<ClothesPhoto> objs = userRepository.findAll();
        return objs;
    }
}
