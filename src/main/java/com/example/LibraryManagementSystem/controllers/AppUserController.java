package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.dto.AppUserDTO;
import com.example.LibraryManagementSystem.dto.AuthenticationRequest;
import com.example.LibraryManagementSystem.dto.AuthenticationResponse;
import com.example.LibraryManagementSystem.model.AppUser;
import com.example.LibraryManagementSystem.repositories.AppUserRepository;
import com.example.LibraryManagementSystem.service.AppUserDetailsService;
import com.example.LibraryManagementSystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AppUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/admin/addAppUser")
    @PreAuthorize("hasAuthority('admin')")
    public void addAppUser(@RequestBody AppUserDTO appUserDTO){
        System.out.println(appUserDTO.isEnabled());
        AppUser user = new AppUser(appUserDTO.getUsername(), passwordEncoder.encode(appUserDTO.getPassword()), appUserDTO.isEnabled(), appUserDTO.getAuthorities());
        appUserRepository.save(user);


    }
    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return new AuthenticationResponse(jwt);
    }

}
