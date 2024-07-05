package com.bank.springAngular.model;

import com.bank.springAngular.enam.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


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
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date creationDate;
    private AccountType accountType;
    private Boolean isClosed = false;
    private String raisonMssg;

    @ManyToOne
    @JoinColumn(name = "customer_id" , nullable = false)
    private Customer customer;


    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<Transaction> transaction;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<Beneficiary> beneficiary;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<Card> card;
}
