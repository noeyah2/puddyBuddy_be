package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.Clothes;
import com.example.puddyBuddy.dto.clothes.ClothesListRes;
import com.example.puddyBuddy.repository.ClothesRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.puddyBuddy.service.ClothesService;
import com.example.puddyBuddy.exception.common.*;
import com.example.puddyBuddy.response.BaseResponse;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping( value = "/clothes",  produces = "application/json;charset=utf8")
@Tag(name = "의류 API")
public class ClothesController {
    private final ClothesService clothesService;
    private final ClothesRepository clothesRepository;

    public ClothesController(ClothesService clothesService, ClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
        this.clothesService = clothesService;
    }

    @Operation(summary = "의류 검색")
    @GetMapping("/search")
    public BaseResponse<List<ClothesListRes>> getClothes(
            @RequestParam(name = "color_id", required = false, defaultValue = "-1") Long colorId,
            @RequestParam(name = "sizeClothes_id", required = false, defaultValue = "-1") Long sizeClothesId,
            @RequestParam(name = "personalcolor_id", required = false) Long personalColorId,
            @RequestParam(name = "store_id", required = false) Long storeId
    ) {
        try {
            Specification<Clothes> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();

                if (colorId != null && colorId != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("color").get("colorId"), colorId));
                }
                if (sizeClothesId != null && sizeClothesId != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("sizeClothesId"), sizeClothesId));
                }
                if (personalColorId != null) {
                    predicates.add(criteriaBuilder.equal(root.get("personalColor").get("personalColorId"), personalColorId));
                }
                if (storeId != null) {
                    predicates.add(criteriaBuilder.equal(root.get("store").get("storeId"), storeId));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            List<Clothes> clothes = clothesRepository.findAll(spec);
            List<ClothesListRes> clothesList = clothes.stream()
                    .map(ClothesListRes::new)
                    .collect(Collectors.toList());

            return new BaseResponse<>(clothesList);
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }
}
