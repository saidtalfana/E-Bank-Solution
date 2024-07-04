package com.bank.springAngular.model;

import com.bank.springAngular.enam.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountID;
    private String accountName;
    private Integer accountNumber;
    private double balance;
    private Date creationDate;
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @OneToMany(mappedBy = "account")
    private Set<Transaction> transaction;

    @OneToMany(mappedBy = "account")
    private Set<Beneficiary> beneficiary;

    @OneToMany(mappedBy = "account")
    private Set<Card> card;
}
