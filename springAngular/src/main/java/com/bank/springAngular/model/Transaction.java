package com.bank.springAngular.model;

import com.bank.springAngular.enam.StatuTransaction;
import com.bank.springAngular.enam.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private StatuTransaction statuTransaction;
    private String description;

    @ManyToOne
    @JoinColumn( name = "account_id")
    @JsonIgnore
    private Account account;

    @ManyToOne
    @JoinColumn(name="beneficiaryId")
    @JsonIgnore
    private Beneficiary beneficiary;



}
