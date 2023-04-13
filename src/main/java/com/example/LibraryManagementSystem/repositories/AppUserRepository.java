package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
public AppUser findByUsername(String username);

}
