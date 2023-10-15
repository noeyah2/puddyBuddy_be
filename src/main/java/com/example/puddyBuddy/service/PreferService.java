package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Prefer;
import com.example.puddyBuddy.repository.PreferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}