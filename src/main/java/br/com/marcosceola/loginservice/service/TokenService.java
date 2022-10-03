package br.com.marcosceola.loginservice.service;

import br.com.marcosceola.loginservice.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        var user = (User) authentication.getPrincipal();
        var currentDate = new Date();

        return Jwts.builder()
            .setIssuer("Login Service By: Marcos Vinicius Ceola")
            .setSubject(user.getId().toString())
            .setIssuedAt(currentDate)
            .setExpiration(new Date(currentDate.getTime() + Long.parseLong(expiration)))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(this.secret)
                .parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserId(String token) {
        return Long.parseLong(Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .getBody()
            .getSubject());
    }
}
