package com.example.backendmain.service;

import com.example.backendmain.dto.UserCreateDTO;
import com.example.backendmain.dto.UserUpdateDTO;
import com.example.backendmain.dto.UserViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserViewDTO getUserById(Long id);
    UserViewDTO createUser(UserCreateDTO userCreateDTO);
    List<UserViewDTO> getUsers();
    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);
    void deleteUser(Long id);
    List<UserViewDTO> slice(Pageable pageable);
}
