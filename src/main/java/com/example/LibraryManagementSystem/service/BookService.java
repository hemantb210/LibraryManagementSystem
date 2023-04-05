package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dto.BookDTO;
import com.example.LibraryManagementSystem.exception.BookNotFoundException;
import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public Book findById(int id){
        return bookRepository.findById(id).orElseThrow(() ->new BookNotFoundException(id));
    }
    public  List<Book> findAll(){
        return bookRepository.findAll();
    }
    public void insertABook(BookDTO bookDTO){
        Book book = new  Book(bookDTO.getName(), bookDTO.getAuthorName(), bookDTO.getCost(), bookDTO.getNumberOfBooks());
        bookRepository.save(book);
    }
    public void deleteABookById(int id){
        bookRepository.deleteById(id);
    }
    public void updateABook(Book book){
        Book b =bookRepository.findByName(book.getName());
        if(b==null){
            throw new BookNotFoundException(book.getBookId());
        }
//        b.setName(book.getName());
        b.setAuthorName(book.getAuthorName());
        b.setCost(book.getCost());
        b.setNumberOfBooks(book.getNumberOfBooks());
        bookRepository.save(b);
    }
    public void updateNumberOfBooks(int id, int num){
        Book b = bookRepository.findById(id).get();
        if(b==null){
            throw new BookNotFoundException(id);
        }
        b.setNumberOfBooks(b.getNumberOfBooks()+num);
        bookRepository.save(b);
    }
}
