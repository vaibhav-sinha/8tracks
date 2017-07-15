package com.github.vaibhavsinha.eighttracks.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by vaibhav on 15/07/17.
 */
@Data
@AllArgsConstructor
public class ApiErrorResponse {

    private String message;
    private Integer code;

    public static class ApiErrorResponseCode {
        public static final Integer MISSING_REQUIRED_PROPERTY = 1;
        public static final Integer INVALID_DATA = 2;
        public static final Integer NOT_FOUND = 3;
    }
}
