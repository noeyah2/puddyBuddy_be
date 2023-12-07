package com.example.puddyBuddy.dto.petsize;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "펫 사이즈 정보 응답")
public class PetInfoRes {
    @Schema(description = "목 둘레", example = "30.0")
    private Float neck;

    @Schema(description = "가슴 둘레", example = "50.0")
    private Float chest;

    @Schema(description = "등 길이", example = "40.0")
    private Float back;

    @Schema(description = "다리 길이", example = "20.0")
    private Float leg;
}
