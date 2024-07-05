package com.bank.springAngular.controller;

import com.bank.springAngular.model.Account;
import com.bank.springAngular.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/save_account")
    public Account saveAccount(@RequestBody Account account){
        return accountService.saveAccount(account);
    }
@GetMapping("/all_account")
    public List<Account> getAllAccount(){
        return accountService.getAllAccounts();
}

@GetMapping("/find_account/{id}")
    public Account find(@PathVariable("id") int id){
        return accountService.getAccountById(id);
}
@PutMapping("/update_account/{id}")
    public Account updateAccount(@RequestBody Account account,@PathVariable("id") int id){
        account.setAccountID(id);
        return accountService.update(account);
}
}
