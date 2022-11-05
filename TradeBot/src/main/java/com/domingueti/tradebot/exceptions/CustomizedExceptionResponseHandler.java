package com.domingueti.tradebot.exceptions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.domingueti.tradebot.security.exceptions.UnauthorizedException;

@ControllerAdvice
public class CustomizedExceptionResponseHandler {

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Not Found", status.value(),
				ex.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(exceptionResponse);
	}
	
}
