package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.BreedTag;
import com.example.puddyBuddy.dto.breedtag.BreedTagRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.exception.common.ErrorCode;
import com.example.puddyBuddy.repository.BreedTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BreedTagService {
    private final BreedTagRepository breedTagRepository;

    public List<BreedTag> getBreedTags(){
        List<BreedTag> breedTags = breedTagRepository.findAll();
        return breedTags;
    }

    public BreedTagRes getBreedTagOne(Long breedTagId) {
        BreedTag breedTag = breedTagRepository.findByBreedTagId(breedTagId).orElseThrow(() -> new BusinessException(ErrorCode.EMPTY_DATA));
        BreedTagRes response = new BreedTagRes(breedTag);

        return response;
    }
}
