package com.luanhroliveira.wearableandhealth.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luanhroliveira.wearableandhealth.dto.EnderecoUsuarioDTO;
import com.luanhroliveira.wearableandhealth.services.EnderecoUsuarioService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoUsuarioController {

	@Autowired
	private EnderecoUsuarioService enderecoService;

	@GetMapping
	public ResponseEntity<List<EnderecoUsuarioDTO>> findAll() {
		List<EnderecoUsuarioDTO> enderecos = enderecoService.findAll();
		return ResponseEntity.ok().body(enderecos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<EnderecoUsuarioDTO>> findById(@PathVariable Long id) {
		Optional<EnderecoUsuarioDTO> endereco = enderecoService.findById(id);
		return ResponseEntity.ok().body(endereco);
	}
}
