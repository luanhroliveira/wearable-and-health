package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.SensorDTO;
import com.luanhroliveira.wearableandhealth.entitites.Sensor;
import com.luanhroliveira.wearableandhealth.repositories.SensorRepository;

@Service
public class SensorService {

	@Autowired
	private SensorRepository sensorRepository;

	@Transactional(readOnly = true)
	public List<SensorDTO> findAll() {
		List<Sensor> sensor = sensorRepository.findAll();
		return sensor.stream().map(x -> new SensorDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Optional<SensorDTO> findById(Long id) {
		Optional<Sensor> sensor = sensorRepository.findById(id);
		return Optional.ofNullable(sensor.map(x -> new SensorDTO(x)).get());
	}
}
