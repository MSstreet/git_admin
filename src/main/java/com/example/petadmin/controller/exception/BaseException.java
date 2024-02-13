package com.example.petadmin.controller.exception;


import lombok.Getter;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class BaseException extends RuntimeException  {

    public BaseException(String message){
        super(message);
    }

    public abstract int getStatusCode();

    public final Map<String, String> validation = new HashMap<>();
    public void addValidation(String fieldName, String message) {
        validation.put(fieldName, message);
    }

}
