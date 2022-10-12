package com.busy.apis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "TB_USUARIO",
uniqueConstraints=
@UniqueConstraint(columnNames={"cpf"})
)
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nomeCompleto;
	@NotNull
	@Id
	private Long cpf;
	@NotEmpty
	private String celular;
	@NotEmpty
	private String senha;
	@NotEmpty
	private String senhaConfirm;
	@NotEmpty
	private String email;
	@NotNull
	private Long hierarquia;

	@NotNull
	private Integer aprovado;
		
	public Usuario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}
	

	public Long getHierarquia() {
		return hierarquia;
	}

	public void setHierarquia(Long hierarquia) {
		this.hierarquia = hierarquia;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaConfirm() {
		return senhaConfirm;
	}

	public void setSenhaConfirm(String senhaConfirm) {
		this.senhaConfirm = senhaConfirm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAprovado() {
		return aprovado;
	}

	public void setAprovado(Integer aprovado) {
		this.aprovado = aprovado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
