package com.busy.apis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.busy.apis.entities.Login;
import com.busy.apis.entities.Usuario;
import com.busy.apis.repositories.LoginRepository;
import com.busy.apis.service.exceptions.RecursoNaoEncontradoException;

@Service
public class LoginService implements UserDetailsService{
	
	
	@Autowired
	private LoginRepository repository;
	
	
	public List<Login> findAll(){
		return repository.findAll();

	}
	
	public Login findByCpf(Long cpf) {
		Optional<Login> obj = repository.findById(cpf);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(cpf,1));
	}
	
	public Login insert (Login obj) {	
	
		return repository.save(obj);
	
	}
	
	public void saveLoginCorretor(Usuario obj) {
	Login login = new Login();
		login.setUsuario(obj);
		login.setSenha(obj.getSenha());
		
		System.out.println("hola amigos:"+ obj.getAprovado());
		//login.setAprovado(obj.getAprovado());
		
		repository.save(login);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  Login login = findByCpf(Long.parseLong(username));
		  
		  
		  System.out.println("TEMOS 40:"+ login.getId().toString());

		    UserBuilder builder = null;
		    if (login != null) {
		      builder = org.springframework.security.core.userdetails.User.withUsername(username);
		      builder.password(login.getSenha());
		      if(login.getAprovado() == 0) {
			      builder.roles("TECNICO");
		      } else if (login.getAprovado() == 1) {
		    	  builder.roles("ADMINISTRADOR");
		      } else if (login.getAprovado() == 2) {
		    	  builder.roles("SISTEMA");
		      }else {
		    	  builder.roles("FORBIDEN");
		      }
		    } else {
		      throw new UsernameNotFoundException("User not found.");
		    }
		    
		    System.out.println("TEMOS 41:"+ builder.toString());
		    System.out.println("TEMOS 41:"+ builder.build().toString());

		    return builder.build();
		  }
		
  
}

	
	
//	new BCryptPasswordEncoder().encode


