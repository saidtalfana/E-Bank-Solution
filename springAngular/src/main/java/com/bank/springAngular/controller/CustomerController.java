package com.bank.springAngular.controller;

import com.bank.springAngular.model.Customer;
import com.bank.springAngular.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
 @Autowired
 private CustomerService customerService;



 @PostMapping("/user")
 public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
  try {
   Customer savedCustomer = customerService.saveCustomer(customer);
   return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
  } catch (Exception e) {
   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du client : " + e.getMessage());
  }
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
