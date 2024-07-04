package com.bank.springAngular.controller;

import com.bank.springAngular.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class AccountRepository {
    @Autowired
    private AccountService accountService;

}
