package com.luanhroliveira.wearableandhealth.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luanhroliveira.wearableandhealth.dto.UsuarioDTO;
import com.luanhroliveira.wearableandhealth.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<UsuarioDTO> listUsuario = usuarioService.findAll();
		return ResponseEntity.ok().body(listUsuario);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<UsuarioDTO>> findById(@PathVariable Long id) {
		Optional<UsuarioDTO> usuario = Optional.ofNullable(usuarioService.findById(id));
		return ResponseEntity.ok().body(usuario);
	}
}
