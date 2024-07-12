package com.bank.springAngular.model;

import com.bank.springAngular.enam.Bank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer beneficiaryID;
    private Integer accountNumber;
    private String name;
    private Bank bank;

    @OneToMany(mappedBy = "beneficiary" )
    private Set<Account> accounts;

    @OneToMany(mappedBy = "beneficiary")
    @JsonIgnore
    private Set<Transaction> transaction;

}
