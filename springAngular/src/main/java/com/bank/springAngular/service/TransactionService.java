package com.bank.springAngular.service;

import com.bank.springAngular.model.Transaction;
import com.bank.springAngular.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    public Transaction save(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public List<Transaction> allTransactions(){
        return transactionRepository.findAll();
    }
}
