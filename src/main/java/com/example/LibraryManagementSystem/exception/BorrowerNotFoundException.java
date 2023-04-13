package com.example.LibraryManagementSystem.exception;

public class BorrowerNotFoundException extends RuntimeException{
    public BorrowerNotFoundException(int id) {
        super("Borrower with id " +id +"not found");
    }
}
