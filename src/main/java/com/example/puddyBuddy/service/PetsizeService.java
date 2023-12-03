package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.BreedTag;
import com.example.puddyBuddy.domain.Petsize;
import com.example.puddyBuddy.domain.Prefer;
import com.example.puddyBuddy.dto.petsize.PetsizeCreateRes;
import com.example.puddyBuddy.dto.petsize.PetsizeInfoRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.exception.common.ErrorCode;
import com.example.puddyBuddy.repository.BreedTagRepository;
import com.example.puddyBuddy.repository.PetsizeRepository;
import com.example.puddyBuddy.repository.PreferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class PetsizeService {
    private final PetsizeRepository petsizeRepository;
    private final PreferRepository preferRepository;
    private final BreedTagRepository breedTagRepository;

    @Autowired
    public PetsizeService(PetsizeRepository petsizeRepository, PreferRepository preferRepository, BreedTagRepository breedTagRepository) {
        this.petsizeRepository = petsizeRepository;
        this.preferRepository = preferRepository;
        this.breedTagRepository = breedTagRepository;
    }

    public PetsizeCreateRes createSize(Long preferId, Float neck, Float chest, Float back, Float leg) {
        Petsize newPetsize = new Petsize();
        PetsizeCreateRes petsizeCreateRes = new PetsizeCreateRes();

        // prefer
        Optional<Prefer> prefer = preferRepository.findByPreferId(preferId);

        if (prefer.isEmpty()) {
            throw new BusinessException(ErrorCode.EMPTY_DATA);
        }
        newPetsize.setPrefer(prefer.get());

        // etc
        newPetsize.setNeck(neck);
        newPetsize.setChest(chest);
        newPetsize.setBack(back);
        newPetsize.setLeg(leg);

        Long newPetsizeId = petsizeRepository.save(newPetsize).getPetsizeId();
        petsizeCreateRes.setPetsizeId(newPetsizeId);

        return petsizeCreateRes;
    }

    public PetsizeInfoRes getPercentages(long breedTagId, long petsizeId) {
        // Step 1: Find breedtagcode based on breedcode
        String breedTagCode = searchBreedcode(breedTagId);

        // Step 2: Find breeds with the same breedtagcode
        List<Petsize> breedPetsizes = petsizeRepository.findByBreedTagBreedTagCode(breedTagCode);

        if (breedPetsizes.isEmpty()) {
            throw new BusinessException(ErrorCode.NO_EXIST_PETSIZECODE);
        }

        // Step 3: Find Petsize based on petsizeId
        Optional<Petsize> petsizeOptional = petsizeRepository.findById(petsizeId);
        if (petsizeOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.NO_EXIST_PETSIZECODE);
        }
        Petsize userPetsize = petsizeOptional.get();

        // Step 4: Calculate percentages
        Float perNeck = calculatePercentage(userPetsize.getNeck(), calculateAverage(breedPetsizes, "neck"));
        Float perChest = calculatePercentage(userPetsize.getChest(), calculateAverage(breedPetsizes, "chest"));
        Float perBack = calculatePercentage(userPetsize.getBack(), calculateAverage(breedPetsizes, "back"));
        Float perLeg = calculatePercentage(userPetsize.getLeg(), calculateAverage(breedPetsizes, "leg"));

        PetsizeInfoRes petsizeInfoRes = new PetsizeInfoRes();
        petsizeInfoRes.setPerNeck(perNeck);
        petsizeInfoRes.setPerChest(perChest);
        petsizeInfoRes.setPerBack(perBack);
        petsizeInfoRes.setPerLeg(perLeg);

        return petsizeInfoRes;
    }

    private String searchBreedcode(long breedTagId) {
        Optional<BreedTag> breedTagOptional = breedTagRepository.findById(breedTagId);

        if (breedTagOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.NO_EXIST_BREEDTAGID);
        }

        return breedTagOptional.get().getBreedTagCode();
    }

    private Float calculateAverage(List<Petsize> petsizes, String attribute) {
        // Calculate the average value for the specified attribute (neck, chest, back, leg)
        float sum = 0;
        int count = 0;

        for (Petsize petsize : petsizes) {
            switch (attribute) {
                case "neck":
                    sum += petsize.getNeck();
                    break;
                case "chest":
                    sum += petsize.getChest();
                    break;
                case "back":
                    sum += petsize.getBack();
                    break;
                case "leg":
                    sum += petsize.getLeg();
                    break;
            }
            count++;
        }

        return count > 0 ? sum / count : 0;
    }

    private Float calculatePercentage(Float userValue, Float petValue) {
        // Add your logic here to calculate the percentage
        // You might want to handle cases where the petValue is 0 to avoid division by zero
        if (petValue == null || petValue == 0) {
            throw new BusinessException(ErrorCode.EMPTY_DATA);
        }
        return (userValue / petValue) * 100;
    }
}