package com.bank.springAngular.service;


import com.bank.springAngular.enam.AccountType;
import com.bank.springAngular.model.Account;
import com.bank.springAngular.model.Customer;
import com.bank.springAngular.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;

import static com.bank.springAngular.enam.AccountType.saving;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        Account account = new Account();
        account.setAccountName("CIH");
        account.setAccountNumber(Math.min(16,24));
        account.setBalance(2600);
        account.setCreationDate(new Date(System.currentTimeMillis()));
        account.setAccountType(saving);
        if(customer.getAccount()==null){
            customer.setAccount(new HashSet<>());
        }
        customer.getAccount().add(account);
        account.setCustomer(customer);
        return customerRepository.save(customer);
    }
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public void deleteById(int id){
        customerRepository.deleteById(id);
    }

    public Customer getCustomerById(int id){
        return customerRepository.findById(id).get();
    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }



}
