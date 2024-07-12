package com.bank.springAngular.controller;

import com.bank.springAngular.model.Customer;
import com.bank.springAngular.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
 @Autowired
 private CustomerService customerService;


 @PostMapping("/add_customer")
 public Customer addCustomer(@RequestBody Customer customer){
  return customerService.saveCustomer(customer);

 }

 @GetMapping("/show_information/{id}")
 public Customer getInfomationCustomer(int id){
  return customerService.getInformationCustomer(id);
 }


 @PutMapping("/update_customer/{id}")
 public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") int id){
     customer.setCustomerID(id);
  return customerService.updateCustomer(customer);

 }

}
