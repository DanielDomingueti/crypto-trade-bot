package com.domingueti.tradebot.exceptions;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class InvalidRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    private @Getter List<FieldMessage> fields = new ArrayList<>();

	public InvalidRequestException(String message) {
        super(message);
    } 
}