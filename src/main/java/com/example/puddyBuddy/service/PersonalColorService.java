package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.PersonalColor;
import com.example.puddyBuddy.repository.PersonalColorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalColorService {
    private final PersonalColorRepository userRepository;

    public PersonalColorService(PersonalColorRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<PersonalColor> getPersonalColors(){
        List<PersonalColor> objs = userRepository.findAll();
        return objs;
    }
}
