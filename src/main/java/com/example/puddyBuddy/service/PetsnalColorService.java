package com.example.puddyBuddy.service;

import com.example.puddyBuddy.dto.PetsnalColor.PetsnalColorStartRes;
import com.example.puddyBuddy.repository.PetsnalColorRepository;
import org.springframework.stereotype.Service;

@Service
public class PetsnalColorService {
    private final PetsnalColorRepository petsnalColorRepository;

    public PetsnalColorService(PetsnalColorRepository petsnalColorRepository) {
        this.petsnalColorRepository = petsnalColorRepository;
    }

    public PetsnalColorStartRes makePetsnalTest(Long PreferId, String img){
        // flask 서버로 요청
        // => preferid-img petsnalcolors db에 저장

        PetsnalColorStartRes res = new PetsnalColorStartRes();
        res.setResult(true);
        return res;
    }
}
