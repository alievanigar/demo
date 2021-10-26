package com.example.moneymanager.dao;

import com.example.moneymanager.model.CategoryType;
import com.example.moneymanager.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionDAO {
    List<Transaction> getAllTransaction();

    void addTransaction(Transaction transaction);

     void removeTransactionById(Long id);

     Optional<Transaction> getTransactionById(Long id);

}
