package com.example.puddyBuddy.service;

import com.example.puddyBuddy.dto.PetsnalColor.PetsnalColorRes;
import com.example.puddyBuddy.dto.PetsnalColor.PetsnalColorStartRes;
import com.example.puddyBuddy.repository.PetsnalColorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public PetsnalColorRes doTest(int stage,Long PreferId, List<Integer> resultList){
        // 결과 분석
        // next stage, photo_url_list, result 세팅
        PetsnalColorRes res = new PetsnalColorRes();
        int nextStage = 0;
        int result = 0;
        List<String> list = new ArrayList<>();
        switch (stage){
            case 1:
                nextStage = testResult(2, 3, resultList);
                res.setNextStage(nextStage);
                break;
            case 2:
                break;
            case 3:
                res.setNextStage(nextStage);
                res.setPhotoUrlList(list);
                res.setResult(testResult(4, 2, resultList));
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }


        return res;
    }

    private int testResult(int a, int b, List<Integer> resultList){
        if (resultList.size() >6){
            return (resultList.get(6) == 0? 2 : 3); // 0은 warm, 1은 cool
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
            return (evenSum>oddSum? 2 :3);
        }
    }
}
