package com.gooodstudy.goodstudyspring.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.Function;

/**
 * <dependency>
 * 			<groupId>org.springframework.boot</groupId>
 * 			<artifactId>spring-boot-starter-security</artifactId>
 * 		</dependency>
 * <dependency>
 * 			<groupId>io.jsonwebtoken</groupId>
 * 			<artifactId>jjwt</artifactId>
 * 			<version>0.9.1</version>
 * 		</dependency>
 */

@Component
public class JwtTokenUtil implements Serializable {

    private final Set<String> invalidatedTokens = new HashSet<>();

    public JwtTokenUtil() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGenerator.generateKey();
            this.secret = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("Key=" + this.secret);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public SecretKey getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secret));
    }

    public void invalidateToken(String token) {
        invalidatedTokens.add(token);
    }

    public String extractTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Remove the "Bearer " prefix
        }
        return null; // Token not found or in an invalid format

    }

    public boolean isTokenInvalidated(String token) {
        return invalidatedTokens.contains(token);
    }
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    //@Value("${jwt.secret}")
    //@Value("PASSSEGREDO_MUDAR")
    private String secret;

    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims().add(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000)).and()
                .signWith(getKey())
                .compact();
    }

    //retrieve username from jwt token
    public String getEmailFromToken(String token) {
         return getClaimFromToken(token, Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * No java 1.8 uma Function<I, T> sginifica que o I é um input neste caso são Claims o output é o T no caso do Subject uma string
     * @param token
     * @param claimsResolver
     * @return
     * @param <T>
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    //for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //generate token for user
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    //validate token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getEmailFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token) && !invalidatedTokens.contains(token));
    }
}
