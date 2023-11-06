package com.ecommerce.ecommerceweb.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class ExceptionDTO {
    private HttpStatus errorCode;
    private String Message;

    public  ExceptionDTO(HttpStatus errorCode,String Message){
        this.errorCode=errorCode;
        this.Message=Message;
    }
}
