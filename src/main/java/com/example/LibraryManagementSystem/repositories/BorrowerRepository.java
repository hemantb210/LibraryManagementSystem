package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower,Integer> {

}
