package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.model.User;
import com.example.LibraryManagementSystem.repositories.BookRepository;
import com.example.LibraryManagementSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findById(int id){
        return userRepository.findById(id).get();
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public void insertAUser(User user){
        userRepository.save(user);
    }
    public void deleteAUserById(int id){
        userRepository.deleteById(id);
    }
    public void updateAUser(User user){
        UserService userService = new UserService();
       User u = userService.findById(user.getId());
       u.setName(user.getName());
        u.setEmail(user.getEmail());
    }
}
