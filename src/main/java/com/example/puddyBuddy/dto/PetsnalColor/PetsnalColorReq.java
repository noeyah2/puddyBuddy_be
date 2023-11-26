package com.example.puddyBuddy.dto.PetsnalColor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(title = "펫스널 컬러 스테이지 request")
public class PetsnalColorReq {
    @Schema(description = "선호 조건 번호", example = "1")
    private Long preferId;

    @Schema(description = "결과 값 리스트", example = "[1, 0, 1, 2]")
    private List<Integer> resultList;
}
