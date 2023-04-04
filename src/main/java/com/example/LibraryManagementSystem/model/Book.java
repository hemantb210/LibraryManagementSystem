package com.example.LibraryManagementSystem.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<IssuedBook> books;
    private String name;

    public Book(String name, String authorName, int cost) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
    }

    private String authorName;
    private int cost;
    private int numberOfBooks;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", cost=" + cost +
                ", numberOfBooks=" + numberOfBooks +
                '}';
    }

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

    public Book() {
    }

    public Book( String name, String authorName, int cost, int numberOfBooks) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
        this.numberOfBooks = numberOfBooks;
    }

}
