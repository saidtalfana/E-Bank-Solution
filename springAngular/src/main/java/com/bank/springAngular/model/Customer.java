package com.bank.springAngular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
//@Component
@AllArgsConstructor
@Builder

public class Customer implements UserDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer customerID;

    @Column(nullable = false, length = 128)
    @NotNull @Length(min = 1, max = 128)
    private String name;
    @Column
    private String username;
    @Column
    private String password;
    @Column(unique = true, length = 100, nullable = false)
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String address;

//   @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Account> account ;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
