package com.example.puddyBuddy.dto.petsize;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "펫 사이즈 정보 response")
public class PetsizeInfoRes {
    @Schema(description = "목 둘레 퍼센트", example = "0.27")
    private Float perNeck;

    @Schema(description = "가슴 둘레 퍼센트", example = "0.27")
    private Float perChest;

    @Schema(description = "등 길이 퍼센트", example = "0.27")
    private Float perBack;

    @Schema(description = "다리 길이 퍼센트", example = "0.27")
    private Float perLeg;
}
