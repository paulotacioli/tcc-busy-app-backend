package com.busy.apis.service.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public RecursoNaoEncontradoException (Object objeto, Object identificacao) {
		super ("Não foi encontrad" + objeto + " no sistema. Segue identificação do recurso: "+ identificacao);
	}
}
