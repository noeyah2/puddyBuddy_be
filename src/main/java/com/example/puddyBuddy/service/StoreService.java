package com.example.puddyBuddy.service;


import com.example.puddyBuddy.domain.Store;
import com.example.puddyBuddy.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private final StoreRepository userRepository;

    public StoreService(StoreRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Store> getStores(){
        List<Store> objs = userRepository.findAll();
        return objs;
    }
}
