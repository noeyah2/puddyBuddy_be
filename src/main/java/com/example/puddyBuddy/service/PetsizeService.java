package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.BreedTag;
import com.example.puddyBuddy.domain.Petsize;
import com.example.puddyBuddy.domain.PetsizeTotal;
import com.example.puddyBuddy.domain.Prefer;
import com.example.puddyBuddy.dto.petsize.PetsizeCreateRes;
import com.example.puddyBuddy.dto.petsize.PetsizeInfoRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.exception.common.ErrorCode;
import com.example.puddyBuddy.repository.BreedTagRepository;
import com.example.puddyBuddy.repository.PetsizeRepository;
import com.example.puddyBuddy.repository.PetsizeTotalRepository;
import com.example.puddyBuddy.repository.PreferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class PetsizeService {
    private final PetsizeRepository petsizeRepository;
    private final PreferRepository preferRepository;
    private final PetsizeTotalRepository petsizeTotalRepository;

    @Autowired
    public PetsizeService(PetsizeRepository petsizeRepository, PreferRepository preferRepository, PetsizeTotalRepository petsizeTotalRepository) {
        this.petsizeRepository = petsizeRepository;
        this.preferRepository = preferRepository;
        this.petsizeTotalRepository = petsizeTotalRepository;
    }

    public PetsizeCreateRes createSize(Long preferId, Float neck, Float chest, Float back, Float leg) {
        PetsizeCreateRes petsizeCreateRes = new PetsizeCreateRes();
        Petsize newPetsize = new Petsize();

        // Step 1: 선호조건 번호를 통해 Prefer 찾기
        Prefer prefer = findPreferById(preferId);

        // Step 2: 찾은 Prefer를 새로운 펫 사이즈에 설정하기
        newPetsize.setPrefer(prefer);

        // Step 3: 찾은 Prefer에서 BreedTag 얻어오기
        BreedTag breedTag = prefer.getBreedTag();
        newPetsize.setBreedTag(breedTag);

        // Step 4: 다른 속성들 설정하기
        newPetsize.setNeck(neck);
        newPetsize.setChest(chest);
        newPetsize.setBack(back);
        newPetsize.setLeg(leg);

        // Step 5: 새로운 펫 사이즈 저장하기
        Long newPetsizeId = petsizeRepository.save(newPetsize).getPetsizeId();
        petsizeCreateRes.setPetsizeId(newPetsizeId);

        // Step 6: Prefer 엔터티에 새로운 Petsize 참조 설정하기
        prefer.setPetsize(newPetsize);
        preferRepository.save(prefer); // 업데이트된 Prefer 저장

        return petsizeCreateRes;
    }

    private Prefer findPreferById(Long preferId) {
        Optional<Prefer> prefer = preferRepository.findByPreferId(preferId);

        if (prefer.isEmpty()) {
            throw new BusinessException(ErrorCode.EMPTY_DATA);
        }

        return prefer.get();
    }

    public PetsizeInfoRes getPercentages(long petsizeId) {
        Petsize userPetsize = findPetsizeById(petsizeId);

        String breedTagCode = userPetsize.getBreedTag().getBreedTagCode();
        List<PetsizeTotal> breedPetsizeTotals = findPetsizeTotalsByBreedTagCode(breedTagCode);

        Float perNeck = calculatePercentage(userPetsize.getNeck(), findAverageByPart(breedPetsizeTotals, "neck-size"));
        Float perChest = calculatePercentage(userPetsize.getChest(), findAverageByPart(breedPetsizeTotals, "chest-size"));
        Float perBack = calculatePercentage(userPetsize.getBack(), findAverageByPart(breedPetsizeTotals, "back-length"));
        Float perLeg = calculatePercentage(userPetsize.getLeg(), findAverageByPart(breedPetsizeTotals, "shoulder-height"));

        PetsizeInfoRes petsizeInfoRes = new PetsizeInfoRes();
        petsizeInfoRes.setPerNeck(perNeck);
        petsizeInfoRes.setPerChest(perChest);
        petsizeInfoRes.setPerBack(perBack);
        petsizeInfoRes.setPerLeg(perLeg);

        return petsizeInfoRes;
    }

    public Petsize findPetsizeById(long petsizeId) {
        Optional<Petsize> petsizeOptional = petsizeRepository.findById(petsizeId);
        if (petsizeOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.NO_EXIST_PETSIZECODE);
        }
        return petsizeOptional.get();
    }

    private List<PetsizeTotal> findPetsizeTotalsByBreedTagCode(String breedTagCode) {
        List<PetsizeTotal> breedPetsizeTotals = petsizeTotalRepository.findByBreedTagBreedTagCode(breedTagCode);
        if (breedPetsizeTotals.isEmpty()) {
            throw new BusinessException(ErrorCode.EMPTY_DATA);
        }
        return breedPetsizeTotals;
    }

    private Float findAverageByPart(List<PetsizeTotal> petsizeTotals, String part) {
        for (PetsizeTotal petsizeTotal : petsizeTotals) {
            if (petsizeTotal.getPart().equals(part)) {
                return petsizeTotal.getAvg();
            }
        }
        throw new BusinessException(ErrorCode.EMPTY_DATA);
    }

    private Float calculateAverage(List<Petsize> petsizes, String attribute) {
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
        Float average = count > 0 ? sum / count : null;
        printToConsole(attribute, average); // 콘솔에 출력
        return average;
    }
    private void printToConsole(String attribute, Float average) {
        System.out.println(attribute + " Average: " + (average != null ? average : "N/A"));
    }

    private Float calculatePercentage(Float userValue, Float petValue) {
        // petValue가 사용 가능하고 0이 아닌지 확인합니다.
        if (petValue == null || petValue == 0) {
            throw new BusinessException(ErrorCode.INVALID_PET_SIZE);
        }

        // 백분율을 계산합니다.
        float percentage = (userValue / petValue) * 100;

        // 백분율이 유효한 범위 (0에서 100) 내에 있는지 확인합니다.
        if (percentage < 0 || percentage > 100) {
            throw new BusinessException(ErrorCode.INVALID_PERCENTAGE);
        }

        return percentage;
    }
}