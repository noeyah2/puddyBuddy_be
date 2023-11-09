package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.Clothes;
import com.example.puddyBuddy.dto.clothes.ClothesListRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.puddyBuddy.service.ClothesService;
import com.example.puddyBuddy.exception.common.*;
import com.example.puddyBuddy.response.BaseResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping( value = "/clothes",  produces = "application/json;charset=utf8")
@Tag(name = "의류 API")
public class ClothesController {
    private final ClothesService clothesService;

    public ClothesController(ClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @Operation(summary = "의류 전체 목록")
    @GetMapping
    public BaseResponse<List<ClothesListRes>>getClothes() {
        try {
            List<Clothes> clothes = clothesService.getClothess();
            List<ClothesListRes> clothesList = clothes.stream()
                    .map(ClothesListRes::new)
                    .collect(Collectors.toList());
            return new BaseResponse<>(clothesList);
        } catch(BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }


}
