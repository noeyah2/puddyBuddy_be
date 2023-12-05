package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.dto.board.BoardRes;
import com.example.puddyBuddy.dto.clothesphoto.ClothesPhotoRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.ClothesPhotoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping( value = "/clothesPhotos",  produces = "application/json;charset=utf8")
public class ClothesPhotoController {
    private final ClothesPhotoService clothesPhotoService;

    public ClothesPhotoController(ClothesPhotoService clothesPhotoService) {
        this.clothesPhotoService = clothesPhotoService;
    }

    @Operation(summary = "옷 상세 조회", description = "옷 번호를 주면 해당 상세 정보를 불러옵니다.")
    @GetMapping("/{clothesId}")
    public BaseResponse<ClothesPhotoRes> getClothes(@PathVariable Long clothesId){
        try {
            return new BaseResponse<>(clothesPhotoService.getClothesPhotos(clothesId));
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }
}
