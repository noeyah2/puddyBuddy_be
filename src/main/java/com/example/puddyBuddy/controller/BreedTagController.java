package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.domain.BreedTag;
import com.example.puddyBuddy.dto.board.BoardListRes;
import com.example.puddyBuddy.dto.board.BoardRes;
import com.example.puddyBuddy.dto.breedtag.BreedTagListRes;
import com.example.puddyBuddy.dto.breedtag.BreedTagRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.BreedTagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping( value = "/breedTags",  produces = "application/json;charset=utf8")
@Tag(name = "견종 API")
public class BreedTagController {
    private final BreedTagService breedTagService;

    public BreedTagController(BreedTagService breedTagService) {
        this.breedTagService = breedTagService;
    }

    @Operation(summary = "견종 목록 전부 보기")
    @GetMapping
    public BaseResponse<List<BreedTagListRes>> getBoards() {
        try {
            List<BreedTag> breedTags = breedTagService.getBreedTags();
            List<BreedTagListRes> breedTagList = breedTags.stream()
                    .map(BreedTagListRes::new)
                    .collect(Collectors.toList());
            return new BaseResponse<>(breedTagList);
        } catch(BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "견종 상세 조회", description = "견종 번호를 주면 그 견종에 대한 정보를 불러옵니다.")
    @GetMapping("/{breedTagId}")
    public BaseResponse<BreedTagRes> getBreedTagOne(@PathVariable Long breedTagId){
        try {
            return new BaseResponse<>(breedTagService.getBreedTagOne(breedTagId));
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }
}
