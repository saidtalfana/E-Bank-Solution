package com.bank.springAngular.repository;

import com.bank.springAngular.model.Account;
import com.bank.springAngular.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    @Query(value = "select * from transaction where accountid=?",nativeQuery = true)
    List<Transaction> findByAccountId(int accountID);
}
