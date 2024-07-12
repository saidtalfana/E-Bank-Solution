package com.bank.springAngular.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.sql.Date;

@Service
public class JwtAuth {

      public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

     public static String generateToken(String username) {
       return Jwts.builder()
             .setSubject(username)
              .setIssuedAt(new Date(System.currentTimeMillis()))
              .setExpiration(new Date(System.currentTimeMillis() +(2* (24*60*60*100))))
               .signWith(SECRET_KEY)
               .compact();

      }
  }
