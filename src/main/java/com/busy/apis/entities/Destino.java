package com.busy.apis.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_DESTINO")
public class Destino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(length = 5000)
	private String destino;
	
	@NotNull
	private int ordem;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private Order order;
	
	@NotEmpty
	private String tipoAtividadeRetiradaPrestacao;
	
	@Column(length = 150)
	private String nomeContatoRetirada;

	@Column(length = 500)
	private String observacaoRetirada;
	
	@Column(length = 500)
	private String observacaoPrestacao;
	
	private String tipoServicoPrestacao;

	public Destino() {

	}
	
	

	public Destino(@NotEmpty String destino, int ordem, Order order, @NotEmpty String tipoAtividadeRetiradaPrestacao,
			String nomeContatoRetirada, String observacaoRetirada, String observacaoPrestacao,
			String tipoServicoPrestacao) {
		super();
		this.destino = destino;
		this.ordem = ordem;
		this.order = order;
		this.tipoAtividadeRetiradaPrestacao = tipoAtividadeRetiradaPrestacao;
		this.nomeContatoRetirada = nomeContatoRetirada;
		this.observacaoRetirada = observacaoRetirada;
		this.observacaoPrestacao = observacaoPrestacao;
		this.tipoServicoPrestacao = tipoServicoPrestacao;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getTipoAtividadeRetiradaPrestacao() {
		return tipoAtividadeRetiradaPrestacao;
	}

	public void setTipoAtividadeRetiradaPrestacao(String tipoAtividadeRetiradaPrestacao) {
		this.tipoAtividadeRetiradaPrestacao = tipoAtividadeRetiradaPrestacao;
	}

	public String getNomeContatoRetirada() {
		return nomeContatoRetirada;
	}

	public void setNomeContatoRetirada(String nomeContatoRetirada) {
		this.nomeContatoRetirada = nomeContatoRetirada;
	}

	public String getObservacaoRetirada() {
		return observacaoRetirada;
	}

	public void setObservacaoRetirada(String observacaoRetirada) {
		this.observacaoRetirada = observacaoRetirada;
	}

	public String getObservacaoPrestacao() {
		return observacaoPrestacao;
	}

	public void setObservacaoPrestacao(String observacaoPrestacao) {
		this.observacaoPrestacao = observacaoPrestacao;
	}

	public String getTipoServicoPrestacao() {
		return tipoServicoPrestacao;
	}

	public void setTipoServicoPrestacao(String tipoServicoPrestacao) {
		this.tipoServicoPrestacao = tipoServicoPrestacao;
	}
	


}
