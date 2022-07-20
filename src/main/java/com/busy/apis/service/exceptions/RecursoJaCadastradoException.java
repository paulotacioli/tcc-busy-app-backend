package com.busy.apis.service.exceptions;

public class RecursoJaCadastradoException extends RuntimeException{

private static final long serialVersionUID = 1L;
	
	public RecursoJaCadastradoException (Object objeto, Object identificacao) {
		super (objeto + " Segue identificação do recurso: "+ identificacao);
	}
}
