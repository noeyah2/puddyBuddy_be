package com.example.puddyBuddy.dto.board;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "게시글 등록 request")
public class BoardCreateReq {
    @Schema(description = "사용자 번호", example = "1")
    private Long userId;

    @Schema(description = "선호 번호", example = "1")
    private Long preferId;

    @Schema(description = "옷 번호", example = "1")
    private Long clothesId;

    @Schema(description = "내용", example = "와라락")
    private String content;

    @Schema(description = "사진 경로", example = "http://faierqnpotvjroe")
    private String photoUrl;
}