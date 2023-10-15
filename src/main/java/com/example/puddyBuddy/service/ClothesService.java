package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Clothes;
import com.example.puddyBuddy.repository.ClothesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService {
    private final ClothesRepository userRepository;

    public ClothesService(ClothesRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Clothes> getClothess(){
        List<Clothes> objs = userRepository.findAll();
        return objs;
    }
}
