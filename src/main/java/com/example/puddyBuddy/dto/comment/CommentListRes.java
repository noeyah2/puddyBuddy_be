package com.example.puddyBuddy.dto.comment;

import com.example.puddyBuddy.domain.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(title = "댓글 전체 목록 조회 response")
public class CommentListRes {
    public CommentListRes (Comment comment) {
        this.commentId = comment.getCommentId();
        this.userId = comment.getUser().getUserId();
        this.boardId = comment.getBoard().getBoardId();
        this.content = comment.getContent();
        this.createDate = comment.getCreateDate();
    }
    @Schema(description = "댓글 번호", example = "1")
    private Long commentId;

    @Schema(description = "회원 번호", example = "1")
    private Long userId;

    @Schema(description = "게시글 번호", example = "1")
    private Long boardId;

    @Schema(description = "게시글 내용", example = "와랅")
    private String content;

    @Schema(description = "생성 일자", example = "2023-10-10")
    private LocalDateTime createDate;
}
