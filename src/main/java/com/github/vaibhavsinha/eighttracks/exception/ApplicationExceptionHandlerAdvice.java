package com.github.vaibhavsinha.eighttracks.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vaibhav on 15/07/17.
 */
@ControllerAdvice
public class ApplicationExceptionHandlerAdvice {

    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public ResponseEntity<ApiErrorResponse> handleException(ApplicationException e) {
        ApiErrorResponse response = new ApiErrorResponse(e.getCustomMessage(), e.getErrorCode());
        return new ResponseEntity<>(response, e.getHttpStatus());
    }
}
