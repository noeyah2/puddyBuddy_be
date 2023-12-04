package com.example.puddyBuddy.dto.Fitting;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "피팅 response")
public class FittingRes {
    @Schema(description = "피팅 사진 url", example = "pp.jpg")
    private String imgUrl;
}
