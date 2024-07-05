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

    @ManyToOne
    @JoinColumn(name = "accountID")
    private Account account;

    @OneToMany(mappedBy = "beneficiary")
    @JsonIgnore
    private Set<Transaction> transaction;

}
