package com.example.moneymanager.service;

import com.example.moneymanager.dao.TransactionDAO;
import com.example.moneymanager.model.Transaction;
import com.example.moneymanager.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService /* implements TransactionDAO*/ {
//
//    @Autowired
//    TransactionRepository transactionRepository;
//
//    @Override
//    public List<Transaction> getAllTransaction() {
//        return transactionRepository.findAll();
//    }
//
//    @Override
//    public void addTransaction(Transaction transaction) {
//        transactionRepository.save(transaction);
//    }
//
//    @Override
//    public void removeTransactionById(Long id) {
//        transactionRepository.deleteById(id);
//    }
//
//    @Override
//    public Optional<Transaction> getTransactionById(Long id) {
//        return transactionRepository.findById(id);
//    }
}
