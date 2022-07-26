package com.busy.apis.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.busy.apis.entities.Login;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	private static final long serialVersionUID = -2550185165626007488L;
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	@Value("${jwt.secret}")
	private String secret;

//retrieve username from jwt token
	public String getCpfFromToken(String token) {
		System.out.println("TEMOS: 8");

		return getClaimFromToken(token, Claims::getSubject);
	}

//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		System.out.println("TEMOS: 9");

		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		System.out.println("TEMOS: 10");

		final Claims claims = getAllClaimsFromToken(token);
		System.out.println("TEMOS: 11"+ claims.toString());
		System.out.println("TEMOS: 11 fim");


		return claimsResolver.apply(claims);
	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		System.out.println("TEMOS: 11");
		System.out.println("OQUE É CLAIM:"+ Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody());
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

//check if the token has expired
	private Boolean isTokenExpired(String token) {
		System.out.println("TEMOS: 12");

		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

//generate token for user
	public String generateToken(Login login) {
		System.out.println("TEMOS: 13");

		Map<String, Object> claims = new HashMap<>();
		System.out.println(claims);
		System.out.println("fim 13");
		return doGenerateToken(claims,login.getId().toString());
	}

//while creating the token -
//1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
//2. Sign the JWT using the HS512 algorithm and secret key.
//3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
//   compaction of the JWT to a URL-safe string 
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		System.out.println("TEMOS: 14");

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

//validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
	
		final String cpf = getCpfFromToken(token);	
		return (cpf.toString().equals(userDetails.getUsername()) && !isTokenExpired(token));
				//cpf.toString().equals(userDetails.getId().toString()) && !isTokenExpired(token)
				
	}
}