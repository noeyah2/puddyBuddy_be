package com.example.puddyBuddy.service;


import com.example.puddyBuddy.domain.Color;
import com.example.puddyBuddy.repository.ColorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    private final ColorRepository userRepository;

    public ColorService(ColorRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Color> getColors(){
        List<Color> objs = userRepository.findAll();
        return objs;
    }
}