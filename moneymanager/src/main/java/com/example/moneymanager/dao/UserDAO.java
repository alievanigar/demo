package com.example.moneymanager.dao;

import com.example.moneymanager.model.Transaction;
import com.example.moneymanager.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<User> getAllUser();

    void addTUser(User user);

    void removeUserById(int id);

    Optional<User> getUserById(int id);

    Optional<User> getUserByUsername(String userName);
}
