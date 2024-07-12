package com.bank.springAngular.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String authHeader = request.getHeader("Authorization");
            if (authHeader != null && authHeader.startsWith("Bearer ")) {

             String   jwt = authHeader.substring(7);

                Claims claims = Jwts.parser()
                        .setSigningKey(JwtAuth.SECRET_KEY)
                        .build()
                        .parseClaimsJws(jwt)
                        .getBody();


                // Vous pouvez maintenant utiliser les claims pour obtenir des informations du JWT
                String username = claims.getSubject();
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        username, null, null);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request,response);


            }
            else {
                filterChain.doFilter(request,response);
            }
    }
}
