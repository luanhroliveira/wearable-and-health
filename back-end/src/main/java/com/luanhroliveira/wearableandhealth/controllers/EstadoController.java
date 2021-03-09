package com.luanhroliveira.wearableandhealth.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
