package com.busy.apis.resources;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.busy.apis.entities.Notification;
import com.busy.apis.service.NotificacaoService;

@RestController
@RequestMapping (value = "/notificacao-firebase")
public class NotificacaoResource {
	
	@Autowired
	private NotificacaoService service;
	

	@GetMapping(value = "/usuario/{cpf}")
	public ResponseEntity<Notification> findByUsuario(@PathVariable Long cpf){
		Notification obj = service.findByUsuario(cpf);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Notification> insert (@RequestBody Notification obj){
		obj.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}


	

}
