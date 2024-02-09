package com.tasks.taskapi.utils;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tasks.taskapi.exception.FailedUpdateException;

@ControllerAdvice
public class TaskExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<Object> handleException(
        RuntimeException exception, WebRequest request) {
            String bodyOfResponse = "i made a mistake sorry :(";
            return handleExceptionInternal(exception, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {EmptyResultDataAccessException.class})
    protected ResponseEntity<Object> handleEmptyResultException(
        EmptyResultDataAccessException exception, WebRequest webRequest) {
            String bodyOfResponse = "item not found within the database </3";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyOfResponse);
    }

    @ExceptionHandler(value ={FailedUpdateException.class})
    protected ResponseEntity<Object> handleFailedUpdateException(
        FailedUpdateException exception, WebRequest webRequest) {
            String bodyOfResponse = "updated failed, so sorry";
            return ResponseEntity.status(HttpStatus.OK).body(bodyOfResponse);
    }

}

