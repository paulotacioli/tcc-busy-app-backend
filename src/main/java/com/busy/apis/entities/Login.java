package com.busy.apis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "TB_LOGIN")

public class Login implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	
	private String senha;

	private int aprovado;
	
 

	@JsonIgnore
	@OneToOne
	@MapsId
	private Usuario usuario;
	
	

	
	/*public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuths;
		if (this.aprovado == 10) {
			grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN");
		} else if (this.aprovado == 3 ){
			grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList("FORBIDEN");
		} else {
			grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList("USER");
		}
		return grantedAuths;
        }
       
	public void setAuthorities() {
		if (this.aprovado == 10) {
			this.grantedAuths = (new SimpleGrantedAuthority("ROLE_USER"));
		} else if (this.aprovado == 3 ){
			this.grantedAuths = (new SimpleGrantedAuthority("ROLE_USER"));
		} else {
			this.grantedAuths = (new SimpleGrantedAuthority("ROLE_USER"));
		}
        } */
	

	public Login () {
		
	}




	public Long getId() {
		return Id;
	}




	public void setId(Long id) {
		Id = id;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}




	public int getAprovado() {
		return aprovado;
	}




	public void setAprovado(int aprovado) {
		this.aprovado = aprovado;
	}




	public Usuario getUsuario() {
		return usuario;
	}




	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	


}
