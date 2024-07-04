package com.bank.springAngular.controller;

import com.bank.springAngular.model.Account;
import com.bank.springAngular.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/save_account")
    public Account saveAccount(@RequestBody Account account){
        return accountService.saveAccount(account);
    }

}
