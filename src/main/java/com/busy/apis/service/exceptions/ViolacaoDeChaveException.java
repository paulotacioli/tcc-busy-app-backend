package com.busy.apis.service.exceptions;

public class ViolacaoDeChaveException extends RuntimeException{

private static final long serialVersionUID = 1L;
	
	public ViolacaoDeChaveException (String msg) {
		super(msg);
	}
}
