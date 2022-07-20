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
@Table (name = "TB_IDENTIFIER",
uniqueConstraints=
@UniqueConstraint(columnNames={"cpf"})
)
public class Identifier implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Id
	private Long cpf;
	@NotEmpty
	private String idCustomer;
		
	
		
	public Identifier() {
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getCpf() {
		return cpf;
	}



	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}



	public String getIdCustomer() {
		return idCustomer;
	}



	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	

}
