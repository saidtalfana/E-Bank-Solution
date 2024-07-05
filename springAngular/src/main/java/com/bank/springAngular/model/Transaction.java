package com.bank.springAngular.model;

import com.bank.springAngular.enam.StatuTransaction;
import com.bank.springAngular.enam.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.regex.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer transactionID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate transactionDate;
    @DateTimeFormat(pattern = "HH:MM")
    private LocalTime time;
    private Double amount;
    private TransactionType transactionType;
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
