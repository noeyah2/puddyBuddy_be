package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.BreedTag;
import com.example.puddyBuddy.domain.PersonalColor;
import com.example.puddyBuddy.dto.breedtag.BreedTagListRes;
import com.example.puddyBuddy.dto.personalColor.PersonalListRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.PersonalColorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping( value = "/personalColors",  produces = "application/json;charset=utf8")
public class PersonalColorController {
    private final PersonalColorService personalColorService;

    public PersonalColorController(PersonalColorService personalColorService) {
        this.personalColorService = personalColorService;
    }

//    @Operation(summary = "퍼스널컬러 목록 전부 보기")
//    @GetMapping
//    public BaseResponse<List<PersonalListRes>> getPersonals() {
//        try {
//            List<PersonalColor> personalColors = personalColorService.getPersonalColors();
//            List<PersonalColor> personalColorList = personalColors.stream()
//                    .map(PersonalListRes::new)
//                    .collect(Collectors.toList());
//            return new BaseResponse<>(personalColorList);
//        } catch(BusinessException e) {
//            return new BaseResponse<>(e.getErrorCode());
//        }
//    }
}
