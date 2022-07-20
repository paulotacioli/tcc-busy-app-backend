package com.busy.apis.entities.matrix;

public class Data {
	
	private Long id;
	private String pedido;
	
	private String qtd_volume_nfe;
	private String peso_total_nfe;
	private String volume_nf;
	
	
	private Long cnpj_transportadora;
	
	private String email_cliente;
	private String uf_cod_cliente;
	private String nome_cliente;
	private String telefone_cliente;
	private String endereco_cliente;
	private String endereco_numero;
	private String endereco_complemento;
	private String cep_cliente;
	private String cidade_cliente;
	private String bairro_cliente;
	private String uf_cliente;

	
	public Data() {
		
	}



	public Data(String pedido, String qtd_volume_nfe, String peso_total_nfe, String volume_nf, Long cnpj_transportadora,
			String email_cliente, String uf_cod_cliente, String nome_cliente, String telefone_cliente,
			String endereco_cliente, String endereco_numero, String endereco_complemento, String cep_cliente,
			String cidade_cliente, String bairro_cliente, String uf_cliente) {
		super();
		this.pedido = pedido;
		this.qtd_volume_nfe = qtd_volume_nfe;
		this.peso_total_nfe = peso_total_nfe;
		this.volume_nf = volume_nf;
		this.cnpj_transportadora = cnpj_transportadora;
		this.email_cliente = email_cliente;
		this.uf_cod_cliente = uf_cod_cliente;
		this.nome_cliente = nome_cliente;
		this.telefone_cliente = telefone_cliente;
		this.endereco_cliente = endereco_cliente;
		this.endereco_numero = endereco_numero;
		this.endereco_complemento = endereco_complemento;
		this.cep_cliente = cep_cliente;
		this.cidade_cliente = cidade_cliente;
		this.bairro_cliente = bairro_cliente;
		this.uf_cliente = uf_cliente;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getPedido() {
		return pedido;
	}



	public void setPedido(String pedido) {
		this.pedido = pedido;
	}



	public String getQtd_volume_nf() {
		return qtd_volume_nfe;
	}



	public void setQtd_volume_nf(String qtd_volume_nfe) {
		this.qtd_volume_nfe = qtd_volume_nfe;
	}



	public String getPeso_total_nfe() {
		return peso_total_nfe;
	}



	public void setPeso_total_nfe(String peso_total_nfe) {
		this.peso_total_nfe = peso_total_nfe;
	}



	public String getVolume_nf() {
		return volume_nf;
	}



	public void setVolume_nf(String volume_nf) {
		this.volume_nf = volume_nf;
	}



	public Long getCnpj_transportadora() {
		return cnpj_transportadora;
	}



	public void setCnpj_transportadora(Long cnpj_transportadora) {
		this.cnpj_transportadora = cnpj_transportadora;
	}



	public String getEmail_cliente() {
		return email_cliente;
	}



	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}



	public String getUf_cod_cliente() {
		return uf_cod_cliente;
	}



	public void setUf_cod_cliente(String uf_cod_cliente) {
		this.uf_cod_cliente = uf_cod_cliente;
	}



	public String getNome_cliente() {
		return nome_cliente;
	}



	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}



	public String getTelefone_cliente() {
		return telefone_cliente;
	}



	public void setTelefone_cliente(String telefone_cliente) {
		this.telefone_cliente = telefone_cliente;
	}



	public String getEndereco_cliente() {
		return endereco_cliente;
	}



	public void setEndereco_cliente(String endereco_cliente) {
		this.endereco_cliente = endereco_cliente;
	}



	public String getEndereco_numero() {
		return endereco_numero;
	}



	public void setEndereco_numero(String endereco_numero) {
		this.endereco_numero = endereco_numero;
	}



	public String getEndereco_complemento() {
		return endereco_complemento;
	}



	public void setEndereco_complemento(String endereco_complemento) {
		this.endereco_complemento = endereco_complemento;
	}



	public String getCep_cliente() {
		return cep_cliente;
	}



	public void setCep_cliente(String cep_cliente) {
		this.cep_cliente = cep_cliente;
	}



	public String getCidade_cliente() {
		return cidade_cliente;
	}



	public void setCidade_cliente(String cidade_cliente) {
		this.cidade_cliente = cidade_cliente;
	}



	public String getBairro_cliente() {
		return bairro_cliente;
	}



	public void setBairro_cliente(String bairro_cliente) {
		this.bairro_cliente = bairro_cliente;
	}



	public String getUf_cliente() {
		return uf_cliente;
	}



	public void setUf_cliente(String uf_cliente) {
		this.uf_cliente = uf_cliente;
	}

	
	
	
}
