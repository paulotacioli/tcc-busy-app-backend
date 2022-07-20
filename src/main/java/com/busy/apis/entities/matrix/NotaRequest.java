package com.busy.apis.entities.matrix;

public class NotaRequest {
	
	private String nota;
	private String serie;
	private String centro;
	private Long cnpjTransportadora;
	
	public NotaRequest() {
		
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public Long getCnpjTransportadora() {
		return cnpjTransportadora;
	}

	public void setCnpjTransportadora(Long cnpjTransportadora) {
		this.cnpjTransportadora = cnpjTransportadora;
	}
	
	
	
}
