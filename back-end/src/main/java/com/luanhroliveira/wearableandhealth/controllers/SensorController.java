package com.luanhroliveira.wearableandhealth.controllers;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luanhroliveira.wearableandhealth.controllers.utils.URL;
import com.luanhroliveira.wearableandhealth.dto.SensorDTO;
import com.luanhroliveira.wearableandhealth.entitites.Sensor;
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

	/*
	 * @GetMapping(value = "/page") public ResponseEntity<Page<SensorDTO>>
	 * findPage(@RequestParam(value = "nome", defaultValue = "") String nome,
	 * 
	 * @RequestParam(value = "usuarios", defaultValue = "") String usuarios,
	 * 
	 * @RequestParam(value = "page", defaultValue = "0") Integer page,
	 * 
	 * @RequestParam(value = "linesPerPage", defaultValue = "24") Integer
	 * linesPerPage,
	 * 
	 * @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
	 * 
	 * @RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction
	 * direction) { String nomeDecode = URL.decodeParam(nome); List<Integer>
	 * idUsuarios = Arrays.asList(usuarios.split(",")).stream().map(x ->
	 * Integer.parseInt(x)) .collect(Collectors.toList());
	 * 
	 * Page<Sensor> sensores = SensorService.search(nomeDecode, idUsuarios, page,
	 * linesPerPage, direction, orderBy); return
	 * ResponseEntity.ok().body(sensores.map(x -> new SensorDTO(x))); }
	 */

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

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<SensorDTO> delete(@PathVariable Long id) {
		sensorService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
