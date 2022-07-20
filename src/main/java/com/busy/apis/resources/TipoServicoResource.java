package com.busy.apis.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busy.apis.entities.TipoServico;
import com.busy.apis.service.TipoServicoService;

@RestController
@RequestMapping (value = "/tipos-servicos")
public class TipoServicoResource {
	
	@Autowired
	private TipoServicoService service;
	

	@GetMapping(value = "/select")
	public ResponseEntity<List<TipoServico>> findAllSelect(){
		List<TipoServico> obj = service.findAllSelect();
		return ResponseEntity.ok().body(obj);
	}


	

}
