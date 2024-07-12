package com.bank.springAngular.auth;

import com.bank.springAngular.service.UserDetailsServiceImp;
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

    private final UserDetailsServiceImp userDetailsService;

    public SecurityConfig(UserDetailsServiceImp userDetailsService) {
        this.userDetailsService = userDetailsService;
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
            .formLogin(formLogin ->formLogin.disable());// Désactiver le formulaire de login par défaut de Spring Security
                http.addFilterBefore(new JwtAuthFilter(), UsernamePasswordAuthenticationFilter.class);
            return http.build();
}

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}





