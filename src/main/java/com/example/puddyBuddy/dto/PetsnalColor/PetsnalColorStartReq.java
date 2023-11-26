package com.example.puddyBuddy.dto.PetsnalColor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "펫스널 컬러 진단 request")
public class PetsnalColorStartReq {
    @Schema(description = "선호 조건 번호", example = "1")
    private Long preferId;

    @Schema(description = "진단용 사진 url", example = "sample.jpg")
    private String photoUrl;
}
