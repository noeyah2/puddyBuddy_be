package com.example.puddyBuddy.dto.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "댓글 등록 DTO request ")
public class CommentCreateReq {
    @Schema(description = "게시판 번호", example = "1")
    private Long boardId;

    @Schema(description = "댓글 작성자의 회원 번호", example = "1")
    private Long userId;

    @Schema(description = "댓글 내용", example = "와라락")
    private String content;
}
