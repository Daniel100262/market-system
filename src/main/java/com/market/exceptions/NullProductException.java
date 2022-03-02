package com.market.exceptions;

public class NullProductException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public NullProductException(String message) {
		super(message);
	}
	
}
