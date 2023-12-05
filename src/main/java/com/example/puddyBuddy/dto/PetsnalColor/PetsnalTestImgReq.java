package com.example.puddyBuddy.dto.PetsnalColor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(title = "펫스널 컬러 저장 request")
public class PetsnalTestImgReq {
    @Schema(description = "url 리스트", example = "[\"a.jpg\", \"b.jpg\"]")
    private List<String> imgUrls;
}
