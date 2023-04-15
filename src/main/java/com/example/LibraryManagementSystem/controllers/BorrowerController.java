package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.dto.BorrowerDTO;
import com.example.LibraryManagementSystem.model.Borrower;
import com.example.LibraryManagementSystem.model.IssuedBook;
import com.example.LibraryManagementSystem.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class BorrowerController {
    @Autowired
    BorrowerService borrowerService;
    @GetMapping("/findBurrowerById")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
    public Borrower findById(@RequestParam(value ="id") int id){
        return borrowerService.findById(id);
    }

    @GetMapping("/issuedBooksByBorrower/{burrowerId}")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
    public Set<IssuedBook> issuedBooksByBurrower(@PathVariable int burrowerId){
        return borrowerService.issuedBooksByBorrower(burrowerId);

    }
    @GetMapping("/allBorrowers")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
    public List<Borrower> findAll(){
        return borrowerService.findAll();
    }

    @PostMapping("/admin/insertABorrower")
    @PreAuthorize("hasAuthority('admin')")
    public void insertABorrower(@RequestBody BorrowerDTO borrowerDTO) {
        borrowerService.insertABorrower(borrowerDTO);

    }
    @DeleteMapping("/admin/deleteBorrowerById/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public void deleteBorrowerById(@PathVariable int id){
        borrowerService.deleteABorrowerById(id);
    }
    @PutMapping("/admin/updateABorrower")
    @PreAuthorize("hasAuthority('admin')")
    public void updateABorrower(@RequestBody Borrower borrower){
       borrowerService.updateABorrower(borrower);
    }



}
