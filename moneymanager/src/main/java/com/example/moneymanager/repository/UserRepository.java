package com.example.moneymanager.repository;

import com.example.moneymanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User>  findUserByUsername(String email);
}
