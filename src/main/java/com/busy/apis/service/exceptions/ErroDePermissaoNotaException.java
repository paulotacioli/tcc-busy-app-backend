package com.busy.apis.service.exceptions;

public class ErroDePermissaoNotaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ErroDePermissaoNotaException (String msg) {
		super (msg);
	}
}
