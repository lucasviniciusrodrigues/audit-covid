package com.fiap.person.covid.data.adapter.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class PersonExceptionHandler {

    @ExceptionHandler(value = ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<Object> badRequestProductNotDeclare(ChangeSetPersister.NotFoundException e){
        return new ResponseEntity<Object>("Data not found", HttpStatus.NOT_FOUND);
    }



}