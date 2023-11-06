package com.example.puddyBuddy.dto.breedtag;

import com.example.puddyBuddy.domain.BreedTag;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "견종 전체 목록 조회 response")
public class BreedTagListRes {
    public BreedTagListRes (BreedTag breedTag) {
        this.breedTagId = breedTag.getBreedTagId();
        this.breedTagName = breedTag.getBreedTagName();
    }
    @Schema(description = "견종 번호", example = "1")
    private Long breedTagId;

    @Schema(description = "견종 이름", example = "푸들")
    private String breedTagName;

}
