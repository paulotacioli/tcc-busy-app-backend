package com.busy.apis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busy.apis.entities.TipoServico;
import com.busy.apis.repositories.TipoServicoRepository;

@Service
public class TipoServicoService {

	@Autowired
	private TipoServicoRepository repository;


	public List<TipoServico> findAllSelect() {
		return repository.findAll();

	}


}
