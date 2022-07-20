package com.busy.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busy.apis.entities.TipoServico;

public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {
	TipoServico findByTipoServico(String tipoServico);
}
