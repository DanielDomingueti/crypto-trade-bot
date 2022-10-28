package com.domingueti.tradebot.security.exceptions;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.domingueti.tradebot.security.jwt.JWTHandler;
import com.domingueti.tradebot.utils.statics.TransformObjectToString;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserAccessExceptionHandler {
	
	private JWTHandler jwtHandler;

	public boolean verify(String token, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		UnauthorizedException exceptionResponse;
		String jsonResponse;
		
		String route = request.getRequestURI();
		Long adminId = jwtHandler.getAdminId(token);
		
		if (adminId == null) {
			if (route.contains("/admin")) {
				
				exceptionResponse = new UnauthorizedException(new Date(), "Forbidden route for the given user", HttpStatus.FORBIDDEN.value(),
						UnauthorizedException.STATUS_FORBIDDEN_USER_ROUTE, route);
				
				jsonResponse = TransformObjectToString.execute(exceptionResponse);
				
				response.setStatus(exceptionResponse.getStatus());
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(jsonResponse);
				
				return false;
			}
		}
		return true;
	}
}
