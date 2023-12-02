package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Petsize;
import com.example.puddyBuddy.domain.Prefer;
import com.example.puddyBuddy.dto.petsize.PetsizeCreateRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.exception.common.ErrorCode;
import com.example.puddyBuddy.repository.PetsizeRepository;
import com.example.puddyBuddy.repository.PreferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PetsizeService {
    private final PetsizeRepository petsizeRepository;
    private final PreferRepository preferRepository;

    public PetsizeService(PetsizeRepository petsizeRepository){
        this.petsizeRepository = petsizeRepository;
    }

    public PetsizeCreateRes createSize(Long preferId, Float neck, Float chest, Float back, Float leg){
        Petsize newPetsize = new Petsize();
        PetsizeCreateRes petsizeCreateRes = new PetsizeCreateRes();

        // prefer
        Optional<Prefer> prefer = preferRepository.findByPreferId(preferId);

        if(prefer.isEmpty()){
            throw new BusinessException(ErrorCode.EMPTY_DATA);
        }
        newPetsize.setPrefer(prefer.get());

        // etc
        newPetsize.setNeck(neck);
        newPetsize.setChest(chest);
        newPetsize.setBack(back);
        newPetsize.setLeg(leg);

        Long newPetsizeId = petsizeRepository.save(newPetsize).getPetSizeId();
        petsizeCreateRes.setPetsizeId(newPetsizeId);

        return petsizeCreateRes;
    }
}
