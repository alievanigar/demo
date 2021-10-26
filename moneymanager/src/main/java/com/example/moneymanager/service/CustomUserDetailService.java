package com.example.moneymanager.service;

import com.example.moneymanager.dao.UserDAO;
import com.example.moneymanager.model.CustomUserDetail;
import com.example.moneymanager.model.User;
import com.example.moneymanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userDAO.getUserByUsername(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        return user.map(CustomUserDetail::new).get();
    }
}

