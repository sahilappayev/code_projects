package org.mn.booking.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Value("${jwt.access.secret-key}")
    private String accessSecretKey;

    @Value("${jwt.refresh.secret-key}")
    private String refreshSecretKey;

    @Value("${jwt.access.ttl}")
    private Integer ttlAccessInMinutes;

    @Value("${jwt.refresh.ttl}")
    private Integer ttlRefreshInMinutes;


    public String extractUsername(String token) {
        return extractClaim(token, getAccessSecretKey(), Claims::getSubject);
    }

    public String extractUsernameRefresh(String token) {
        return extractClaim(token, getRefreshSecretKey(), Claims::getSubject);
    }

    public <T> T extractClaim(String token, Key key, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token, key);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails, Map<String, Object> extraClaims) {
        return buildAccessToken(userDetails, extraClaims);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, getAccessSecretKey(), Claims::getExpiration);
    }

    private Claims extractAllClaims(String token, Key key) {
        return Jwts
                .parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public String buildAccessToken(UserDetails userDetails, Map<String, Object> extraClaims) {
        return Jwts.builder().subject(userDetails.getUsername())
                .claim("roles", userDetails.getAuthorities())
                .claims(extraClaims)
                .issuedAt(new Date())  // 2 * 60 * 1000
                .expiration(new Date(System.currentTimeMillis() + (1000L * 60 * ttlAccessInMinutes)))
                .signWith(getAccessSecretKey(), SignatureAlgorithm.HS256).compact();
    }

    public String buildRefreshToken(UserDetails userDetails, Map<String, Object> extraClaims) {
        return Jwts.builder().subject(userDetails.getUsername())
                .claims(extraClaims)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + (1000L * 60 * ttlRefreshInMinutes)))
                .signWith(getRefreshSecretKey(), SignatureAlgorithm.HS256).compact();
    }


    private Key getAccessSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(accessSecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Key getRefreshSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(refreshSecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
