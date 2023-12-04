package com.example.puddyBuddy.dto.Fitting;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "피팅 request")
public class FittingReq {
    @Schema(description = "옷 번호", example = "1")
    private Long clothesId;

    @Schema(description = "피팅용 사진 url", example = "pp.jpg")
    private String imgUrl;
}
