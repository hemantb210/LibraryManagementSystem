package com.example.LibraryManagementSystem.controllers;


import com.example.LibraryManagementSystem.dto.BookDTO;
import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    public class BookController {

        @Autowired
    BookService bookService;
        @GetMapping("/findBookById")
        public Book findById(@RequestParam(value ="id") int id){
            return bookService.findById(id);
        }

        @GetMapping("/allBooks")
        public List<Book> findAll(){
            return bookService.findAll();
        }
        @PostMapping("/insertABook")
    public void insertABook(@RequestBody BookDTO bookDTO) {
            bookService.insertABook(bookDTO);

    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id){
            bookService.deleteABookById(id);
    }
    @PutMapping("/updateABook")
    public void updateABook(@RequestBody Book book){
            bookService.updateABook(book);
    }
    @PutMapping("/updateNoOfBooks/{id}/{num}")
    public void updateNoOfBooks(@PathVariable int id, @PathVariable int num){
            bookService.updateNumberOfBooks(id,num);
    }

}






    

