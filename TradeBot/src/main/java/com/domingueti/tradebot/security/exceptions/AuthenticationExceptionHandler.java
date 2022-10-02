package com.domingueti.tradebot.security.exceptions;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.domingueti.tradebot.utils.statics.TransformObjectToString;

public class AuthenticationExceptionHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException {

		UnauthorizedException exceptionResponse = new UnauthorizedException(new Date(),
				HttpStatus.UNAUTHORIZED.getReasonPhrase(), HttpStatus.UNAUTHORIZED.value(),
				UnauthorizedException.STATUS_ERROR_MESSAGE, request.getRequestURI());
		
		if (exception instanceof DisabledException) {
			if (request.getRequestURI().equals("/user/login")) {
				exceptionResponse.setMessage(UnauthorizedException.STATUS_ERROR_USER_DEACTIVATED_MESSAGE);
			} else {
				exceptionResponse.setMessage(UnauthorizedException.STATUS_ERROR_ADMIN_DEACTIVATED_MESSAGE);
			}			
		}

		if (exception instanceof ExpiredPasswordException) {
			exceptionResponse.setMessage(exception.getMessage());
		}

		String jsonResponse = TransformObjectToString.execute(exceptionResponse);

		response.setStatus(exceptionResponse.getStatus());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonResponse);
	}

}