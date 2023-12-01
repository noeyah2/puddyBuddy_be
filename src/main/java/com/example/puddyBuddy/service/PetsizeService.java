package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Petsize;
import com.example.puddyBuddy.dto.petsize.PetsizeRes;
import com.example.puddyBuddy.repository.PetsizeRepository;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class PetsizeService {
    private final PetsizeRepository petsizeRepository;

    public PetsizeService(PetsizeRepository petsizeRepository){
        this.petsizeRepository = petsizeRepository;
    }

    public PetsizeRes makePetsizeTest(Long preferId, String img){
        // flask 서버로 요청
        // 사진 넣고 그 결과값 perferid - back과 chest db에 저장

        PetsizeRes res = new PetsizeRes();
        res.getBack();
        res.getChest();
        return res;
    }
}
