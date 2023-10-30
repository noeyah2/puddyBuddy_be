package com.example.puddyBuddy.dto.board;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "게시글 등록 reponse")
public class BoardCreateRes {
    @Schema(description = "게시판 번호", example = "1")
    private Long boardId;
}
