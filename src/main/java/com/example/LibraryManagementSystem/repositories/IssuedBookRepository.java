package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.model.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface IssuedBookRepository extends JpaRepository<IssuedBook,Integer> {

}
