package com.busy.apis.service.exceptions;

public class UsuarioInvalidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UsuarioInvalidoException (String msg) {
		super (msg);
	}
}
