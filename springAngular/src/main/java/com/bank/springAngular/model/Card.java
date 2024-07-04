package com.bank.springAngular.model;

import jakarta.persistence.*;
import lombok.*;

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
    private Statu statu;
    private Date endDate;





}
