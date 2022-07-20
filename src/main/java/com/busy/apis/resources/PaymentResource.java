package com.busy.apis.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.busy.apis.entities.Usuario;
import com.busy.apis.entities.matrix.paymentSchemas.CardPay;
import com.busy.apis.service.PaymentService;
import com.stripe.model.Card;
import com.stripe.model.PaymentSource;



@RestController
@RequestMapping (value = "/payment")
public class PaymentResource {
	
	@Autowired
	private PaymentService payment;

	@PostMapping
	public ResponseEntity<String> createCardToken (@RequestBody CardPay obj){
		String result = payment.createCardToken(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(result);
	}

	@PostMapping(value = "/delete")
	public ResponseEntity<Boolean> deleteCard (@RequestBody CardPay obj){
		Boolean result = payment.deleteCard(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(result);
	}
	
	@PostMapping(value = "/list-payment-methods")
	public ResponseEntity<List<PaymentSource>> listCards (@RequestBody Usuario obj){
		List<PaymentSource> result = payment.listCards(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(result);
	}


}
