package com.example.puddyBuddy.service;

import com.example.puddyBuddy.repository.PetsnalColorRepository;
import org.springframework.stereotype.Service;

@Service
public class PetsnalColorService {
    private final PetsnalColorRepository petsnalColorRepository;

    public PetsnalColorService(PetsnalColorRepository petsnalColorRepository) {
        this.petsnalColorRepository = petsnalColorRepository;
    }
}
