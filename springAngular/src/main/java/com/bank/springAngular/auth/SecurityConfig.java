package com.bank.springAngular.auth;

import com.bank.springAngular.service.UserDatailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

public final UserDatailsServiceImp userDatailsService;
public SecurityConfig(UserDatailsServiceImp userDatailsService) {
    this.userDatailsService = userDatailsService;
}
@Bean
//    BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(csrf->csrf.disable())
            .authorizeHttpRequests(expressionInterceptUrlRegistry ->
                    expressionInterceptUrlRegistry
                            .requestMatchers("/login").permitAll()
                            .requestMatchers("/register").permitAll()
                            .anyRequest().authenticated()
            )
            .formLogin(formLogin ->formLogin.disable()
}

}
