package com.bank.springAngular.controller;

import com.bank.springAngular.model.Customer;
import com.bank.springAngular.service.CustomerService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(value = "/customer")
public class CustomerController {
 @Autowired
 private CustomerService customerService;


 @GetMapping("/word")
public String word(){
 return "hello enaa";
}

 @PostMapping("/add_customer")
 public Customer addCustomer(@RequestBody Customer customer){
  return customerService.saveCustomer(customer);
 }
 @GetMapping("/show_customer")
 public List<Customer> getAllCustomer(){
  return customerService.getAllCustomer();
 }
 @DeleteMapping("/delete_customer/{id}")
 public void deleteCustomer(@PathVariable("id") int id){
  customerService.deleteById(id);
 }
@GetMapping("/find_customer/{id}")
private Customer getCustomerById(@PathVariable("id") int id){
  return customerService.getCustomerById(id);
}
 @PutMapping("/update_customer/{id}")
 public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") int id){
     customer.setCustomerID(id);
  return customerService.updateCustomer(customer);

 }

}
