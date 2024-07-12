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
        return customerRepository.save(customer);}
public Customer getInformationCustomer(int id){
        return customerRepository.getById(id);
}
    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }



}
