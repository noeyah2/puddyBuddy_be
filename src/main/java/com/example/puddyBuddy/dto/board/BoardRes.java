package com.example.puddyBuddy.dto.board;

import com.example.puddyBuddy.domain.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Schema(title = "게시글 상세 조회 DTO response")
public class BoardRes {
    public BoardRes (Board board) {
        this.userId = board.getUser().getUserId();
        this.boardId = board.getBoardId();
        this.preferId = board.getPrefer().getPreferId();
        this.clothesId = board.getClothes().getClothesId();
        this.content = board.getContent();
        this.create_date = board.getCreateDate().format((DateTimeFormatter.ofPattern("YYYY-MM-dd")));
        this.photoUrl = board.getPhotoUrl();
    }
    @Schema(description = "게시글 번호", example = "1")
    private Long boardId;

    @Schema(description = "사용자 번호", example = "1")
    private Long userId;

    @Schema(description = "선호 번호", example = "1")
    private Long preferId;

    @Schema(description = "옷 번호", example = "1")
    private Long clothesId;

    @Schema(description = "내용", example = "와라락")
    private String content;

    @Schema(description = "생성일", example = "2023-10-09")
    private String create_date;

    @Schema(description = "사진 경로", example = "http://faierqnpotvjroe")
    private String photoUrl;
}
