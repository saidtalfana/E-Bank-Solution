package com.bank.springAngular.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    private int customerID;
    private String name;
    private String lastname;
    private String email;
    private Date date;
    private String adress;


    @OneToMany(mappedBy = "customer")
    private Set<Account> account ;






//    , fetch=FetchType.LAZY, cascade = CascadeType.ALL
//    @OneToMany(mappedBy = "customer")
//    private Set<Account> account;

}
