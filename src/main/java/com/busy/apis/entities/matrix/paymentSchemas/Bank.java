package com.busy.apis.entities.matrix.paymentSchemas;


public class Bank {
	
	private String account_holder_name;
	private String routing_number;
	private String account_number;
	private String account_holder_type;
	private Long cpf;
	
	public String getAccount_holder_name() {
		return account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}
	public String getRouting_number() {
		return routing_number;
	}
	public void setRouting_number(String routing_number) {
		this.routing_number = routing_number;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getAccount_holder_type() {
		return account_holder_type;
	}
	public void setAccount_holder_type(String account_holder_type) {
		this.account_holder_type = account_holder_type;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	
	
	
	
	
}
