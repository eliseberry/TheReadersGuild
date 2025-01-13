package com.aca.TheReadersGuild.Controller;

import com.aca.TheReadersGuild.modal.BookException;
import com.aca.TheReadersGuild.modal.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ExceptionHandlerController {

    @ExceptionHandler(BookException.class)
    public ResponseEntity<ExceptionResponse> handleBookException(
            BookException bookException, HttpServletRequest request){

            ExceptionResponse response = new ExceptionResponse();
            response.setMessage(bookException.getMessage());
            response.setRequestURI(response.getRequestURI());

            return ResponseEntity.badRequest().body(response);
    }
}
