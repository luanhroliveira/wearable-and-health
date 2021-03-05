package com.luanhroliveira.wearableandhealth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luanhroliveira.wearableandhealth.entitites.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}