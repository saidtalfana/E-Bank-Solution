package com.bank.springAngular.controller;

import com.bank.springAngular.model.Account;
import com.bank.springAngular.model.Customer;
import com.bank.springAngular.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/save_account/{customer_id}")
    public Account saveAccount(@PathVariable int customer_id,@RequestBody Account account){
        return accountService.saveAccount(account, customer_id);
    }
@GetMapping("/all_account/{customer_id}")
    public List<Account> getAllAccount(int customer_id){
        return accountService.getAllAccounts(customer_id);
}

@GetMapping("/find_account/{id}")
    public Account find(@PathVariable("id") int id){
        return accountService.getAccountById(id);
}

@PutMapping("/update_account/{accountID}/{raison}")
    public void updateAccount(@PathVariable String raison,@PathVariable int accountID) {
    accountService.updateClose(accountID, raison);
}

}
