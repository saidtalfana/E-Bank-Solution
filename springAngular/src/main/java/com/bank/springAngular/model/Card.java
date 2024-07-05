package com.bank.springAngular.model;

import com.bank.springAngular.enam.CardType;
import com.bank.springAngular.enam.Statu;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer cardID;

    private Integer cardNumber;
    private String name;
    private CardType cardType;
    @Column(nullable=false)
    private Statu statu;
    @DateTimeFormat(pattern ="yyyy-mm-dd")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name ="accountID")
    private Account account;





}
