package com.example.puddyBuddy.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "회원 등록 response")
public class UserCreateRes {
    @Schema(description = "회원 번호", example = "1")
    private Long userId;
}
