package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.BreedTag;
import com.example.puddyBuddy.repository.BreedTagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedTagService {
    private final BreedTagRepository userRepository;

    public BreedTagService(BreedTagRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<BreedTag> getBreedTags(){
        List<BreedTag> objs = userRepository.findAll();
        return objs;
    }
}
