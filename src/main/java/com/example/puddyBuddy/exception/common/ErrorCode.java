package com.example.puddyBuddy.exception.common;

import lombok.Getter;

@Getter
public enum ErrorCode {

    /*성공 1000*/
    SUCCESS(true, 1000, "요청에 성공하였습니다."),

    /*공통 2000*/
    INVALID_INPUT(false, 2000, "잘못된 입력값입니다."),
    METHOD_NOT_ALLOWED(false, 2001, "잘못된 호출입니다."),
    HANDLE_ACCESS_DENIED(false, 2002, "접근할 수 없습니다."),
    INTERNAL_SERVER_ERROR(false, 2003, "문제가 발생했습니다."),
    FAILED_TO_SEND_EMAIL(false, 2004, "이메일 발송에 실패했습니다"),
    EMPTY_DATA(false, 2005, "비어 있는 값을 입력했습니다."),
    FAILED_TO_CREATE_PDF(false, 2006, "PDF 생성에 실패했습니다."),

    /*유저 3000*/
    ACCOUNT_NOT_FOUND(false, 3001, "사용자를 찾을 수 없습니다."),
    DUPLICATE_ACCOUNT(false, 3002, "이미 사용중인 이메일입니다."),
    EMAIL_SENDING_ERROR(false, 3003, "이메일 전송에 실패하였습니다."),
    POST_ACCOUNTS_EMPTY_EMAIL(false, 3004, "이메일을 입력해주세요."),
    POST_ACCOUNTS_EMPTY_NAME(false, 3005, "이름을 입력해주세요."),
    POST_ACCOUNTS_INVALID_EMAIL(false, 3006, "이메일 형식이 잘못되었습니다."),
    FAILED_TO_LOGIN(false, 3007, "비밀번호가 틀렸습니다."),

    /*서버, DB 4000*/
    DATABASE_ERROR(false, 4000, "DB에 문제가 발생했습니다."),
    NO_EXIST_USER(false, 4001, "없는 유저입니다."),
    NO_EXIST_PREFERCODE(false, 4002, "없는 선호조건입니다."),
    NO_EXIST_CLOTHESCODE(false, 4003, "없는 옷 코드입니다."),
    NO_EXIST_BOARD(false, 4004, "해당 게시물이 존재하지 않습니다."),
    NO_EXIST_COMMENT(false, 4005, "해당 댓글이 존재하지 않습니다."),
    NO_EXIST_PERSONALCOLORCODE(false, 4006, "해당 퍼스널코드가 존재하지 않습니다."),
    NO_EXIST_BREEDTAGID(false, 4007, "해당 견종 코드가 존재하지 않습니다."),
    NO_EXIST_PETSIZECODE(false, 4008, "해당 사이즈 정보가 존재하지 않습니다."),
    TIMEOUT_EXCEPTION(false, 4010, "문제를 생성하는데 시간이 오래 소요됩니다"),
    DUPLICATE_EMAIL(false, 4011, "중복된 이메일은 사용할 수 없습니다."),
    DUPLICATE_NICKNAME(false,4012,"중복된 닉네임은 사용할 수 없습니다.");


    /*상품 관련 5000*/

    public static ErrorCode CSV_PROCESSING_ERROR;
    private final boolean isSuccess;
    private final int code;
    private final String message;

    ErrorCode(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
