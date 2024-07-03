package com.bank.springAngular.repository;

import com.bank.springAngular.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepository extends JpaRepository<Customer,Integer> {
}
