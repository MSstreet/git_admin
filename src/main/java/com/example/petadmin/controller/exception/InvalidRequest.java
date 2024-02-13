package com.example.petadmin.controller.exception;

import lombok.Getter;

@Getter
public class InvalidRequest extends BaseException{


    private static final String MESSAGE = "잘못된 요청입니다.";

    public InvalidRequest(){
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
