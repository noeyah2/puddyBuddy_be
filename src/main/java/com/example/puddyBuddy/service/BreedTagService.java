package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.BreedTag;
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
}
