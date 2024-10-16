package com.example.petadmin.controller.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    NOTICE_NOT_FOUND(HttpStatus.NOT_FOUND,"Notice not found"),
    PET_HOSPITAL_NOT_FOUND(HttpStatus.NOT_FOUND,"Pet hospital not found"),
    DUPLICATED_USER(HttpStatus.CONFLICT, "Duplicated user"),
    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Database error occurs"),
    USER_JOIN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "User join error"),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "Invalid password"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid token"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not founded"),
    ;

    private final HttpStatus status;
    private final String message;

}
