package com.example.LibraryManagementSystem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class IssuedBook{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IssuedBookNumber;
    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;
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

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public IssuedBook() {
    }
    public IssuedBook(int id,  int borrowerId,Date dateOfIssue) {
        this.book = new Book();
        book.setBookId(id);
        this.borrower = new Borrower();
        this.borrower.setId(borrowerId);
        this.dateOfIssue = dateOfIssue;
    }




}
