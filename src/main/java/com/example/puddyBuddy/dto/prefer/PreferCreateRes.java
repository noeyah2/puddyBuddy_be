package com.example.puddyBuddy.dto.prefer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "선호조건 등록 request")
public class PreferCreateRes {
    @Schema(description = "선호조건 번호", example = "1")
    private long preferId;
}
