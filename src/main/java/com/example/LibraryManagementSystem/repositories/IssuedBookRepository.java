package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.model.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;

public interface IssuedBookRepository extends JpaRepository<IssuedBook,Integer> {

    @Query(value=  "select fine from issued_book where user_id= :uId and book_id= :bId",nativeQuery = true)
    public int fineForUser(int uId, int bId);
}
