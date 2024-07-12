package com.bank.springAngular.service;

import com.bank.springAngular.model.Customer;
import com.bank.springAngular.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDatailsServiceImp implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findCustomerByUsername(username);
      return customer.build().username(customer.getUsername()).password(customer.getPassword()).build();
    }
}
