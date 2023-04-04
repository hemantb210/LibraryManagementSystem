package com.example.LibraryManagementSystem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class IssuedBook{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IssuedBookNumber;
    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Book book;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private double fine;

    private Date dateOfIssue ;
    private Date dateOfReturn;

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public void setUserId(int userId) {
        this.user = new User();
        user.setId(userId);
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public IssuedBook(int id,  int userId, String name ,Date dateOfIssue) {
        this.book = new Book();
        book.setId(id);
        this.name=name;
        this.user = new User();
        this.user.setId(userId);
        this.dateOfIssue = dateOfIssue;
    }



    public IssuedBook() {
    }
}
