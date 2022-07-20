package com.busy.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busy.apis.entities.Taxa;

public interface TaxaRepository extends JpaRepository<Taxa, Long> {
	Taxa findByEntidade(String entidade);
}
