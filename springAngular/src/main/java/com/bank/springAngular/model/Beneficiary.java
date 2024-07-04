package com.bank.springAngular.model;

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
    private String bank;

    @ManyToOne
    @JoinColumn(name = "accountID")
    private Account account;

    @OneToMany(mappedBy = "beneficiary")
    private Set<Transaction> transaction;

}
