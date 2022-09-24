package com.busy.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busy.apis.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	
	Usuario findByCpf(Long cpf);

}
