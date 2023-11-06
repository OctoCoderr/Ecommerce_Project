package com.ecommerce.ecommerceweb.exception;

import com.ecommerce.ecommerceweb.DTO.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ControllerDevice {
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDTO> handleException(NotFoundException notFoundException){

        return  new ResponseEntity(new ExceptionDTO(HttpStatus.NOT_FOUND,"not found"),HttpStatus.NOT_FOUND);
    }


}
