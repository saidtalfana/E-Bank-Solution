package com.bank.springAngular.repository;

import com.bank.springAngular.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

////    Customer findCustomerByUsername(String username);
//     Customer findByUsername(String username);

}
