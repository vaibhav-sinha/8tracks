package com.github.vaibhavsinha.eighttracks.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created by vaibhav on 15/07/17.
 */
@Data
public class ApplicationException extends RuntimeException implements Serializable {

    private Integer errorCode;
    private String customMessage;
    private HttpStatus httpStatus;

    public ApplicationException(Integer errorCode, String customMessage, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.customMessage = customMessage;
        this.httpStatus = httpStatus;
    }
}
