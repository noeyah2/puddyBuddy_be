package com.example.puddyBuddy.dto.user;

import com.example.puddyBuddy.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "회원 등록 request")
public class UserCreateReq {
    @Schema(description = "회원 번호", example = "1")
    private Long userId;

    @Schema(description = "회원 이름", example = "puddy")
    private String nickname;

    @Schema(description = "회원 이메일", example = "puddy@gmail.com")
    private String email;
}
