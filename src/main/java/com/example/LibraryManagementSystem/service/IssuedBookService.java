package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.exception.BookNotFoundException;
import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.model.IssuedBook;
import com.example.LibraryManagementSystem.repositories.IssuedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Service
public class IssuedBookService {
    @Autowired
    IssuedBookRepository issuedBookRepository;
    @Autowired
    BookService bookService;





    public List<IssuedBook> allIssuedBooks(){
        return issuedBookRepository.findAll();
    }
    public IssuedBook findById(int id ){return issuedBookRepository.findById(id).get(); }

    public void issueBook(int borrowerId, int bookId){
        long millis=System.currentTimeMillis();
        Book bb = bookService.findById(bookId);
        if(bb.getNumberOfBooks()>0){
        IssuedBook b =  new IssuedBook(bookId,borrowerId, new Date(millis));
        issuedBookRepository.save(b);
        bookService.updateNumberOfBooks(bookId,-1);}
        else {
            throw new BookNotFoundException("This book is no longer available");
        }



    }
    public void returnBook(int borrowerId, int bookId)  {
        long millis=System.currentTimeMillis();

        IssuedBook b = issuedBookRepository.findById(bookId).get();
        Date date = new Date(millis);
        b.setDateOfReturn(date);

//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//        Date firstDate = b.getDateOfIssue();
//        Date secondDate = null;
//        try {
//            secondDate = sdf.parse("04/24/2023");
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//
//        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
//        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        long diffInMillies = Math.abs(date.getTime() - b.getDateOfIssue().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        if(diff<=15)
        {b.setFine(0);}
        else{
            b.setFine((diff-15)*2);
        }
        issuedBookRepository.save(b);
        bookService.updateNumberOfBooks(bookId,1);


    }

    public int fineForBorrower( int uId,  int bId){
        return issuedBookRepository.fineForUser(uId, bId);


    }


}
