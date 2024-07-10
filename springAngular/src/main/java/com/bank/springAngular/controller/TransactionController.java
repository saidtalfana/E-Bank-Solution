package com.bank.springAngular.controller;

import com.bank.springAngular.model.Account;
import com.bank.springAngular.model.Transaction;
import com.bank.springAngular.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
//@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save_transaction/{id}")
    public Transaction saveAllTransactions(@RequestBody Transaction transaction,@PathVariable int id){
        return transactionService.saveTransaction(transaction,id);
    }

    @GetMapping("/all_transaction/{id}")
    public List<Transaction> allTransaction(@PathVariable int id){
        return transactionService.getTransactionsByAccountId(id);
    }
//    @GetMapping("/date/{date}")
//    public List<Transaction> searchDate(@PathVariable LocalDate date){
//        return transactionService.allTransactionsByDate(date);
//
//    }
}
