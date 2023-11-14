package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.domain.Store;
import com.example.puddyBuddy.dto.board.BoardListRes;
import com.example.puddyBuddy.dto.board.BoardRes;
import com.example.puddyBuddy.dto.shop.StoreListRes;
import com.example.puddyBuddy.dto.shop.StoreRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.puddyBuddy.service.StoreService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping( value = "/stores",  produces = "application/json;charset=utf8")
@Tag(name = "상점 API")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @Operation(summary = "상점 전체 목록")
    @GetMapping
    public BaseResponse<List<StoreListRes>> getStores() {
        try {
            List<Store> stores = storeService.getStores();
            List<StoreListRes> storeList = stores.stream()
                    .map(StoreListRes::new)
                    .collect(Collectors.toList());
            return new BaseResponse<>(storeList);
        } catch(BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "상점 상세 조회", description = "게시글 번호를 주면 그 게시글을 하나 불러옵니다.")
    @GetMapping("/{storeId}")
    public BaseResponse<StoreRes> getStore(@PathVariable Long storeId){
        try {
            return new BaseResponse<>(storeService.getStoreOne(storeId));
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }
}