package com.example.backendmain.service;

import com.example.backendmain.dto.UserCreateDTO;
import com.example.backendmain.dto.UserUpdateDTO;
import com.example.backendmain.dto.UserViewDTO;
import com.example.backendmain.exception.NotFoundException;
import com.example.backendmain.model.User;
import com.example.backendmain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserViewDTO getUserById(Long id) {
        final User user =  userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS) //Support tranzaksiya olnanda ishelyir olmayanda tranzaksiyasz ishleyir
    public List<UserViewDTO> getUsers() {
        return  userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found user"));
       user.setFirstName(userUpdateDTO.getFirstName());
       user.setLastName(userUpdateDTO.getLastName());

       final User updateUser = userRepository.save(user);

       return  UserViewDTO.of(updateUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        final User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found user"));
        userRepository.deleteById(user.getId());
    }

    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDTO){
        final User user = userRepository.save(new User(userCreateDTO.getUserName(), userCreateDTO.getFirstName(), userCreateDTO.getLastName()));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> slice(Pageable pageable){
        return userRepository.findAll(pageable).stream().map(UserViewDTO::of).collect(Collectors.toList());
    }


}
