package com.busy.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busy.apis.entities.Identifier;

public interface IdentifierRepository extends JpaRepository<Identifier,Long>{

	Identifier findByCpf(Long cpf);
	


}
