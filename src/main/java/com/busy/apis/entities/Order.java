package com.busy.apis.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ORDER")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String dataCriacao = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

	private String dataProcurandoAlocacao;

	private String dataAlocado;

	private String dataFinalizado;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "prestador_id")
	private Usuario prestador;
    
    private double distanciaCalculada;

    private double precoServico;
    
    private double precoBusy;
    
    private double cotacaoBusy;
    
    private double cotacaoKm;
    
    private String cpfNota;
    private String card; 
    private String status;
    
	
	@OneToMany (mappedBy = "order")
	private List<Destino> destino = new ArrayList<>();

	public Order() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	

	public String getCard() {
		return card;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getDistanciaCalculada() {
		return distanciaCalculada;
	}

	public void setDistanciaCalculada(double distanciaCalculada) {
		this.distanciaCalculada = distanciaCalculada;
	}

	public double getPrecoServico() {
		return precoServico;
	}

	public void setPrecoServico(double precoServico) {
		this.precoServico = precoServico;
	}

	public String getCpfNota() {
		return cpfNota;
	}

	public void setCpfNota(String cpfNota) {
		this.cpfNota = cpfNota;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Destino> getDestino() {
		return destino;
	}

	public void setDestino(List<Destino> destino) {
		this.destino = destino;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario getPrestador() {
		return prestador;
	}

	public void setPrestador(Usuario prestador) {
		this.prestador = prestador;
	}

	public double getPrecoBusy() {
		return precoBusy;
	}

	public void setPrecoBusy(double precoBusy) {
		this.precoBusy = precoBusy;
	}

	public double getCotacaoBusy() {
		return cotacaoBusy;
	}

	public void setCotacaoBusy(double cotacaoBusy) {
		this.cotacaoBusy = cotacaoBusy;
	}

	public String getDataProcurandoAlocacao() {
		return dataProcurandoAlocacao;
	}

	public void setDataProcurandoAlocacao(String dataProcurandoAlocacao) {
		this.dataProcurandoAlocacao = dataProcurandoAlocacao;
	}

	public String getDataAlocado() {
		return dataAlocado;
	}

	public void setDataAlocado(String dataAlocado) {
		this.dataAlocado = dataAlocado;
	}

	public String getDataFinalizado() {
		return dataFinalizado;
	}

	public void setDataFinalizado(String dataFinalizado) {
		this.dataFinalizado = dataFinalizado;
	}

	public double getCotacaoKm() {
		return cotacaoKm;
	}

	public void setCotacaoKm(double cotacaoKm) {
		this.cotacaoKm = cotacaoKm;
	}
    
	

	



}
