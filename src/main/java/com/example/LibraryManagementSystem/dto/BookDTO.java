package com.example.LibraryManagementSystem.dto;

import com.example.LibraryManagementSystem.model.IssuedBook;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class BookDTO {
    private Set<IssuedBook> books;
    private String name;
    private String authorName;
    private int cost;
    private int numberOfBooks;

    public Set<IssuedBook> getBooks() {
        return books;
    }

    public void setBooks(Set<IssuedBook> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
}
