package com.luanhroliveira.wearableandhealth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luanhroliveira.wearableandhealth.entitites.Monitoramento;

public interface MonitoramentoRepository extends JpaRepository<Monitoramento, Long> {

}