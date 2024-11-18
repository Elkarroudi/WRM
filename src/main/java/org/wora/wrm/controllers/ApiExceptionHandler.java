package org.wora.wrm.controllers;

import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.wora.wrm.utils.apiResponse.ErrorType;
import org.wora.wrm.utils.apiResponse.types.ErrorApi;
import org.wora.wrm.utils.exceptions.ResourceNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ErrorApi handleBadRequestException(BadRequestException ex, WebRequest request) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("type", ErrorType.BAD_REQUEST_ERROR);
        errors.put("error", ex.getMessage());

        return new ErrorApi(
                HttpStatus.BAD_REQUEST.value(),
                errors
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorApi handleValidationExceptions(final MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("type", ErrorType.DATA_INVALID);
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            final String fieldName = ((FieldError) error).getField();
            final String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ErrorApi(
                HttpStatus.BAD_REQUEST.value(),
                errors
        );
    }

    @ExceptionHandler(PersistenceException.class)
    public ErrorApi handlePersistenceException(PersistenceException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("type", ErrorType.PERSISTENCE_ERROR);
        errors.put("error", "A required field is missing or invalid: " + ex.getMessage());

        return new ErrorApi(
                HttpStatus.BAD_REQUEST.value(),
                errors
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorApi handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("type", "Constraint Violation Error");
        ex.getConstraintViolations().forEach(violation -> {
            String field = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(field, message);
        });

        return new ErrorApi(
                HttpStatus.BAD_REQUEST.value(),
                errors
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorApi handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("type", "Resource Not Found");
        errors.put("detail", ex.getMessage());

        return new ErrorApi(
                HttpStatus.NOT_FOUND.value(),
                errors
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorApi handleMissingRequestBody(HttpMessageNotReadableException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("type", "Http Message Not Readable Exception");
        errors.put("detail", ex.getMessage());

        return new ErrorApi(
                HttpStatus.BAD_REQUEST.value(),
                errors
        );
    }

}
