package com.example.puddyBuddy.dto.petsize;

import com.example.puddyBuddy.domain.BreedTag;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "펫사이즈 정보 request")
public class PetsizeInfoReq {
    @Schema(description = "품종", example = "푸들")
    private BreedTag breedTag;

    @Schema(description = "펫 사이즈 번호", example = "1")
    private long petsizeId;
}
