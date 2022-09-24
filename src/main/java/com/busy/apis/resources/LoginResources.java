package com.busy.apis.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.busy.apis.entities.Login;
import com.busy.apis.service.LoginService;

@RestController
@RequestMapping (value = "/login")
public class LoginResources {
	
	@Autowired
	private LoginService service;
	
	
	
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<Login> findByCpf(@PathVariable Long cpf){
		Login obj = service.findByCpf(cpf);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
