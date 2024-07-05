package com.bank.springAngular.repository;

import com.bank.springAngular.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

//    List<Transaction> allTransactionByDate(LocalDate date);
}
