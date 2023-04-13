package com.example.LibraryManagementSystem.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    boolean isEnabled;
    String authorities;

    public AppUser() {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authoritiesList = new ArrayList<>();
        String [] authArray = this.authorities.split(":");
        for (int i =0; i<authArray.length;i++){
            GrantedAuthority obj = new SimpleGrantedAuthority(authArray[i]);
            authoritiesList.add(obj);
        }
        return authoritiesList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public AppUser( String username, String password, boolean isEnabled, String authorities) {
        this.username = username;
        this.password = password;
        this.isEnabled = isEnabled;
        this.authorities = authorities;
    }
}
