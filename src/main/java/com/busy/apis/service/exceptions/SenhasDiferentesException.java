package com.busy.apis.service.exceptions;

public class SenhasDiferentesException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public SenhasDiferentesException (String msg) {
		super (msg);
	}
}
