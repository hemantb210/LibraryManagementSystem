package com.example.LibraryManagementSystem.util;

import com.example.LibraryManagementSystem.model.User;

import java.util.regex.Pattern;

public class UserValidator {
    public static boolean isUserEmailValid(String userEmailAddress) {
       String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return Pattern.compile(regexPattern)
                .matcher(userEmailAddress)
                .matches();
    }



}
