package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.PersonalColor;
import com.example.puddyBuddy.domain.PetsnalColor;
import com.example.puddyBuddy.domain.Prefer;
import com.example.puddyBuddy.dto.PetsnalColor.PetsnalColorRes;
import com.example.puddyBuddy.repository.PersonalColorRepository;
import com.example.puddyBuddy.repository.PetsnalColorRepository;
import com.example.puddyBuddy.repository.PreferRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetsnalColorService {
    private final PetsnalColorRepository petsnalColorRepository;
    private final PreferRepository preferRepository;

    private final PersonalColorRepository personalColorRepository;

    public PetsnalColorService(PetsnalColorRepository petsnalColorRepository, PreferRepository preferRepository, PersonalColorRepository personalColorRepository) {
        this.petsnalColorRepository = petsnalColorRepository;
        this.preferRepository = preferRepository;
        this.personalColorRepository = personalColorRepository;
    }

    public PetsnalColorRes makePetsnalTest(Long preferId, String img){
        // flask 서버로 요청
        // => preferid-img petsnalcolors db에 저장

        PetsnalColorRes res = new PetsnalColorRes();
        res.setNextStage(1);
        res.setPhotoUrlList(getTestImgSet(1, preferId));
        res.setResult(0);
        return res; // 1번 테스트 주도록 변경
    }

    public PetsnalColorRes doTest(int stage,Long preferId, List<Integer> resultList){
        // 결과 분석
        // next stage, photo_url_list, result 세팅
        PetsnalColorRes res = new PetsnalColorRes();
        int nextStage = 0;
        int result = 0;
        List<String> list = new ArrayList<>();
        switch (stage){
            case 1: // warm, cool 검사
                nextStage = testResult(2, 3, resultList); // warm, cool
                res.setNextStage(nextStage);
                res.setPhotoUrlList(getTestImgSet(nextStage, preferId));
                res.setResult(0);
                break;
            case 2: // <warm> clean, dull 검사
                nextStage = testResult(4, 5, resultList);  // clean, dull
                res.setNextStage(nextStage);
                res.setPhotoUrlList(getTestImgSet(nextStage, preferId));
                res.setResult(0);
                break;
            case 3: // <cool> light 검사
                res.setNextStage(nextStage); // 0
                res.setPhotoUrlList(list); // []
                result = testResult(4, 2, resultList);
                res.setResult(result); // winter, summer
                saveTestResult(preferId, result);
                break;
            case 4:
                res.setNextStage(nextStage); // 0
                res.setPhotoUrlList(list); // []
                result = testLightResult(4, resultList);
                res.setResult(result); // autumn, spring
                saveTestResult(preferId, result);
                break;
            case 5:
                res.setNextStage(nextStage); // 0
                res.setPhotoUrlList(list); // []
                result = testLightResult(5, resultList);
                res.setResult(result); // autumn, spring
                saveTestResult(preferId, result);
                break;
            default:
                break;
        }

        return res;
    }

    private int testResult(int a, int b, List<Integer> resultList){
        if (resultList.size() >6){
            return (resultList.get(6) == 0? a : b);
        }else {
            int evenSum = 0;
            int oddSum = 0;
            for (int i = 0; i < resultList.size(); i++) {
                if (i % 2 == 0) {
                    evenSum += resultList.get(i);
                } else {
                    oddSum += resultList.get(i);
                }
            }
            return (evenSum>oddSum? a :b);
        }
    }

    private int testLightResult(int currStage, List<Integer> resultList){
        int result = -1;
        switch (currStage){
            case 4:
                if(resultList.get(0) == 0) result = 3; else result = 1;
                break;
            case 5:
                if(resultList.get(0) == 2) result = 1; else result = 3;
                break;
            default:
                break;
        }
        return result;
    }

    private List<String> getTestImgSet(int stageNum, Long preferId){
        List<PetsnalColor> res = petsnalColorRepository.findPhotoUrlByStageIdAndPrefer_PreferIdOrderByPetsnalColorIdAsc((long) stageNum, preferId);
        List<String> photos = new ArrayList<>();
        for (PetsnalColor photo : res) {
            photos.add(photo.getPhotoUrl());
        }

        return photos;
    }

    private void saveTestResult(Long preferId, int result) {
        Optional<Prefer> preferOptional = preferRepository.findByPreferId(preferId);
        Optional<PersonalColor> pcOptional = personalColorRepository.findByPersonalColorId(result);

        if (preferOptional.isPresent() && pcOptional.isPresent()) {
            Prefer prefer = preferOptional.get();
            PersonalColor pc = pcOptional.get();
            prefer.setPersonalColor(pc);
            preferRepository.save(prefer);
        } else {
            throw new IllegalArgumentException("Invalid preferId or personalColorId");
        }
    }

}
