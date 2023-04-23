package com.irojascorsico.websecurity.Config;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtService {
    private static final String  SECRET_KEY="586E3272357538782F413F4428472B4B6250655368566B597033733676397924";


    public String generateToken(UserDetails userDetails)
    {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
        Map<String, Object> extraClaims, 
        UserDetails userDetails
    )
        {
            return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
        }

    private Key getSignInKey() {
        byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}


//https://www.allkeysgenerator.com/Random/Security-Encryption-Key-Generator.aspx
