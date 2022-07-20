package com.busy.apis.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	

	@GetMapping(value = "/servico/{cpf}")
	public ResponseEntity<List<Usuario>> findAllByHierarquia(@Valid @PathVariable Long cpf){
		List<Usuario> list = service.findAllByHierarquia(cpf);
		return ResponseEntity.ok().body(list);
	}

	

	

	@GetMapping(value = "/pendentes")
	public ResponseEntity<List<Usuario>> findPendentes(){
		List<Usuario> list = service.findPendentes();
		return ResponseEntity.ok().body(list);
	}

	/*
	 * @PutMapping(value = "/atualizar") public ResponseEntity<Usuario>
	 * atualizarUsuario (@RequestBody Usuario obj){ obj =
	 * service.atualizarTransportadora(obj); return ResponseEntity.ok().body(obj); }
	 */
	
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<Usuario> findById(@Valid @PathVariable Long cpf){
		Usuario obj = service.findById(cpf);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	@PostMapping
	public ResponseEntity<Usuario> insert (@RequestBody Usuario obj){
		System.out.println(obj.toString());
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getCpf()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PostMapping(value = "/atualizar")
	public ResponseEntity<Usuario> atualizarUsuario (@RequestBody Usuario obj){
		
		obj = service.atualizarUsuario(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getCpf()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/pendentes/aprovar")
	public ResponseEntity<List<Usuario>> aprovarUsuarios (@RequestBody List<Usuario> obj){
		obj = service.aprovarUsuarios(obj);
	 return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * @PutMapping(value = "/tipo-de-preco") public ResponseEntity<Usuario>
	 * atualizarEscolhaPreco (@RequestBody Usuario obj){ obj =
	 * service.atualizarEscolhaPreco(obj); return ResponseEntity.ok().body(obj); }
	 */
	

}
