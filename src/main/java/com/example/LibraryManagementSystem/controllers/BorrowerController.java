package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.dto.BorrowerDTO;
import com.example.LibraryManagementSystem.model.Borrower;
import com.example.LibraryManagementSystem.model.IssuedBook;
import com.example.LibraryManagementSystem.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class BorrowerController {
    @Autowired
    BorrowerService borrowerService;
    @GetMapping("/findBurrowerById")
    public Borrower findById(@RequestParam(value ="id") int id){
        return borrowerService.findById(id);
    }

    @GetMapping("/issuedBooksByBorrower/{burrowerId}")
    public Set<IssuedBook> issuedBooksByBurrower(@PathVariable int burrowerId){
        return borrowerService.issuedBooksByBorrower(burrowerId);

    }


    @GetMapping("/allBorrowers")
    public List<Borrower> findAll(){
        return borrowerService.findAll();
    }
    @PostMapping("/admin/insertABorrower")
    public void insertABorrower(@RequestBody BorrowerDTO borrowerDTO) {
        borrowerService.insertABorrower(borrowerDTO);

    }
    @DeleteMapping("/admin/deleteBorrowerById/{id}")
    public void deleteBorrowerById(@PathVariable int id){
        borrowerService.deleteABorrowerById(id);
    }
    @PutMapping("/admin/updateABorrower")
    public void updateABorrower(@RequestBody Borrower borrower){
       borrowerService.updateABorrower(borrower);
    }



}
