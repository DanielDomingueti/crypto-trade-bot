package com.domingueti.tradebot.security.exceptions;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.domingueti.tradebot.security.jwt.JWTHandler;
import com.domingueti.tradebot.utils.statics.TransformObjectToString;

public class TokenExceptionHandler {

	private JWTHandler jwtHandler;

	public boolean verify(String token, HttpServletRequest request, HttpServletResponse response) throws IOException {

		TokenException exceptionResponse;
		String jsonResponse;

		try {
			
			jwtHandler.verifyToken(token);
		
		} catch (TokenExpiredException e) {

			exceptionResponse = new TokenException(new Date(), e.getMessage(), HttpStatus.NOT_ACCEPTABLE.value(),
					TokenException.STATUS_EXPIRED_MESSAGE, request.getRequestURI());

			jsonResponse = TransformObjectToString.execute(exceptionResponse);

			response.setStatus(exceptionResponse.getStatus());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResponse);

			return false;

		} catch (JWTVerificationException e) {

			exceptionResponse = new TokenException(new Date(), e.getMessage(), HttpStatus.NOT_ACCEPTABLE.value(),
					TokenException.STATUS_INVALID_MESSAGE, request.getRequestURI());

			jsonResponse = TransformObjectToString.execute(exceptionResponse);

			response.setStatus(exceptionResponse.getStatus());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResponse);

			return false;
		}

		return true;
	}
	
}
