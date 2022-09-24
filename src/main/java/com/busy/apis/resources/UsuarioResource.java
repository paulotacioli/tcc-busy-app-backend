package com.busy.apis.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.busy.apis.entities.Usuario;
import com.busy.apis.service.UsuarioService;

@RestController
@RequestMapping (value = "/usuario")
public class UsuarioResource {
	
	@Autowired	
	private UsuarioService service;
	
	// Essa API retorna informações do usuário dado o cpf
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<Usuario> findById(@Valid @PathVariable Long cpf){
		Usuario obj = service.findById(cpf);
		return ResponseEntity.ok().body(obj);
	}
	
	
	//Fazer inserção de usuário, login e identifier no banco de dados.
	@PostMapping
	public ResponseEntity<Usuario> insert (@RequestBody Usuario obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getCpf()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}


}
