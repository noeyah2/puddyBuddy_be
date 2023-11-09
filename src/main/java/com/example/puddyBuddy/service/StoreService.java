package com.example.puddyBuddy.service;


import com.example.puddyBuddy.domain.Store;
import com.example.puddyBuddy.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public List<Store> getStores(){
        List<Store> objs = storeRepository.findAll();
        return objs;
    }
}
