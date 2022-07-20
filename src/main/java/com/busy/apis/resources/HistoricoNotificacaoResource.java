package com.busy.apis.resources;

import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.busy.apis.entities.HistoricoNotificacao;
import com.busy.apis.service.HistoricoNotificacaoService;

@RestController
@RequestMapping (value = "/historico-notificacao")
public class HistoricoNotificacaoResource {
	
	@Autowired
	private HistoricoNotificacaoService service;
	

	@GetMapping(value = "/usuario/{cpf}")
	public ResponseEntity<List<HistoricoNotificacao>> findAllByUsuario(@PathVariable Long cpf){
		List<HistoricoNotificacao> obj = service.findAllByUsuario(cpf);
		return ResponseEntity.ok().body(obj);
	}

//	@PostMapping
//	public ResponseEntity<HistoricoNotificacao> insert (@RequestBody HistoricoNotificacao obj) throws IOException{
//		obj.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
//		obj = service.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				  .buildAndExpand(obj).toUri();
//		return ResponseEntity.created(uri).body(obj);
//	}

	@PostMapping(value = "/deletar")
	public ResponseEntity<HistoricoNotificacao> delete (@RequestBody HistoricoNotificacao obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	

}
