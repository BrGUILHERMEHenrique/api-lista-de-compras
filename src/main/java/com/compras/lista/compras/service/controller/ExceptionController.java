package com.compras.lista.compras.service.controller;

import com.compras.lista.compras.infrastructure.exceptions.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException exception){
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "valores nao encontrados na base de dados");
        return ResponseEntity.badRequest().headers(headers).body(exception.getMessage());
    }
}
