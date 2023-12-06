package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.dto.PetsnalColor.*;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.PetsnalColorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
@RestController
@RequestMapping( value = "/petsnalColors",  produces = "application/json;charset=utf8")
@Tag(name = "펫스널 컬러 API")
public class PetsnalColorController {
    private final PetsnalColorService petsnalColorService;


    public PetsnalColorController(PetsnalColorService petsnalColorService) {
        this.petsnalColorService = petsnalColorService;
    }

    @Operation(summary = "테스트 시작", description = "선호 조건과 사용할 사진을 주면 서버에서 테스트를 만들고 테스트를 제공합니다.")
    @PostMapping("/start")
    public BaseResponse<PetsnalColorRes> makePetsnalTest(@RequestBody PetsnalColorStartReq petsnalColorStartReq) throws IOException {
        try {
            PetsnalColorRes res = petsnalColorService.makePetsnalTest(petsnalColorStartReq.getPreferId(), petsnalColorStartReq.getPhotoUrl());
            return new BaseResponse<>(res);
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "테스트 스테이지 진행", description = "스테이지마다 테스트를 제공합니다.")
    @PostMapping("/{stage}")
    public BaseResponse<PetsnalColorRes> doTest(@PathVariable int stage, @RequestBody PetsnalColorReq petsnalColorReq){
        try {
            PetsnalColorRes res = petsnalColorService.doTest(stage, petsnalColorReq.getPreferId(), petsnalColorReq.getResultList());
            return new BaseResponse<>(res);
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "테스트 사진 저장", description = "flask에서 처리한 이미지 url 리스트를 받아 db에 저장합니다.")
    @PostMapping("/saveTest/{preferId}")
    public BaseResponse<Boolean> saveTest(@PathVariable Long preferId, @RequestBody PetsnalTestImgReq petsnalTestImgReq){
        try {
            petsnalColorService.saveTestImg(preferId, petsnalTestImgReq.getImgUrls());
            return new BaseResponse<>(true);
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }



}
