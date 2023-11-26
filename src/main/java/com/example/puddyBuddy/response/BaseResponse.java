package com.example.puddyBuddy.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.example.puddyBuddy.exception.common.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

import static com.example.puddyBuddy.exception.common.ErrorCode.SUCCESS;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result", "totalElements"})
public class BaseResponse<T> {
    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String message;
    private final int code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long totalElements;

    // 요청 성공
    public BaseResponse(T result) {
        this.isSuccess = SUCCESS.isSuccess();
        this.message = SUCCESS.getMessage();
        this.code = SUCCESS.getCode();
        this.result = result;
    }

    // New constructor for success with totalElements parameter
    public BaseResponse(T result, long totalElements) {
        this.isSuccess = SUCCESS.isSuccess();
        this.message = SUCCESS.getMessage();
        this.code = SUCCESS.getCode();
        this.result = result;
        this.totalElements = totalElements;
    }

    // 요청 실패
    public BaseResponse(ErrorCode errorCode) {
        this.isSuccess = errorCode.isSuccess();
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }

    // Getters and setters for totalElements

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }
}