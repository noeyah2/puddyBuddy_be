package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.dto.prefer.PreferCreateReq;
import com.example.puddyBuddy.dto.prefer.PreferCreateRes;
import com.example.puddyBuddy.dto.prefer.PreferNumRes;
import com.example.puddyBuddy.dto.prefer.PreferRes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.PreferService;
import com.example.puddyBuddy.exception.common.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping( value = "/prefers",  produces = "application/json;charset=utf8")
@Tag(name = "선호 조건 API")
public class PreferController {
    private final PreferService preferService;
    public PreferController(PreferService preferService) {
        this.preferService = preferService;
    }

    @Operation(summary = "선호조건 회원별로 보기", description = "회원 번호를 넘겨주면 그 회원이 가진 선호 조건 리스트를 보내드립니다.")
    @GetMapping("/users/{userId}")
    public BaseResponse<List<PreferRes>> getPreferUser(@PathVariable Long userId){
        try {
            List<PreferRes> preferResList = preferService.getPreferUser(userId);
            return new BaseResponse<>(preferResList);
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "선호조건 아이디로 검색", description = "선호조건 번호를 넘겨주면 해당 선호 조건 리스트를 보내드립니다.")
    @GetMapping("/{preferId}")
    public BaseResponse<List<PreferNumRes>> getPreferId(@PathVariable Long preferId){
        try {
            List<PreferNumRes> prefer = preferService.getPreferId(preferId);
            return new BaseResponse<>(prefer);
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "선호조건 등록", description = "회원이 선호조건을 등록했습니다.")
    @PostMapping("/create/{userId}")
    public BaseResponse<PreferCreateRes> createPrefer(@RequestBody PreferCreateReq preferInsertReq){
        try {
            PreferCreateRes preferInsertRes = preferService.createPrefer(preferInsertReq.getUserId(), preferInsertReq.getPreferName(), preferInsertReq.getPersonalColorId(), preferInsertReq.getBreedTagId(), preferInsertReq.getPetsizeId());
            return new BaseResponse<>(preferInsertRes);
        } catch (BusinessException e){
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "선호조건 삭제", description = "해당 선호조건을 삭제했습니다.")
    @GetMapping("/delete/{preferId}")
    public String deletePrefer(@PathVariable Long preferId){
        preferService.deletePrefer(preferId);
        return "redirect:/prefers";
    }
}