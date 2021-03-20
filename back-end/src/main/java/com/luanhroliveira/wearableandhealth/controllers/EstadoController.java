package com.luanhroliveira.wearableandhealth.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luanhroliveira.wearableandhealth.dto.EstadoDTO;
import com.luanhroliveira.wearableandhealth.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	@GetMapping
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<EstadoDTO> listEstado = estadoService.findAll();
		return ResponseEntity.ok().body(listEstado);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<EstadoDTO>> findById(@PathVariable Long id) {
		Optional<EstadoDTO> estado = estadoService.findById(id);
		return ResponseEntity.ok().body(estado);
	}

	@PostMapping
	public ResponseEntity<EstadoDTO> insert(@RequestBody EstadoDTO dto) {
		dto = estadoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<EstadoDTO> delete(@PathVariable Long id) {
		estadoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
