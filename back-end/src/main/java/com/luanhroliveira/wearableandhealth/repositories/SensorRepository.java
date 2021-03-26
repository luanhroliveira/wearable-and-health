package com.luanhroliveira.wearableandhealth.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.entitites.Sensor;
import com.luanhroliveira.wearableandhealth.entitites.Usuario;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

	/*
	 * @Transactional(readOnly = true)
	 * 
	 * @Query("SELECT DISTINCT obj FROM Sensor obj INNER JOIN obj.monitoramento mon INNER JOIN mon.usuario usu WHERE obj.nome LIKE %:nome% AND usu IN :usuarios"
	 * ) Page<Sensor> search(@Param("nome") String nome, @Param("usuarios")
	 * List<Usuario> usuarios, Pageable pageRequest);
	 */
	//Page<Sensor> findBy
	
}
