package com.bank.springAngular.controller;

import com.bank.springAngular.model.Customer;
import com.bank.springAngular.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerRepository {
 @Autowired
 private CustomerService customerService;


 @PostMapping("/add")
 public Customer addCustomer(@RequestBody Customer customer){
  return customerService.saveCustomer(customer);
 }
 @GetMapping("/show")
 public List<Customer> getAllCustomer(){
  return customerService.getAllCustomer();
 }

}
