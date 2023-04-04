package com.example.LibraryManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class IssuedBook{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IssuedBookNumber;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private double fine;

    private Date dateOfIssue ;
    private Date dateOfReturn;


    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
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
    public int getIssuedBookNumber() {
        return IssuedBookNumber;
    }

    public void setIssuedBookNumber(int issuedBookNumber) {
        IssuedBookNumber = issuedBookNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public IssuedBook() {
    }
    public IssuedBook(int id,  int userId,Date dateOfIssue) {
        this.book = new Book();
        book.setBookId(id);
        this.user = new User();
        this.user.setId(userId);
        this.dateOfIssue = dateOfIssue;
    }




}
