package com.luanhroliveira.wearableandhealth.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luanhroliveira.wearableandhealth.dto.SensorDTO;
import com.luanhroliveira.wearableandhealth.services.SensorService;
import com.luanhroliveira.wearableandhealth.services.exceptions.DataIntegrityException;

@RestController
@RequestMapping(value = "/sensores")
public class SensorController {

	@Autowired
	private SensorService sensorService;

	@GetMapping
	public ResponseEntity<List<SensorDTO>> findAll() {
		List<SensorDTO> listSensor = sensorService.findAll();
		return ResponseEntity.ok().body(listSensor);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<SensorDTO>> findById(@PathVariable Long id) {
		Optional<SensorDTO> sensor = sensorService.findById(id);
		return ResponseEntity.ok().body(sensor);
	}

	@PostMapping
	public ResponseEntity<SensorDTO> insert(@Valid @RequestBody SensorDTO dto) {
		try {
			dto = sensorService.insert(dto);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(dto.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException(e.getMessage());
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<SensorDTO> update(@PathVariable Long id, @Valid @RequestBody SensorDTO dto) {
		dto = sensorService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}
