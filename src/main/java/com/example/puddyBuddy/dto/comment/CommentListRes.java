package com.example.puddyBuddy.dto.comment;

import com.example.puddyBuddy.domain.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "댓글 전체 목록 조회 response")
public class CommentListRes {
    public CommentListRes (Comment comment) {
        this.boardId = comment.getBoard().getBoardId();
        this.commentId = comment.getCommentId();
        this.userId = comment.getUser().getUserId();
        this.content = comment.getContent();
    }
    @Schema(description = "댓글 번호", example = "1")
    private Long commentId;

    @Schema(description = "회원 번호", example = "1")
    private Long userId;

    @Schema(description = "게시판 번호", example = "1")
    private Long boardId;

    @Schema(description = "댓글 내용", example = "와라락")
    private String content;
}
