package com.busy.apis.service;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.busy.apis.entities.Notification;
import com.busy.apis.repositories.NotificacaoRepository;
import com.busy.apis.service.exceptions.CamposObrigatoriosException;
import com.busy.apis.service.exceptions.ErroNaoMapeadoException;

@Service
public class NotificacaoService {

	@Autowired
	private NotificacaoRepository repository;

	public Notification findByUsuario(Long cpf) {

		return repository.findByUsuario(cpf);

	}

	public Notification insert(Notification obj) {
		try {
			repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			Notification objNot = repository.findByUsuario(obj.getUsuario());
			repository.deleteById(objNot.getId());
			repository.save(obj);

		} catch (ConstraintViolationException e) {
			throw new CamposObrigatoriosException(null,"Campos obrigatórios devem ser preenchidos.");
			
		} catch (RuntimeException e) {
			throw new ErroNaoMapeadoException("");
		}
		return obj;

	}


}
