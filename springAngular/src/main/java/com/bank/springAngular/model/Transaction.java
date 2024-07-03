package com.bank.springAngular.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer transactionID;
    private Date transactionDate;
    private Time time;
    private Double amount;
    private TransactionType tansactionType;
    private Type type;


}
