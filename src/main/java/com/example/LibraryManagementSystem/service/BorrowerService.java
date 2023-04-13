package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dto.BorrowerDTO;
import com.example.LibraryManagementSystem.exception.BorrowerNotFoundException;
import com.example.LibraryManagementSystem.exception.WrongEmailAddressException;
import com.example.LibraryManagementSystem.model.Borrower;
import com.example.LibraryManagementSystem.model.IssuedBook;
import com.example.LibraryManagementSystem.repositories.BorrowerRepository;
import com.example.LibraryManagementSystem.util.BorrowerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;
    public Borrower findById(int id){
        return borrowerRepository.findById(id).orElseThrow(()-> new BorrowerNotFoundException(id));
    }
    public List<Borrower> findAll(){
        return borrowerRepository.findAll();
    }
    public void insertABorrower(BorrowerDTO borrowerDTO){
        Borrower borrower = new Borrower(borrowerDTO.getIssuedBookSet(), borrowerDTO.getName(), borrowerDTO.getEmail());
        if(BorrowerValidator.isUserEmailValid(borrower.getEmail()) ){
            borrowerRepository.save(borrower);}
        else {throw new WrongEmailAddressException();
        }

    }
    public void deleteABorrowerById(int id){
        borrowerRepository.deleteById(id);
    }
    public void updateABorrower(Borrower borrower){
       Borrower u = borrowerRepository.findById(borrower.getId()).get();
       if(u==null){
           throw new BorrowerNotFoundException(borrower.getId());
       }
       u.setName(borrower.getName());
        u.setEmail(borrower.getEmail());
        borrowerRepository.save(u);
    }

    public Set<IssuedBook> issuedBooksByBorrower(int userId){

        Borrower u = borrowerRepository.findById(userId).get();
        return u.getIssuedBookSet();
    }
}
