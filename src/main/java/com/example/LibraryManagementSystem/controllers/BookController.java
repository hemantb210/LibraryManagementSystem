package com.example.LibraryManagementSystem.controllers;


import com.example.LibraryManagementSystem.dto.BookDTO;
import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    public class BookController {

        @Autowired
    BookService bookService;
        @GetMapping("/findBookById")
        @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
        public Book findById(@RequestParam(value ="id") int id){
            return bookService.findById(id);
        }

        @GetMapping("/allBooks")
        @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
        public List<Book> findAll(){
            return bookService.findAll();
        }
        @PostMapping("/insertABook")
        @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
    public void insertABook(@RequestBody BookDTO bookDTO) {
            bookService.insertABook(bookDTO);

    }
    @DeleteMapping("/deleteBookById/{id}")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
    public void deleteById(@PathVariable int id){
            bookService.deleteABookById(id);
    }
    @PutMapping("/updateABook")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
    public void updateABook(@RequestBody Book book){
            bookService.updateABook(book);
    }
    @PutMapping("/updateNoOfBooks/{id}/{num}")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
    public void updateNoOfBooks(@PathVariable int id, @PathVariable int num){
            bookService.updateNumberOfBooks(id,num);
    }

}






    

