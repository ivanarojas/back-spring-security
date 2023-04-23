package com.irojascorsico.websecurity.ErrorHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorInfo> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.error(ex.getMessage(), ex);
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST, "Illegal Argument Exception.", ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorInfo> handleNullPointerException(NullPointerException ex) {
        logger.error(ex.getMessage(), ex);
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR, "Interna Error Exception", ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorInfo> handleDataIntegrityViolationException(DataIntegrityViolationException ex)
    {
        logger.error(ex.getMessage(), ex);
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST, "Data Integrity Violation Exception. Consider check the constrains and require values.", ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
        
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorInfo> handleBadCredentialsException(BadCredentialsException ex)
    {
        logger.error(ex.getMessage(), ex);
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.UNAUTHORIZED, "Bad credential Exception. Consider check the email and password.", ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(errorInfo, HttpStatus.UNAUTHORIZED);
    }
}
