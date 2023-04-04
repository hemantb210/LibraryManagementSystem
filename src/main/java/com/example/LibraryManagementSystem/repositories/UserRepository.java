package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
