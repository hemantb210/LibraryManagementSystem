package com.example.LibraryManagementSystem.dto;

import com.example.LibraryManagementSystem.model.IssuedBook;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

public class UserDTO {

    private Set<IssuedBook> issuedBookSet;
    private String name;
    private String email;

    public Set<IssuedBook> getIssuedBookSet() {
        return issuedBookSet;
    }

    public void setIssuedBookSet(Set<IssuedBook> issuedBookSet) {
        this.issuedBookSet = issuedBookSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
