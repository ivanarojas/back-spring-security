package com.irojascorsico.websecurity.ErrorHandler;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorInfo {
    private final HttpStatus httpStatus;
    private final String error;
    private final ZonedDateTime timestamp;
}
