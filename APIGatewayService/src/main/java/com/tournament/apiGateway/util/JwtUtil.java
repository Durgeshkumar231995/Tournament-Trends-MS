package com.tournament.apiGateway.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public Claims getAllClaimsFromToken(String token) {
        if(token!=null && !(token.startsWith("Bearer"))){
            throw new RuntimeException("JWT Token is missing");
        }
        String jwtToken = token.substring(7);
        return (Claims)Jwts.parser().setSigningKey(secret).parse(jwtToken).getBody();
    }

//    private boolean isTokenExpired(String token) {
//       return this.getAllClaimsFromToken(token).getExpiration().before(new Date());
//    }
//
//    public boolean isInvalid(String token) {
//        return this.isTokenExpired(token);
//    }
}
