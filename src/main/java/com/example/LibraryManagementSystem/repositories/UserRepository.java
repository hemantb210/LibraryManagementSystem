package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.model.IssuedBook;
import com.example.LibraryManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User,Integer> {

}
