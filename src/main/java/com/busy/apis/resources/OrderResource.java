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

import com.busy.apis.entities.Order;
import com.busy.apis.service.OrderService;
import com.stripe.exception.StripeException;



@RestController
@RequestMapping (value = "/order")
public class OrderResource {
	
	@Autowired
	private OrderService order;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> obj = order.findAll();
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = order.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/usuario/{cpf}")
	public ResponseEntity<List<Order>> findAllByUsuario(@PathVariable Long cpf){
		List<Order> obj = order.findAllByUsuario(cpf);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Order> insert (@RequestBody Order obj){
		obj = order.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PostMapping(value = "/alocar")
	public ResponseEntity<Order> alocar (@RequestBody Order obj){
		obj = order.alocar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PostMapping(value = "/procurar-alocacao")
	public ResponseEntity<Order> procurarAlocacao (@RequestBody Order obj) throws StripeException{
		obj = order.procurarAlocacao(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	
	

}
