package com.example.LibraryManagementSystem.exception;

public class WrongEmailAddressException extends RuntimeException{
    public WrongEmailAddressException() {
        super("Wrong email address entered");
    }
}
