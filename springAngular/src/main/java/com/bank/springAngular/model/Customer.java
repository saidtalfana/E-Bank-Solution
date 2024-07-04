package com.bank.springAngular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer customerID;
    private String name;
    private String lastname;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String address;


    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Account> account ;






//    , fetch=FetchType.LAZY, cascade = CascadeType.ALL
//    @OneToMany(mappedBy = "customer")
//    private Set<Account> account;

}
