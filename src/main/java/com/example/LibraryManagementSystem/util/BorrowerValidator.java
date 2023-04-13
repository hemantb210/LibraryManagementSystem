package com.example.LibraryManagementSystem.util;

import java.util.regex.Pattern;

public class BorrowerValidator {
    public static boolean isUserEmailValid(String userEmailAddress) {
       String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return Pattern.compile(regexPattern)
                .matcher(userEmailAddress)
                .matches();
    }



}
