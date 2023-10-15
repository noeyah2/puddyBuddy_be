package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.ArClothes;
import com.example.puddyBuddy.repository.ArClothesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArClothesService {
    private final ArClothesRepository userRepository;

    public ArClothesService(ArClothesRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<ArClothes> getArClothess(){
        List<ArClothes> objs = userRepository.findAll();
        return objs;
    }
}