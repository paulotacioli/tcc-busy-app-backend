package com.busy.apis.entities.matrix;

import java.util.Arrays;

public class MenorCaminhoRequest {
	
	private String[] enderecos;
	
	
	
	public MenorCaminhoRequest() {
		
	}
	
	


	public MenorCaminhoRequest(String[] enderecos) {
		super();
		this.enderecos = enderecos;
	}





	public String[] getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(String[] enderecos) {
		this.enderecos = enderecos;
	}




	@Override
	public String toString() {
		return "MenorCaminhoRequest [enderecos=" + Arrays.toString(enderecos) + "]";
	}






	
	
	
}
