package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Prefer;
import com.example.puddyBuddy.dto.prefer.PreferRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.exception.common.ErrorCode;
import com.example.puddyBuddy.repository.PreferRepository;
import com.example.puddyBuddy.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PreferService {
    private final PreferRepository preferRepository;
    private final UserRepository userRepository;

    public List<Prefer> getPrefers(){
        List<Prefer> prefers = preferRepository.findAll();
        return prefers;
    }

    public List<PreferRes> getPreferUser(Long userId) {
        List<Prefer> prefers = preferRepository.findByUserUserIdOrderByPreferIdAsc(userId);
        if(prefers.isEmpty()){
            throw new BusinessException(ErrorCode.EMPTY_DATA);
        }
        List<PreferRes> response = prefers.stream()
                .map(PreferRes::new)
                .collect(Collectors.toList());
        return response;
    }
}