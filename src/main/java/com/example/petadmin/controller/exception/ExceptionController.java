package com.example.petadmin.controller.exception;

import com.example.petadmin.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> errorHandler(BaseException e) {
        log.error("Error occurs {}", e.toString());
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(Response.error(e.getErrorCode().name()));
    }

}
