package com.example.puddyBuddy.dto.prefer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "선호조건 등록 request")
public class PreferCreateReq {
    @Schema(description = "회원 번호", example = "1")
    private Long userId;

    @Schema(description = "선호조건 이름", example = "강아지 이름 > 하니")
    private String preferName;

    @Schema(description = "퍼스널 컬러 번호", example = "1")
    private long personalColorId;

    @Schema(description = "견종 번호", example = "1")
    private long breedTagId;
}
