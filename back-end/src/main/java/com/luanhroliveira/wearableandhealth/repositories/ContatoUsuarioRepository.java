package com.luanhroliveira.wearableandhealth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.entitites.ContatoUsuario;

public interface ContatoUsuarioRepository extends JpaRepository<ContatoUsuario, Long> {
	@Transactional(readOnly = true)
	ContatoUsuario findByEmail(String email);
}