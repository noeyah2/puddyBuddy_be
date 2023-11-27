package com.example.puddyBuddy.dto.personalColor;

import com.example.puddyBuddy.domain.PersonalColor;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "퍼스널 컬러 목록 조회 response")
public class PersonalListRes {
    public PersonalListRes (PersonalColor personalColor) {
        this.personalColorId = personalColor.getPersonalColorId();
        this.name = personalColor.getName();
    }
    @Schema(description = "퍼스널컬러 번호", example = "1")
    private Long personalColorId;

    @Schema(description = "퍼스널컬러명", example = "겨울 쿨")
    private String name;
}
