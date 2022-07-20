package com.busy.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busy.apis.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
