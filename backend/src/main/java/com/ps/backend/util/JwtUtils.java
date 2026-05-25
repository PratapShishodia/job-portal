package com.ps.backend.util;

import com.ps.backend.entity.Users;
import com.ps.backend.repository.UserRepo;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtils {

    private final UserRepo userRepo;

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String email) {
        Users user = userRepo.findByUserEmail(email).orElseThrow(()->new RuntimeException("User not found"));
        return Jwts.builder()
                .subject(user.getUserEmail())
                .claim("Role",user.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 60*60*1000))
                .signWith(getSecretKey())
                .compact();
    }

    public String getUsernameFromToken(String token) {
        System.out.println("getUsernameFromToken");
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            System.out.println("Invalid JWT Token: " + e.getMessage());
            return false;
        }
    }
}
