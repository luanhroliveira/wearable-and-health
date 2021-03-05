package com.luanhroliveira.wearableandhealth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luanhroliveira.wearableandhealth.entitites.Localizacao;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {

}