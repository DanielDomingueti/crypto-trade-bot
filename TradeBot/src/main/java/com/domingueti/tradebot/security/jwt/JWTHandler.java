package com.domingueti.tradebot.security.jwt;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;



@Component(value= "jwtHandler")
public class JWTHandler {

	@Autowired
	private SecurityConstants securityConstants;
	
	public Long getAdminId(String token) {
		return JWT.require(Algorithm.HMAC512(securityConstants.getSecret().getBytes()))
				.build().verify(token).getClaim("adminId").asLong();
	}
	
	public String createToken(String credential, String[] authorities, long expirationTime) {
		return JWT.create().withSubject(credential).withArrayClaim("authorities", authorities)
				.withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
				.sign(HMAC512(securityConstants.getSecret().getBytes()));
	}
	
	public void verifyToken(String token) {
		JWT.require(Algorithm.HMAC512(securityConstants.getSecret().getBytes())).build()
		.verify(token);
	}
	
	public String getSubject(String token) {
		return JWT.require(Algorithm.HMAC512(securityConstants.getSecret().getBytes()))
				.build().verify(token).getSubject();
	}
	
	public  List<SimpleGrantedAuthority> getAuthorities(String token) {
		List<String> authList = getAuthoritiesString(token);
		
		return authList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());		
	}
	
	public List<String> getAuthoritiesString(String token){
		return  JWT.require(Algorithm.HMAC512(securityConstants.getSecret().getBytes())).build()
				.verify(token).getClaim("authorities").asList(String.class);
	}
}
