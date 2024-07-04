package com.bank.springAngular.service;


import com.bank.springAngular.model.Customer;
import com.bank.springAngular.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public void deleteById(int id){
        customerRepository.deleteById(id);
    }

    public Customer getCustomerById(int id){
        return customerRepository.findById(id)
    }

    public Customer updateCustomer( Customer customer){
        return customerRepository.save(customer);
    }



}
