package com.example.demo.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtils {
    public String generateToken(UserDetails userDetails)
    {
        Map<String, Object> claims = new HashMap<>();

        return createToken(claims, userDetails.getUsername());

    }

    private String createToken(Map<String, Object> claims, String subject)
    {

        return Jwts.builder().setClaims(claims).setSubject(subject).signWith(SignatureAlgorithm.HS256, "Secret").compact();

    }

    public String extractUsername(String token)
    {

        return extractClaim(token, Claims::getSubject);

    }
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = Jwts.parser().setSigningKey("Secret").parseClaimsJws(token).getBody();

        return claimsResolver.apply(claims);

    }

    public Boolean validateToken(String token, UserDetails userDetails)
    {
        String username = extractUsername(token);

        return username.equals(userDetails.getUsername());

    }


}
