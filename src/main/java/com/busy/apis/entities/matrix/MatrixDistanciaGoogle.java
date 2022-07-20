package com.busy.apis.entities.matrix;

import java.util.Arrays;
import java.util.List;

public class MatrixDistanciaGoogle {
	
	private String[] destination_addresses;
	private String[] origin_addresses;
	private List<ElementsListaGoogle> rows;
	private String status;

	
	public MatrixDistanciaGoogle() {
		
	}


	public MatrixDistanciaGoogle(String[] destination_addresses, String[] origin_addresses,
			List<ElementsListaGoogle> rows, String status) {
		super();
		this.destination_addresses = destination_addresses;
		this.origin_addresses = origin_addresses;
		this.rows = rows;
		this.status = status;
	}


	public String[] getDestination_addresses() {
		return destination_addresses;
	}


	public void setDestination_addresses(String[] destination_addresses) {
		this.destination_addresses = destination_addresses;
	}


	public String[] getOrigin_addresses() {
		return origin_addresses;
	}


	public void setOrigin_addresses(String[] origin_addresses) {
		this.origin_addresses = origin_addresses;
	}


	public List<ElementsListaGoogle> getRows() {
		return rows;
	}


	public void setRows(List<ElementsListaGoogle> rows) {
		this.rows = rows;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "MatrixDistanciaGoogle [destination_addresses=" + Arrays.toString(destination_addresses)
				+ ", origin_addresses=" + Arrays.toString(origin_addresses) + ", rows=" + rows + ", status=" + status
				+ "]";
	}
	



	
	
	
}
