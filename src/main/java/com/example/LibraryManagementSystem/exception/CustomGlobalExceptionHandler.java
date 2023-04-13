package com.example.LibraryManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(BorrowerNotFoundException.class)
    public void springHandleUserNotFound(HttpServletResponse response) throws IOException {  response.sendError(HttpStatus.NOT_FOUND.value());}
    @ExceptionHandler(BookNotFoundException.class)
    public void springHandleBookNotFound(HttpServletResponse response) throws IOException {  response.sendError(HttpStatus.NOT_FOUND.value());}

    @ExceptionHandler(WrongEmailAddressException.class)
    public void springHandleWrongEmailAddress(HttpServletResponse response) throws IOException {  response.sendError(HttpStatus.BAD_REQUEST.value());}

}
