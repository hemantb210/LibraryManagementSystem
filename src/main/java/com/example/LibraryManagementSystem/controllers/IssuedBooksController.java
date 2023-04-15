package com.example.LibraryManagementSystem.controllers;


import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.model.IssuedBook;
import com.example.LibraryManagementSystem.service.IssuedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class IssuedBooksController  {
    @Autowired
    IssuedBookService issuedBookService;
    @GetMapping("/allIssuedBooks")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
    public List<IssuedBook> allIssuedBooks(){
        return issuedBookService.allIssuedBooks();
    }
    @PostMapping("/issueBook/{uId}/{bId}")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
    public void issueABook(@PathVariable int uId, @PathVariable int bId){
        issuedBookService.issueBook(uId, bId);
    }
    @PostMapping("/returnBook/{uId}/{bId}")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
    public void returnABook(@PathVariable int uId, @PathVariable int bId){
        issuedBookService.returnBook(uId,bId);
    }
    @GetMapping("/fineForBorrower/{uId}/{bId}")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
    public int fineForBorrower(@PathVariable int uId, @PathVariable int bId){
        return issuedBookService.fineForBorrower(uId, bId);
    }


}
