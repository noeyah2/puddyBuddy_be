package com.example.puddyBuddy.dto.prefer;

import com.example.puddyBuddy.domain.Prefer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "선호조건 전체 조회 response")
public class PreferRes {
    public PreferRes (Prefer prefer){
        this.preferId = prefer.getPreferId();
        this.userId = prefer.getUser().getUserId();
        this.breedTagId = prefer.getBreedTag().getBreedTagId();
        this.personalColorId = prefer.getPersonalColor().getPersonalColorId();
        this.name = prefer.getName();
        this.chest = prefer.getChest();
        this.back = prefer.getBack();
    }

    @Schema(description = "선호 번호", example = "1")
    private long preferId;

    @Schema(description = "사용자 번호", example = "1")
    private long userId;

    @Schema(description = "견종 번호", example = "1")
    private long breedTagId;

    @Schema(description = "퍼스널 컬러 번호", example = "1")
    private long personalColorId;

    @Schema(description = "사용자 이름", example = "지수")
    private String name;

    @Schema(description = "선호조건 가슴둘레", example = "20.0")
    private float chest;

    @Schema(description = "선호조건 등길이", example = "30.0")
    private float back;
}
