package com.busy.apis.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busy.apis.entities.Order;
import com.busy.apis.entities.Usuario;

public interface OrderRepository extends JpaRepository<Order, Long> {
	void deleteById(Long id);
	List<Order> findAllByUsuario(Usuario usuario);
	Optional<Order> findById(Long id);
}
