package com.bank.springAngular.service;


import com.bank.springAngular.model.Account;
import com.bank.springAngular.model.Customer;
import com.bank.springAngular.repository.AccountRepository;
import com.bank.springAngular.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Account saveAccount(Account account, int customer_id) {
        Customer user = customerRepository.findById(customer_id).get();
        account.setCustomer(user);
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts(int customer_id) {
        return accountRepository.findByCustomerId(customer_id);
    }

    public Account getAccountById(int id) {
        return accountRepository.findById(id).get();
    }

    public Account updateClose(int accountID, String raison) {
        Account account = accountRepository.findById(accountID).orElse(null);
        if (account.getBalance() == 0) {
            account.setRaisonMssg(raison);
            account.setIsClosed(true);
            return accountRepository.save(account);
        }else{
            throw new RuntimeException("withdraw your account");
        }

    }

}