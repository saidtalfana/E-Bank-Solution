package com.bank.springAngular.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountID;
    private Integer accountNumber;
    private int balance;
    private String accountName;
    private Date creationDate;
    private Aco statu;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
