package com.bank.springAngular.service;



import com.bank.springAngular.model.Customer;
import com.bank.springAngular.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Customer saveCustomer(Customer customer){
//        String hashedPassword = passwordEncoder.encode(customer.getPassword());
//        customer.setPassword(hashedPassword);
        return customerRepository.save(customer);}


public Customer getInformationCustomer(int id){
        return customerRepository.getById(id);
}
    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }



}
