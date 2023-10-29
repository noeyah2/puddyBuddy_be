package com.example.puddyBuddy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "게시글 등록")
public class BoardInsertReq {
    @Sch

}



import io.swagger.v3.oas.annotations.media.Schema;
        import lombok.Getter;
        import lombok.Setter;

@Setter
@Getter
@Schema(title = "숫자 교체 요청")
public class ChangeNumReq {
    @Schema(description = "시험지 id", example = "1")
    private Long testPaperId;

    @Schema(description = "문제 번호", example = "1")
    private Long probNum;
}