package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Clothes;
import com.example.puddyBuddy.repository.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothesService {
    private final ClothesRepository clothesRepository;

    public List<Clothes> getClothess(){
        List<Clothes> clothes = clothesRepository.findAll();
        return clothes;
    }
}
