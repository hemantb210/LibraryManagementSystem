package com.example.LibraryManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity

public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<IssuedBook> issuedBookSet;
    @NotEmpty(message = "Borrower Name cannot be empty")
    private String name;
    @NotEmpty(message = "Borrower Email cannot be empty")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<IssuedBook> getIssuedBookSet() {
        return issuedBookSet;
    }

    public void setIssuedBookSet(Set<IssuedBook> issuedBookSet) {
        this.issuedBookSet = issuedBookSet;
    }

    public Borrower() {
    }

    public Borrower(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public Borrower(Set<IssuedBook> books, String name, String email) {
        this.issuedBookSet = books;
        this.name = name;
        this.email = email;
    }
}
