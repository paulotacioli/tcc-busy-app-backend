package com.busy.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busy.apis.entities.HistoricoNotificacao;
import com.busy.apis.entities.Usuario;

public interface HistoricoNotificacaoRepository extends JpaRepository<HistoricoNotificacao, Long> {
	void deleteById(Long id);
	List<HistoricoNotificacao> findAllByUsuario(Usuario usuario);
	
}
