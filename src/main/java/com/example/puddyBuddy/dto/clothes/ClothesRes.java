package com.example.puddyBuddy.dto.clothes;

import com.example.puddyBuddy.domain.Clothes;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "게시판 내 의류 정보 상세 조회")

public class ClothesRes {
    public ClothesRes (Clothes clothes) {
        this.clothesId = clothes.getClothesId();
        this.storeId = clothes.getStore().getStoreId();
        this.name = clothes.getName();
        this.content = clothes.getContent();
        this.color = clothes.getColor().getName();
        this.personalColor = clothes.getPersonalColor().getName();
        this.shoppingSiteUrl = clothes.getShoppingSiteUrl();
    }
    @Schema(description = "의류 번호", example = "1")
    private Long clothesId;

    @Schema(description = "상점 번호", example = "1")
    private Long storeId;

    @Schema(description = "의류 이름", example = "하늘하늘한 원피스")
    private String name;

    @Schema(description = "상점 웹페이지 url", example = "http://shopping.com")
    private String shoppingSiteUrl;

    @Schema(description = "의류 소개 내용", example = "옆으로 퍼지는 원피스가 아주 이쁩니다.")
    private String content;

    @Schema(description = "의류에 해당하는 퍼스널 컬러", example = "봄웜")
    private String personalColor;

    @Schema(description = "의류에 해당하는 색", example = "빨강")
    private String color;
}
