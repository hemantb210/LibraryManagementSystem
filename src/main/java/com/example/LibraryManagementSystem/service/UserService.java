package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.exception.UserNotFoundException;
import com.example.LibraryManagementSystem.exception.WrongEmailAddressException;
import com.example.LibraryManagementSystem.model.IssuedBook;
import com.example.LibraryManagementSystem.model.User;
import com.example.LibraryManagementSystem.repositories.UserRepository;
import com.example.LibraryManagementSystem.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
       User u = userRepository.findById(user.getId()).get();
       if(u==null){
           throw new UserNotFoundException(user.getId());
       }
       u.setName(user.getName());
        u.setEmail(user.getEmail());
    }

    public Set<IssuedBook> issuedBooksByUser(int userId){

        User u = userRepository.findById(userId).get();
        return u.getIssuedBookSet();
    }
}
