package com.example.puddyBuddy.dto.PetsnalColor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(title = "펫스널 컬러 스테이지 result")
public class PetsnalColorRes {
    @Schema(description = "다음 스테이지 (끝나면 0)", example = "1")
    private int nextStage;

    @Schema(description = "다음 스테이지용 사진 리스트", example = "['a.jpg', 'b.jpg']")
    private List<String> photoUrlList;

    @Schema(description = "결과 (1~4: 봄~겨울, 0: 테스트 중간)", example = "1")
    private int result;
}
