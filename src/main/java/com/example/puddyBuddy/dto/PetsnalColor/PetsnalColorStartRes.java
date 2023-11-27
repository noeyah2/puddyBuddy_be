package com.example.puddyBuddy.dto.PetsnalColor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "펫스널 컬러 생성 response")
public class PetsnalColorStartRes {
    @Schema(description = "테스트 생성 결과", example = "true")
    private Boolean result;
}
