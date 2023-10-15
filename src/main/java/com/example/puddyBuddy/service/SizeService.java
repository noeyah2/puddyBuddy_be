package com.example.puddyBuddy.service;


import com.example.puddyBuddy.domain.Size;
import com.example.puddyBuddy.repository.SizeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {
    private final SizeRepository userRepository;

    public SizeService(SizeRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Size> getSizes(){
        List<Size> objs = userRepository.findAll();
        return objs;
    }
}
