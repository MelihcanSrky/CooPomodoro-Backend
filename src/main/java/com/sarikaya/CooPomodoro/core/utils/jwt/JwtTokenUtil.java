package com.sarikaya.CooPomodoro.core.utils.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {
    private static final String SECRET_KEY = "CooMepoLomoCandoSrrokyservicesCooMepoCooMepoLomoCandoSrrokyservicesCooMepoLomoCandoSrrokyservicesLomoCandoSrrokyservices";

    public static String generateToken(String user_uuid) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 86400000);

        return Jwts.builder()
                .setSubject(user_uuid)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
