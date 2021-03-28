package com.luanhroliveira.wearableandhealth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luanhroliveira.wearableandhealth.entitites.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

	/*
	 * @Transactional(readOnly = true)
	 * 
	 * @Query("SELECT DISTINCT obj FROM Sensor obj INNER JOIN obj.monitoramento mon INNER JOIN mon.usuario usu WHERE obj.nome LIKE %:nome% AND usu IN :usuarios"
	 * ) Page<Sensor> search(@Param("nome") String nome, @Param("usuarios")
	 * List<Usuario> usuarios, Pageable pageRequest);
	 */
	// Page<Sensor> findBy

}
