package com.example.puddyBuddy.dto.petsize;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(title = "펫사이즈 측정 스테이지 request")
public class PetsizeReq {
    @Schema(description = "선호 조건 번호", example = "1")
    private Long preferId;

    @Schema(description = "진단용 사진 url", example = "sample.jpg")
    private String photoUrl;
}
