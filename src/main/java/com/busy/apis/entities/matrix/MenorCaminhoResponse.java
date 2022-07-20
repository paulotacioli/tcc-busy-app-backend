package com.busy.apis.entities.matrix;

import java.util.Arrays;

public class MenorCaminhoResponse {
	
	private int[] index;
	private String[] enderecos;
	private long km;
	
	
	public MenorCaminhoResponse() {
		
	}
	
	


	public MenorCaminhoResponse(int[] index, String[] enderecos, long km) {
		super();
		this.index = index;
		this.enderecos = enderecos;
		this.km = km;
	}




	public int[] getIndex() {
		return index;
	}


	public void setIndex(int[] is) {
		this.index = is;
	}


	public String[] getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(String[] enderecos) {
		this.enderecos = enderecos;
	}


	public long getKm() {
		return km;
	}


	public void setKm(long km) {
		this.km = km;
	}


	@Override
	public String toString() {
		return "MenorCaminhoResponse [index=" + Arrays.toString(index) + ", enderecos=" + Arrays.toString(enderecos)
				+ ", km=" + km + "]";
	}

	
	
	
}
