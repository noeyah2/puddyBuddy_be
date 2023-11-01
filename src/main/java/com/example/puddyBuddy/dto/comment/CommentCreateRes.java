package com.example.puddyBuddy.dto.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "댓글 등록 DTO response")
public class CommentCreateRes {
    @Schema(description = "댓글 번호", example = "1")
    private Long commentId;
}
