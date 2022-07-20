package com.busy.apis.service.exceptions;

import java.util.Set;

public class CamposObrigatoriosException extends RuntimeException{

private static final long serialVersionUID = 1L;
	
	public CamposObrigatoriosException (Object id, String msg) {
		super(msg);
	}



}
