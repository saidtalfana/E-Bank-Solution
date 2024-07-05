package com.bank.springAngular.repository;

import com.bank.springAngular.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "select * from account where customer_id=?",nativeQuery = true)
    List<Account> findByCustomerId(int customerId);
}
