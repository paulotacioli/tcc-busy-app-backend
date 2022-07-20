package com.busy.apis.entities.matrix.paymentSchemas;


public class CardPay {
	
	private String number;
	private int exp_month;
	private int exp_year;
	private int cvc;
	private long cpf;


	
	
	public CardPay() {
		
	}




	public String getNumber() {
		return number;
	}




	public void setNumber(String number) {
		this.number = number;
	}




	public int getExp_month() {
		return exp_month;
	}




	public long getCpf() {
		return cpf;
	}




	public void setCpf(long cpf) {
		this.cpf = cpf;
	}




	public void setExp_month(int exp_month) {
		this.exp_month = exp_month;
	}




	public int getExp_year() {
		return exp_year;
	}




	public void setExp_year(int exp_year) {
		this.exp_year = exp_year;
	}




	public int getCvc() {
		return cvc;
	}




	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	
	
	
	
}
