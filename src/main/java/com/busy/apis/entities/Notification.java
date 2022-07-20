package com.busy.apis.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_NOTIFICACAO", uniqueConstraints=
@UniqueConstraint(columnNames={"usuario"}))
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long usuario;
	private String chaveFirebase; 
	private String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	public String getChaveFirebase() {
		return chaveFirebase;
	}
	public void setChaveFirebase(String chaveFirebase) {
		this.chaveFirebase = chaveFirebase;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	

	
	
	
}
