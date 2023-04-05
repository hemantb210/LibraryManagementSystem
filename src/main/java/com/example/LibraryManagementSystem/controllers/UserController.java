package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.dto.UserDTO;
import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.model.IssuedBook;
import com.example.LibraryManagementSystem.model.User;
import com.example.LibraryManagementSystem.service.BookService;
import com.example.LibraryManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/findUserById")
    public User findById(@RequestParam(value ="id") int id){
        return userService.findById(id);
    }

    @GetMapping("/issuedBooksByUser/{userId}")
    public Set<IssuedBook> issuedBooksByUser(@PathVariable int userId){
        return userService.issuedBooksByUser(userId);

    }


    @GetMapping("/allUsers")
    public List<User> findAll(){
        return userService.findAll();
    }
    @PostMapping("/insertAUser")
    public void insertAUser(@RequestBody UserDTO userDTO) {
        userService.insertAUser(userDTO);

    }
    @DeleteMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.deleteAUserById(id);
    }
    @PutMapping("/updateAUser")
    public void updateAUser(@RequestBody User user){
       userService.updateAUser(user);
    }



}
