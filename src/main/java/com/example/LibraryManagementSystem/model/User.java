package com.example.LibraryManagementSystem.model;

import javax.persistence.*;
import java.util.Set;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public User(int id, Set<IssuedBook> books, String name, String email) {
        this.id = id;
        this.books = books;
        this.name = name;
        this.email = email;
    }


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<IssuedBook> books;
    private String name;
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

    public User() {
    }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
