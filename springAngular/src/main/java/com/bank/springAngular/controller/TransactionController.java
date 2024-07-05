package com.bank.springAngular.controller;

import com.bank.springAngular.model.Transaction;
import com.bank.springAngular.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save_transaction")
    public Transaction saveAllTransactions(@RequestBody Transaction transaction){
        return transactionService.save(transaction);
    }

    @GetMapping("/all_transaction")
    public List<Transaction> allTransaction(){
        return transactionService.allTransactions();
    }
}
