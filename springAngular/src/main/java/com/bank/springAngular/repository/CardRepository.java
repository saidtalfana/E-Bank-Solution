package com.bank.springAngular.repository;

import com.bank.springAngular.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

    @Query(value = "delete * from card where accountid=?",nativeQuery = true)
    void deleteByAccountId(int accountid);

}
