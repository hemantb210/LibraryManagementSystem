package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.exception.UserNotFoundException;
import com.example.LibraryManagementSystem.exception.WrongEmailAddressException;
import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.model.User;
import com.example.LibraryManagementSystem.repositories.BookRepository;
import com.example.LibraryManagementSystem.repositories.UserRepository;
import com.example.LibraryManagementSystem.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findById(int id){
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public void insertAUser(User user){
        if(UserValidator.isUserEmailValid(user.getEmail()) ){userRepository.save(user);}
        else {throw new WrongEmailAddressException();
        }

    }
    public void deleteAUserById(int id){
        userRepository.deleteById(id);
    }
    public void updateAUser(User user){
        UserService userService = new UserService();
       User u = userService.findById(user.getId());
       if(u==null){
           throw new UserNotFoundException(user.getId());
       }
       u.setName(user.getName());
        u.setEmail(user.getEmail());
    }
}
