package com.example.puddyBuddy.dto.petsize;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "펫 사이즈 측정 response")
public class PetsizeCreateRes {
    @Schema(description = "펫 사이즈 번호", example = "1")
    private Long petsizeId;
}
