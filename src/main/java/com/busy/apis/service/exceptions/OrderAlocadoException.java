package com.busy.apis.service.exceptions;

public class OrderAlocadoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public OrderAlocadoException (String msg) {
		super (msg);
	}
}
