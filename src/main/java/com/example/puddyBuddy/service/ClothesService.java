package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Clothes;
import com.example.puddyBuddy.dto.clothes.ClothesRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.exception.common.ErrorCode;
import com.example.puddyBuddy.repository.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothesService {
    private final ClothesRepository clothesRepository;

    public List<Clothes> getClothesALL() {
        List<Clothes> clothes = clothesRepository.findAll();
        return clothes;
    }

    public ClothesRes getClothesOne(Long clothesId) {
        Clothes clothes = clothesRepository.findByClothesId(clothesId).orElseThrow(() -> new BusinessException(ErrorCode.EMPTY_DATA));
        ClothesRes response = new ClothesRes(clothes);

        return response;
    }
}
