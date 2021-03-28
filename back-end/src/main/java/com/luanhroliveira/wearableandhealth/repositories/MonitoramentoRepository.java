package com.luanhroliveira.wearableandhealth.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luanhroliveira.wearableandhealth.entitites.Monitoramento;
import com.luanhroliveira.wearableandhealth.entitites.Sensor;
import com.luanhroliveira.wearableandhealth.entitites.Usuario;

public interface MonitoramentoRepository extends JpaRepository<Monitoramento, Long> {

	/*
	 * @Query("SELECT DISTINCT obj FROM Monitoramento obj INNER JOIN obj.usuario usu WHERE obj.nome LIKE %:nome% AND usu IN :usuarios"
	 * ) Page<Monitoramento> search(@Param("nome") String nome, @Param("usuarios")
	 * List<Usuario> usuarios, Pageable pageRequest);
	 */

	Page<Monitoramento> findBySensorAndUsuario(Sensor sensor, Usuario usuario, Pageable pageRequest);

}