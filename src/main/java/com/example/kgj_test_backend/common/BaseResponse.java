package com.example.kgj_test_backend.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private boolean isSuccess;
    private int code;
    private String message;
    private T result;

    public static <T> BaseResponse<T> success(T result) {
        return BaseResponse.<T>builder()
                .isSuccess(true)
                .code(20000)
                .result(result)
                .build();
    }
}
