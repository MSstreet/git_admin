package com.example.petadmin.controller.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException  {

    private ErrorCode errorCode;
    private String message;


    public BaseException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = null;
    }

    @Override
    public String getMessage() {
        if (message == null) {
            return errorCode.getMessage();
        } else {
            return String.format("%s. %s", errorCode.getMessage(), message);
        }

    }

}
