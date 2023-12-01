package com.example.puddyBuddy.dto.petsize;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(title = "펫사이즈 측정 결과 result")
public class PetsizeRes {
    @Schema(description = "등 길이", example = "18.2")
    private float back;

    @Schema(description = "가슴 둘레", example = "12.1")
    private float chest;
}
