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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_TIPO_SERVICO")
public class TipoServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String tipoServico;
    private double preco;
    private double tempo;
    
	public TipoServico() {

	}

	public Long getId() {
		return id;
	}



	public String getTipoServico() {
		return tipoServico;
	}


	public double getTempo() {
		return tempo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getPreco() {
		return preco;
	}


	

}
