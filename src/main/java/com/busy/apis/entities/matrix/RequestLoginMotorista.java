package com.busy.apis.entities.matrix;

public class RequestLoginMotorista {
	
	private Long cpf_motorista;
	
	private String cnpj_transportadora;
	private String nome;
	private String email;
	private String password;
	private String placa;
	private int aprovado;
	
	public RequestLoginMotorista() {
		
	}
	
	



	public RequestLoginMotorista(Long cpf_motorista, String cnpj_transportadora, String nome, String email,
			String password, String placa) {
		super();
		this.cpf_motorista = cpf_motorista;
		this.cnpj_transportadora = cnpj_transportadora;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.placa = placa;
	}





	public Long getCpf_motorista() {
		return cpf_motorista;
	}



	public void setCpf_motorista(Long cpf_motorista) {
		this.cpf_motorista = cpf_motorista;
	}



	public int getAprovado() {
		return aprovado;
	}





	public void setAprovado(int aprovado) {
		this.aprovado = aprovado;
	}





	public String getCnpj_transportadora() {
		return cnpj_transportadora;
	}

	public void setCnpj_transportadora(String cnpj_transportadora) {
		this.cnpj_transportadora = cnpj_transportadora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}


	
	
	
}
