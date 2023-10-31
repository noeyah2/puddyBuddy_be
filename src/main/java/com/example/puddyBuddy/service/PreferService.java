package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Prefer;
import com.example.puddyBuddy.dto.prefer.PreferDTO;

import com.example.puddyBuddy.repository.PreferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreferService {
    private final PreferRepository userRepository;

    public PreferService(PreferRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Prefer> getPrefers(){
        List<Prefer> objs = userRepository.findAll();
        return objs;
    }

    public List<PreferDTO> getAllPreferDTOs(){
        List<Prefer> objs = userRepository.findAll();
        List<PreferDTO> dtos = objs.stream()
                .map(PreferDTO::toPreferDTO)
                .collect(Collectors.toList());
        return dtos;
    }

}