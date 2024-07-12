package com.bank.springAngular.auth;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtAuth {

    public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
}
