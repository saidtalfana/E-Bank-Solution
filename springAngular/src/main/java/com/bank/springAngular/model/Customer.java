package com.bank.springAngular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = ""),
                @UniqueConstraint(columnNames = "email")
        })
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer customerID;

    @Column(nullable = false, length = 128)
    @NotNull @Length(min = 1, max = 128)
    private String name;
    private String lastname;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String address;


    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Account> account ;






//    , fetch=FetchType.LAZY, cascade = CascadeType.ALL
//    @OneToMany(mappedBy = "customer")
//    private Set<Account> account;

}
