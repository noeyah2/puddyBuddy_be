package com.example.puddyBuddy.dto.petsize;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "펫사이즈 생성 request")
public class PetsizeCreateReq {
    @Schema(description = "선호 조건 번호", example = "1")
    private Long preferId;

    @Schema(description = "목 둘레", example = "20.1")
    private Float neck;

    @Schema(description = "가슴 둘레", example = "25.1")
    private Float chest;

    @Schema(description = "등 길이", example = "30.1")
    private Float back;

    @Schema(description = "다리 길이", example = "21.1")
    private Float leg;
}
