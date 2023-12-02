package com.example.puddyBuddy.dto.prefer;

import com.example.puddyBuddy.domain.Prefer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "선호조건 조회 response")
public class PreferNumRes {
    public PreferNumRes (Prefer prefer){
        this.userId = prefer.getUser().getUserId();
        this.breedTagId = prefer.getBreedTag().getBreedTagId();
        this.personalColorId = prefer.getPersonalColor().getPersonalColorId();
        this.name = prefer.getName();
//        this.petsizeId = prefer.getPetsize().getPetsizeId();
    }
    @Schema(description = "사용자 번호", example = "1")
    private long userId;

    @Schema(description = "견종 번호", example = "1")
    private long breedTagId;

    @Schema(description = "퍼스널 컬러 번호", example = "1")
    private long personalColorId;

    @Schema(description = "사용자 이름", example = "지수")
    private String name;
}
