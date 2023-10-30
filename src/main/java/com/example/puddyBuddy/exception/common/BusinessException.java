package com.example.puddyBuddy.exception.common;

import com.example.puddyBuddy.exception.common.ErrorCode;

public class BusinessException extends RuntimeException {
    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }


    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
