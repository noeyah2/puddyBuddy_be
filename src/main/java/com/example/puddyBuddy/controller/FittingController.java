package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.dto.Fitting.FittingReq;
import com.example.puddyBuddy.dto.Fitting.FittingRes;
import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.FittingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Controller
@RestController
@RequestMapping( value = "/fitting",  produces = "application/json;charset=utf8")
@Tag(name = "가상 피팅 API")
public class FittingController {
        public final FittingService fittingService;

    public FittingController(FittingService fittingService) {
        this.fittingService = fittingService;
    }

    @Operation(summary = "가상 피팅", description = "옷 정보와 사진을 받아 가상 피팅 기능을 제공합니다.")
    @PostMapping("/")
    public BaseResponse<FittingRes> makePetsnalTest(@RequestBody FittingReq fittingReq) throws IOException, ParseException {
        FittingRes res = fittingService.makeFittingImg(fittingReq.getImgUrl(), fittingReq.getClothesId().toString());
        return new BaseResponse<>(res);
    }



    }
