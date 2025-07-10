package com.dragonsky.nextpage.config.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.access-token-validity}")
    private long accessTokenValidityInMs;

    @Value("${jwt.refresh-token-validity}")
    private long refreshTokenValidityInMs;

    public String createAccessToken(Long memberId, String email) {
        return createToken(memberId, email, accessTokenValidityInMs);
    }

    public String createRefreshToken(Long memberId, String email) {
        return createToken(memberId, email, refreshTokenValidityInMs);
    }

    private String createToken(Long memberId, String email, long validityInMs) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setSubject(String.valueOf(memberId))
                .claim("email", email)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(
                        Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)),
                        SignatureAlgorithm.HS256
                )
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey.getBytes()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getMemberId(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}