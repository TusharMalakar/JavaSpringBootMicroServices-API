package com.JavaAPI_SpringBoot.Home.security;

import java.util.Date;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Used by {@link ExceptionTranslationFilter} to commence an authentication scheme.
 * @author Tushar Malakar
 */


@Component
public class Jwt {

	final String secret = "THISanSECRETkeY";
	
    public String generate_cookie(String username) {
    	
    	Date date = new Date();
    	long current = date.getTime();
    	Date expirationTime = new Date(current+ 10000*60*60*24); // Adds 1 hour

    	//creating a cookie for an hour
        Claims claims = Jwts.claims()
                .setSubject(username).setExpiration(expirationTime);
        		

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    
    public String validate_cookie(String cookie) {


	    try {
	        Claims body = Jwts.parser()
	                .setSigningKey(secret)
	                .parseClaimsJws(cookie)
	                .getBody();
	        return "SUCCESS"+body.getSubject();
	        
	    }
	    catch (ExpiredJwtException ex) {
	        System.out.println(ex.getMessage());
	
	        return "Invalid token, Please log in again ";
	    }
}

	
    
    
}
