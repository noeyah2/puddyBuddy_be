package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.PetsnalColorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping( value = "/petsnalColors",  produces = "application/json;charset=utf8")
public class PetsnalColorController {
    private final PetsnalColorService petsnalColorService;


    public PetsnalColorController(PetsnalColorService petsnalColorService) {
        this.petsnalColorService = petsnalColorService;
    }

    @Operation(summary = "테스트 제작", description = "선호 조건과 사용할 사진을 주면 서버에서 테스트를 만들고 성공 여부를 알려줍니다.")
    @PostMapping("/start")
    public BaseResponse<CommentCreateReq> makePetsnalTest(@PathVariable CommentCreateReq commentCreateReq){
        try {
            return new BaseResponse<>(breedTagService.getBreedTagOne(breedTagId));
        } catch (BusinessException e) {
            return true;
        }
    }
}
