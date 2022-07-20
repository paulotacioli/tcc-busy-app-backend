package com.busy.apis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TAXA")
public class Taxa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String entidade;
    private double taxa;
    
	public Taxa() {

	}

	public Long getId() {
		return id;
	}

	public String getEntidade() {
		return entidade;
	}



	public double getTaxa() {
		return taxa;
	}





	

}
