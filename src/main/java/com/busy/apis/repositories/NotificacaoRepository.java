package com.busy.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busy.apis.entities.Notification;

public interface NotificacaoRepository extends JpaRepository<Notification, Long> {
	Notification findByUsuario(Long usuario);
	void deleteById(Long id);

}
