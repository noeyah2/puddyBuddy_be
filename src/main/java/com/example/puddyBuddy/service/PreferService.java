package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Prefer;
import com.example.puddyBuddy.dto.prefer.PreferRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.exception.common.ErrorCode;
import com.example.puddyBuddy.repository.PreferRepository;
import com.example.puddyBuddy.repository.UserRepository;
import com.example.puddyBuddy.response.BaseResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PreferService {
    private final PreferRepository preferRepository;
    private final UserRepository userRepository;

//    public List<Prefer> getPrefers(){
//        List<Prefer> prefers = preferRepository.findAll();
//        return prefers;
//    }

//    public List<PreferListRes> getAllPrefers(){
//        List<Prefer> prefers = preferRepository.findAll();
//        List<PreferListRes> dtos = prefers.stream()
//                .map(PreferListRes::toPreferDTO)
//                .collect(Collectors.toList());
//        return dtos;
//    }

    public PreferRes getPreferUser(Long userId) {
        Prefer prefer = preferRepository.findByPreferId(userId).orElseThrow(() -> new BusinessException(ErrorCode.EMPTY_DATA));
        PreferRes response = new PreferRes(prefer);
        return response;
    }
}