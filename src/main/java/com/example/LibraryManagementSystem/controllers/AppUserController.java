package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.dto.AppUserDTO;
import com.example.LibraryManagementSystem.model.AppUser;
import com.example.LibraryManagementSystem.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {
    @Autowired
    AppUserRepository appUserRepository;
    @PostMapping("/admin/addAppUser")
    public void addAppUser(@RequestBody AppUserDTO appUserDTO){
        System.out.println(appUserDTO.isEnabled());
        AppUser user = new AppUser(appUserDTO.getUsername(), appUserDTO.getPassword(), appUserDTO.isEnabled(), appUserDTO.getAuthorities());
        appUserRepository.save(user);


    }

}
